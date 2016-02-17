package cn.aft.sample.album;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.ImageColumns;

import cn.aft.sample.album.bean.NativeImageInfo;

public class NativeImageLoader {

	private static NativeImageLoader INSTANCE;

	static {
		INSTANCE = new NativeImageLoader();
	}

	public static NativeImageLoader getImageLoader() {
		return INSTANCE;
	}

	public void loadNativeAlbum(Context context, NativeAlbumLoadedCallBack callBack, boolean groupByGroup)
			throws NullPointerException {
		if (context == null || callBack == null) {
			throw new NullPointerException("context or callBack can't be null");
		}

		Runnable entity = null;
		if (groupByGroup) {
			entity = new AlbumScannerRunnable(context, callBack);
		} else {
			entity = new DefaultAlbumScannerRunnable(context, callBack);
		}
		ExecutorsServiceUtils.startExecutorThread(entity, DefaultAlbumScannerRunnable.TAG);
	}

	public static NativeImageInfo get(Context context, Uri uri) {
		Cursor cursor = context.getContentResolver().query(uri, new String[] { //
				ImageColumns.DATA,//
						ImageColumns.ORIENTATION,//
						ImageColumns.SIZE }, null, null, null);
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				NativeImageInfo nii = new NativeImageInfo();
				nii.url = "file://" + cursor.getString(cursor.getColumnIndex(ImageColumns.DATA));
				nii.orientation = cursor.getInt(cursor.getColumnIndex(ImageColumns.ORIENTATION));
				nii.size = cursor.getInt(cursor.getColumnIndex(ImageColumns.SIZE));
				cursor.close();
				return nii;
			}
			cursor.close();
		}
		return null;
	}

}
