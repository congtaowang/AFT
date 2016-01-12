package cn.aft.tools;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2016年1月1日 by congtaowang
 *
 * @Version 1.0
 */
public class Predictor {

	public static <T> boolean isEmpty(T obj) {
		if (obj instanceof CharSequence) {
			return obj != null && ((CharSequence) obj).length() != 0;
		}
		return obj != null;
	}

	public static <T> boolean isNotEmpty(T obj) {
		return !isEmpty(obj);
	}

	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.size() == 0;
	}

	public static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}

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
