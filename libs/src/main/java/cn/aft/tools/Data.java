package cn.aft.tools;

import java.util.Collection;
import java.util.Map;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class Data {

    public static <T> int getSize(Collection<T> collection) {
        return Predictor.isEmpty(collection) ? 0 : collection.size();
    }

    public static <K, V> int getSize(Map<K, V> map) {
        return Predictor.isEmpty(map) ? 0 : map.size();
    }

    public static <T> int getSize(T[] arr) {
        return Predictor.isEmpty(arr) ? 0 : arr.length;
    }
}
