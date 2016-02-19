package cn.aft.tools;

import android.content.Context;
import android.content.Intent;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public interface PhotoResult<T> {

    T get(Context context, Intent data);
}
