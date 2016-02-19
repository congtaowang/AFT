package cn.aft.framework.mvp;

import java.lang.ref.SoftReference;

import cn.aft.tools.Predictor;

/**
 * 2016/1/1 by congtaowang
 * Version 1.0
 */
public abstract class BasePresenter<V extends BaseView> {

    private SoftReference<V> mViewRef;

    protected void attachView(V view) {
        if (Predictor.isNull(view)) {
            throw new NullPointerException("BasePresenter#attechView view can not be null");
        }
        mViewRef = new SoftReference<V>(view);
    }

    protected boolean isViewAttached() {
        return Predictor.isNotEmpty(mViewRef) && Predictor.isNotEmpty(mViewRef.get());
    }

    protected V getView() {
        return mViewRef.get();
    }

    protected void detachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
