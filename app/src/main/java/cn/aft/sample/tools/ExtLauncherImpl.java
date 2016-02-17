package cn.aft.sample.tools;

import android.app.Activity;
import android.content.Intent;

import cn.aft.tools.LauncherImpl;
import cn.aft.tools.TipToast;

/**
 * 16/2/12 by congtaowang.
 * Version 1.0
 */
public class ExtLauncherImpl  extends LauncherImpl{

    @Override
    public void launch(Activity launcher, Intent intent) {
        super.launch(launcher, intent);
        TipToast.shortTip("我启动了一个activity");
    }

    @Override
    public void launchForResult(Activity launcher, Intent intent, int requestCode) {
        super.launchForResult(launcher, intent, requestCode);
        TipToast.shortTip("我启动了一个需要返回result的activity");
    }
}
