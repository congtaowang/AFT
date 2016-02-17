package cn.aft.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public interface Launcher {

    void launch(Activity launcher, Class<?> clz);

    void launchForResult(Activity launcher, Class<?> clz, int requestCode);

    void launch(Activity launcher, Class<?> clz, Bundle extras);

    void launchForResult(Activity launcher, Class<?> clz, Bundle extras, int requestCode);

    <T extends Serializable> void launch(Activity launcher, Class<?> clz, String extraName, T extraValue);

    <T extends Serializable> void launchForResult(Activity launcher, Class<?> clz, String extraName, T extraValue, int requestCode);

    <T extends Parcelable> void launch(Activity launcher, Class<?> clz, String extraName, T extraValue);

    <T extends Parcelable> void launchForResult(Activity launcher, Class<?> clz, String extraName, T extraValue, int requestCode);

    void launch(Activity launcher, Intent intent);

    void launchForResult(Activity launcher, Intent intent, int requestCode);
}
