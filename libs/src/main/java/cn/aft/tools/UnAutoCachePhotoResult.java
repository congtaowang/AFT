package cn.aft.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import java.io.File;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class UnAutoCachePhotoResult implements PhotoResult<String> {

    @Override
    public String get(Context context, Intent data) {
        Bitmap bitmap = Predictor.isNotNull(data.getExtras()) ? ((Bitmap) data.getExtras().get("data")) : null;
        if (Predictor.isNotNull(bitmap)) {
            String preserverPath = Album.getPath() + File.separator + System.currentTimeMillis() + ".jpg";
            if (saveBitmap(bitmap, preserverPath)) {
                return preserverPath;
            }
        }
        return null;
    }

    private boolean saveBitmap(Bitmap bitmap, String preserverPath) {
        ContentPreserver<Bitmap> bitmapPreserver = new BitmapPreserver(preserverPath);
        return bitmapPreserver.save(bitmap);
    }

}
