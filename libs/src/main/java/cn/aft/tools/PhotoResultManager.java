package cn.aft.tools;

import android.content.Context;
import android.content.Intent;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class PhotoResultManager {

    private PhotoResultManager() {
    }

    private static class PhotoResultManagerHolder {
        private static final PhotoResultManager manager = new PhotoResultManager();
    }

    public static PhotoResultManager getManager() {
        return PhotoResultManagerHolder.manager;
    }

    public String getPath(Context context, Intent data) {
        Assert.notNull(context, data);
        PhotoResult result;
        if (Predictor.isNotNull(data.getData())) {
            result = new DefaultPhotoResult();
        } else {
            result = new UnAutoCachePhotoResult();
        }
        return ((String) result.get(context, data));
    }
}
