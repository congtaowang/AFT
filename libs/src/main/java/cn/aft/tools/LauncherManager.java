package cn.aft.tools;

/**
 * 16/2/12 by congtaowang.
 * Version 1.0
 */
public class LauncherManager {

    private static Launcher launcher = new LauncherImpl();

    public static Launcher getLauncher() {
        return launcher;
    }

    public static void initLauncher(Launcher launcher) {
        if (Predictor.isNotNull(launcher)) {
            LauncherManager.launcher = launcher;
        }
    }
}
