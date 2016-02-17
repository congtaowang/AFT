package cn.aft.sample.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.ImageColumns;
import android.provider.MediaStore.Images.Media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.aft.sample.album.bean.NativeImageInfo;

/**
 * Scan image order by folder
 *
 * @author congtaowang
 */
public class AlbumScannerRunnable implements Runnable {

    private NativeAlbumLoadedCallBack callBack;

    private ContentResolver photoResolver;
    private Uri photoUri = Media.EXTERNAL_CONTENT_URI;

    public AlbumScannerRunnable(Context context, NativeAlbumLoadedCallBack callBack) {
        this.callBack = callBack;
        photoResolver = context.getContentResolver();
    }

    @Override
    public void run() {
        Cursor cursor = getImageFolderCursor();
        Map<String, ArrayList<NativeImageInfo>> entitiesMap = new HashMap<String, ArrayList<NativeImageInfo>>();
        if (cursor != null && cursor.moveToFirst()) {
            FolderColumnsIndex index = createFolderColumnsIndex(cursor);
            do {
                String folderName = cursor.getString(index.folderName);
                ArrayList<NativeImageInfo> entities = getNativeImagesByFolder(folderName);
                entitiesMap.put(folderName, entities);
            } while (cursor.moveToNext());
            cursor.close();
        }
        postInUiThread(entitiesMap, callBack);

    }

    private void postInUiThread(final Map<String, ArrayList<NativeImageInfo>> photoEntities,
                                final NativeAlbumLoadedCallBack callBack) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                ExecutorsServiceUtils.removeExecuteEntity(DefaultAlbumScannerRunnable.TAG);
                callBack.onNativeAlbumLoaded(photoEntities);
            }
        });
    }

    private ArrayList<NativeImageInfo> getNativeImagesByFolder(String folderName) {
        Cursor cursor = getImageCursorByFolderName(folderName);
        ArrayList<NativeImageInfo> entities = new ArrayList<NativeImageInfo>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String[] projections = projections();
                int photoIndex = cursor.getColumnIndex(projections[0]);
                int orientationIndex = cursor.getColumnIndex(projections[1]);
                int sizeIndex = cursor.getColumnIndex(projections[2]);
                do {
                    NativeImageInfo entity = new NativeImageInfo();
                    entity.orientation = cursor.getInt(orientationIndex);
                    entity.url = cursor.getString(photoIndex);
                    entity.size = cursor.getInt(sizeIndex);
                    entities.add(entity);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return entities;
    }

    private Cursor getImageCursorByFolderName(String folderName) {
        Cursor cursor = photoResolver.query(photoUri,//
                projections(),//
                "(" + Media.MIME_TYPE + "=? or " + Media.MIME_TYPE + "=?) and " + ImageColumns.BUCKET_DISPLAY_NAME
                        + "=?",//
                new String[]{"image/jpeg", "image/png", folderName},//
                Media.DATE_MODIFIED);
        return cursor;
    }

    private String[] projections() {
        return new String[]{ //
                ImageColumns.DATA,//
                ImageColumns.ORIENTATION,//
                ImageColumns.SIZE};
    }

    private FolderColumnsIndex createFolderColumnsIndex(Cursor cursor) {
        FolderColumnsIndex index = new FolderColumnsIndex();
        index.folderName = cursor.getColumnIndex(ImageColumns.BUCKET_DISPLAY_NAME);
        return index;
    }

    private class FolderColumnsIndex {
        int folderName;
    }

    private Cursor getImageFolderCursor() {

        return photoResolver.query(photoUri, //
                getImageFolderProjection(), //
                getImageFolderSelection(), //
                getImageFolderSelectionArgs(), null);
    }

    private String[] getImageFolderProjection() {
        return new String[]{ImageColumns.BUCKET_DISPLAY_NAME,//
                ImageColumns.DATA, //
                "count(_data) as counter", //
                ImageColumns.SIZE, //
                ImageColumns._ID, //
                ImageColumns.ORIENTATION};
    }

    private String getImageFolderSelection() {
        return Media.MIME_TYPE + "=? or " + Media.MIME_TYPE + "=?" + ") group by bucket_display_name --(";
    }

    private String[] getImageFolderSelectionArgs() {
        return new String[]{"image/jpeg", "image/png"};
    }

}
