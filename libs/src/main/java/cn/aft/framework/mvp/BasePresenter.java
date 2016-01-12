package cn.aft.framework.mvp;

import java.lang.ref.SoftReference;

/**
 * 2016年1月1日 by congtaowang
 *
 * Version 1.0
 */
public abstract class BasePresenter<V extends BaseView> {

    private SoftReference<V> mViewRef;

    protected void attechView(V view) {
        if (view == null) {
            throw new NullPointerException("BasePresenter#attechView view can not be null");
        }
        mViewRef = new SoftReference<V>(view);
    }

    protected boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    protected V getView() {
        return mViewRef.get();
    }

    protected void dettachView() {
        if (isViewAttached()) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
