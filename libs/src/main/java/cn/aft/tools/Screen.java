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
     * 获取屏幕宽度，多线程同步
     *
     * @param context
     * @return
     */
    public static int getWidth(Context context) {
        if (screenWidth == 0) {
            synchronized (syncObj) {
                if (dm == null) {
                    dm = new DisplayMetrics();
                    System.out.println("Init dm1");
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
     * 获取屏幕高度，多线程同步
     *
     * @param context
     * @return
     */
    public static int getHeight(Context context) {
        if (screenHeight == 0) {
            synchronized (syncObj) {
                if (dm == null) {
                    System.out.println("Init dm2");
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
     * 将屏幕调节到正常亮度 {@link WindowManager} #alpha=1.0
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
     * 调节屏幕亮度
     *
     * @param activity
     * @param alpha    0.0~1.0 值越大，屏幕越亮
     */
    public static void becomeDark(Activity activity, float alpha) {
        if (activity instanceof Activity) {
            WindowManager.LayoutParams params = activity.getWindow().getAttributes();
            params.alpha = alpha;
            activity.getWindow().setAttributes(params);
        }
    }

    /**
     * dip转为 px
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * px 转为 dip
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
