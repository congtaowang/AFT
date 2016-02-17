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
 * Scan all image
 * 
 * @author congtaowang
 *
 */
public class DefaultAlbumScannerRunnable implements Runnable {

	private Cursor cursor;
	private NativeAlbumLoadedCallBack callBack;

	public static final String TAG = DefaultAlbumScannerRunnable.class
			.getName();

	public DefaultAlbumScannerRunnable(Context context,
			NativeAlbumLoadedCallBack callBack) {
		super();
		this.cursor = createCursor(context);
		this.callBack = callBack;
	}

	@Override
	public void run() {
		ArrayList<NativeImageInfo> photoEntities = new ArrayList<NativeImageInfo>();
		if (cursor != null) {
			String[] projections = projections();
			int photoIndex = cursor.getColumnIndex(projections[0]);
			int orientationIndex = cursor.getColumnIndex(projections[1]);
			int sizeIndex = cursor.getColumnIndex(projections[2]);
			while (cursor.moveToNext()) {
				NativeImageInfo entity = new NativeImageInfo();
				entity.url = "file://" + cursor.getString(photoIndex);
				entity.orientation = cursor.getInt(orientationIndex);
				entity.size = cursor.getInt(sizeIndex);
				photoEntities.add(entity);
			}
			cursor.close();
		}
		postInUiThread(photoEntities, callBack);
	}

	private Cursor createCursor(Context context) {
		ContentResolver photoResolver = context.getContentResolver();
		Uri photoUri = Media.EXTERNAL_CONTENT_URI;
		Cursor cursor = photoResolver.query(photoUri, projections(),
				selection(), selectionArgs(), sortOrder());
		return cursor;
	}

	private String[] projections() {
		return new String[] { //
		ImageColumns.DATA,//
				ImageColumns.ORIENTATION,//
				ImageColumns.SIZE };
	}

	private String selection() {
		return Media.MIME_TYPE + "=? or " + Media.MIME_TYPE + "=?";
	}

	private String[] selectionArgs() {
		return new String[] { "image/jpeg", "image/png" };
	}

	private String sortOrder() {
		return ImageColumns.DATE_MODIFIED + " desc";
	}

	private void postInUiThread(final ArrayList<NativeImageInfo> photoEntities,
			final NativeAlbumLoadedCallBack callBack) {
		ExecutorsServiceUtils.removeExecuteEntity(TAG);
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run() {
				Map<String, ArrayList<NativeImageInfo>> entities = new HashMap<String, ArrayList<NativeImageInfo>>();
				entities.put("all", photoEntities);
				callBack.onNativeAlbumLoaded(entities);
			}
		});
	}

}
