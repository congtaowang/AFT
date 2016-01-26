package cn.aft.template.popupwindow;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * 16/1/12 by congtaowang.
 * Version 1.0
 */
public abstract class BasePopupWindow extends PopupWindow {

    private Activity baseActivity;

    public BasePopupWindow(Activity baseActivity) {
        super(baseActivity);
        this.baseActivity = baseActivity;
        initWindowAttrs();
        View contentView = createWindowContentView();
        setContentView(contentView);
        onViewCreated(contentView);
    }

    private View createWindowContentView() {
        return LayoutInflater.from(baseActivity).inflate(getWindowLayoutId(), null);
    }

    private void initWindowAttrs() {
        setWidth(getWindowWidth());
        setHeight(getWindowHeight());
        setFocusable(true);
        setOutsideTouchable(enableOutsideTouch());
        if (enableOutsideTouch()) {
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        otherAttrs();
        update();
    }

    protected void otherAttrs() {

    }

    protected boolean enableOutsideTouch() {
        return true;
    }

    protected abstract int getWindowWidth();

    protected abstract int getWindowHeight();

    protected abstract int getWindowLayoutId();

    protected abstract void onViewCreated(View contentView);
}
