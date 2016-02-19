package cn.aft.tools;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */

public class Screen {

    private static int screenWidth;
    private static int screenHeight;

    private static Object syncObj = new Object();
    private static DisplayMetrics dm = null;

    /**
     * Get width of phone window
     *
     * @param context
     * @return width value
     */
    public static int getWidth(Context context) {
        if (screenWidth == 0) {
            synchronized (syncObj) {
                if (dm == null) {
                    dm = new DisplayMetrics();
                    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    wm.getDefaultDisplay().getMetrics(dm);
                    screenWidth = dm.widthPixels;
                } else {
                    screenWidth = dm.widthPixels;
                }
            }
        }
        return screenWidth;
    }

    /**
     * Get height of phone window
     *
     * @param context
     * @return height value
     */
    public static int getHeight(Context context) {
        if (screenHeight == 0) {
            synchronized (syncObj) {
                if (dm == null) {
                    dm = new DisplayMetrics();
                    WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    wm.getDefaultDisplay().getMetrics(dm);
                    screenHeight = dm.heightPixels;
                } else {
                    screenHeight = dm.heightPixels;
                }
            }
        }
        return screenHeight;
    }

    /**
     * Set window's alpha to 1.0
     *
     * @param activity
     */
    public static void becomeNormal(Activity activity) {
        if (activity instanceof Activity) {
            WindowManager.LayoutParams params = activity.getWindow().getAttributes();
            params.alpha = 1.0f;
            activity.getWindow().setAttributes(params);
        }
    }

    /**
     * Set window's alpha to what you want
     *
     * @param activity
     * @param alpha    0.0~1.0
     */
    public static void becomeDark(Activity activity, float alpha) {
        if (activity instanceof Activity) {
            WindowManager.LayoutParams params = activity.getWindow().getAttributes();
            params.alpha = alpha;
            activity.getWindow().setAttributes(params);
        }
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
