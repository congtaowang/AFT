package cn.aft.tools;

import android.os.Environment;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class Album {

    public static String getPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
    }
}
