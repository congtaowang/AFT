package cn.aft.weather.ui.presenter;

import com.hwangjr.rxbus.RxBus;

import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class BasePresenterDecorator<V extends BaseView> extends BasePresenter<V> {

    @Override
    protected void attachView(V view) {
        super.attachView(view);
        RxBus.get().register(this);
    }

    @Override
    protected void detachView() {
        super.detachView();
        RxBus.get().unregister(this);
    }
}
