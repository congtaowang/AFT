package cn.aft.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 16/2/12 by congtaowang.
 * Version 1.0
 */
public class LauncherImpl implements Launcher {


    @Override
    public void launch(Activity launcher, Class<?> clz) {
        launch(launcher, clz, null);
    }

    @Override
    public void launchForResult(Activity launcher, Class<?> clz, int requestCode) {
        Assert.notNull(launcher, clz);
        launchForResult(launcher, clz, null, requestCode);
    }

    @Override
    public void launch(Activity launcher, Class<?> clz, Bundle extras) {
        Assert.notNull(launcher, clz);
        Intent intent = new Intent(launcher, clz);
        if (Predictor.isNotNull(extras)) {
            intent.putExtras(extras);
        }
        launch(launcher, intent);
    }

    @Override
    public void launchForResult(Activity launcher, Class<?> clz, Bundle extras, int requestCode) {
        Assert.notNull(launcher, clz);
        Intent intent = new Intent(launcher, clz);
        if (Predictor.isNotNull(extras)) {
            intent.putExtras(extras);
        }
        launchForResult(launcher, intent, requestCode);
    }

    @Override
    public <T extends Serializable> void launch(Activity launcher, Class<?> clz, String extraName, T extraValue) {
        if (Predictor.isNotNull(extraName) && Predictor.isNotNull(extraValue)) {
            Bundle extras = new Bundle();
            extras.putSerializable(extraName, extraValue);
            launch(launcher, clz, extras);
        } else {
            launch(launcher, clz);
        }
    }

    @Override
    public <T extends Serializable> void launchForResult(Activity launcher, Class<?> clz, String extraName, T extraValue, int requestCode) {
        if (Predictor.isNotNull(extraName) && Predictor.isNotNull(extraValue)) {
            Bundle extras = new Bundle();
            extras.putSerializable(extraName, extraValue);
            launchForResult(launcher, clz, extras, requestCode);
        } else {
            launchForResult(launcher, clz, requestCode);
        }
    }

    @Override
    public <T extends Parcelable> void launch(Activity launcher, Class<?> clz, String extraName, T extraValue) {
        if (Predictor.isNotNull(extraName) && Predictor.isNotNull(extraValue)) {
            Bundle extras = new Bundle();
            extras.putParcelable(extraName, extraValue);
            launch(launcher, clz, extras);
        } else {
            launch(launcher, clz);
        }
    }

    @Override
    public <T extends Parcelable> void launchForResult(Activity launcher, Class<?> clz, String extraName, T extraValue, int requestCode) {
        if (Predictor.isNotNull(extraName) && Predictor.isNotNull(extraValue)) {
            Bundle extras = new Bundle();
            extras.putParcelable(extraName, extraValue);
            launchForResult(launcher, clz, extras, requestCode);
        } else {
            launchForResult(launcher, clz, requestCode);
        }
    }

    @Override
    public void launch(Activity launcher, Intent intent) {
        launcher.startActivity(intent);
    }

    @Override
    public void launchForResult(Activity launcher, Intent intent, int requestCode) {
        launcher.startActivityForResult(intent, requestCode);
    }
}
