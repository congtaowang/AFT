package cn.aft.tools;

import android.app.Activity;
import android.content.Intent;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public final class Launcher {

    public static final void launch(Activity activity, Class<?> clz) {
        Assert.notNull(activity);
        activity.startActivity(new Intent(activity, clz));
    }
}
