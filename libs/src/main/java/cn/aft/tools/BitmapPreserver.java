package cn.aft.tools;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class BitmapPreserver implements ContentPreserver<Bitmap> {

    private String preserverPath;

    public BitmapPreserver(String preserverPath) {
        this.preserverPath = preserverPath;
    }

    @Override
    public boolean save(Bitmap bmp) {
        if (bmp == null || bmp.isRecycled()) {
            return false;
        }
        File f = new File(preserverPath);
        try {
            f.createNewFile();
            try {
                FileOutputStream fos = new FileOutputStream(new File(preserverPath));
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
