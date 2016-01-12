package cn.aft.framework.listener;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 16/1/12 by congtaowang.
 * Version 1.0
 */

public abstract class OnOnceClickListener implements OnClickListener {

    private long lastClickTime = 0L;
    private long currentClickTime = 0L;

    private final int MIN_CLICK_DELAY_TIME = 500;// ms

    @Override
    public void onClick(View v) {
        currentClickTime = System.currentTimeMillis();
        if (currentClickTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            onOnceClick(v);
        }
        lastClickTime = currentClickTime;
    }

    public abstract void onOnceClick(View v);

}
