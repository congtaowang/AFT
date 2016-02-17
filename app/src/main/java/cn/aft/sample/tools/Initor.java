package cn.aft.sample.tools;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.aft.sample.AFTApplicatioin;
import cn.aft.tools.LauncherManager;
import cn.aft.tools.TipToast;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class Initor {
    public static void init(AFTApplicatioin app) {
        TipToast.init(app);
        Fresco.initialize(app);
        LauncherManager.initLauncher(new ExtLauncherImpl());
    }
}
