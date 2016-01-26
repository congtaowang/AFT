package cn.aft.tools;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2016年1月1日 by congtaowang
 * <p/>
 * Version 1.0
 */
public class Predictor {

    //TODO Object prediction
    public static <T> boolean isNull(T obj) {
        return obj == null;
    }

    public static <T> boolean isNotNull(T obj) {
        return !isNull(obj);
    }

    public static <T> boolean isEmpty(T obj) {
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() != 0;
        }
        return isNull(obj);
    }

    public static <T> boolean isNotEmpty(T obj) {
        return !isEmpty(obj);
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return isNull(collection) || collection.size() == 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return isNull(map) || map.size() == 0;
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    public static <T> boolean isEmpty(T[] arr) {
        return isNull(arr) || arr.length == 0;
    }

    public static <T> boolean isNotEmpty(T[] arr) {
        return !isEmpty(arr);
    }

    //TODO Data prediction
    private static Pattern mpnPattern = Pattern.compile("^((1[3|5|8][0-9])|(14[5|7])|(17[0|[6-8]]))\\d{8}$");

    public static boolean isMobilePhoneNumber(String number) {
        if (isEmpty(number)) {
            return false;
        }
        Matcher matcher = mpnPattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isNotMobilePhoneNumber(String number) {
        return !isMobilePhoneNumber(number);
    }
}
