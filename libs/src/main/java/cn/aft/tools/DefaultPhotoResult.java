package cn.aft.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class DefaultPhotoResult implements PhotoResult<String> {

    @Override
    public String get(Context context, Intent data) {
        return localQuery(context.getContentResolver(), data.getData());
    }

    private String localQuery(ContentResolver resolver, Uri uri) {
        Cursor cursor = resolver.query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
        if (Predictor.isNotNull(cursor) && cursor.moveToFirst()) {
            String imgPath = cursor.getString(0);
            cursor.close();
            return imgPath;
        } else {
            return null;
        }
    }
}
