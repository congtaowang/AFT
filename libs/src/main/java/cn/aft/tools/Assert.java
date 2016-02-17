package cn.aft.tools;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public final class Assert {

    public static void notNull(Object... objects) {
        for (Object obj : objects) {
            if (Predictor.isNull(obj)) {
                throw new NullPointerException("Null object");
            }
        }
    }
}
