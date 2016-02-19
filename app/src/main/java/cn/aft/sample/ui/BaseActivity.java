package cn.aft.sample.ui;

import android.os.Bundle;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;

/**
 * 2016/02/18 by congtaowang.
 * Version 1.0
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseMvpActivity<V, P> {

    protected String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showToastMsg("测试");
        super.onCreate(savedInstanceState);
    }
}
