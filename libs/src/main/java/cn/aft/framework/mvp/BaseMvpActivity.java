package cn.aft.framework.mvp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import cn.aft.framework.listener.OnOnceClickListener;
import cn.aft.tools.TipToast;

/**
 * 2016年1月1日 by congtaowang
 * <p>
 * Version 1.0
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends FragmentActivity
        implements BaseView {

    protected P _presenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _presenter = createPresenterInstance();
        if (_presenter != null) {
            _presenter.attachView((V) this);
        }
        setContentView(getLayoutId());
        onViewCreated();
    }

    /**
     * Invoked before {@link #setContentView(int)}
     */
    protected abstract P createPresenterInstance();

    protected abstract int getLayoutId();

    /**
     * Invoked after {@link #setContentView(int)}
     */
    protected abstract void onViewCreated();

    @Override
    public Activity visitActivity() {
        return getActivity();
    }

    protected Activity getActivity() {
        return this;
    }

    @Override
    public void showToastMsg(String msg) {
        TipToast.shortTip(msg);
    }

    @Override
    public void showToastMsg(int resId) {
        TipToast.shortTip(resId);
    }

    @Override
    public void showProgressingDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    /**
     * Invoke the method after you have implemented method {@link BaseMvpActivity#onViewClicked(View,int)}
     *
     * @param id
     */
    protected void attachClickListener(int id) {
        View view = findViewById(id);
        if (view != null) {
            view.setOnClickListener(clickListener);
        }
    }

    private OnOnceClickListener clickListener = new OnOnceClickListener() {
        @Override
        public void onOnceClick(View v) {
            onViewClicked(v, v.getId());
        }
    };

    /**
     * Clicked views' implementation
     *
     * @param view
     * @param id
     */
    protected void onViewClicked(View view, int id) {

    }

    @Override
    protected void onDestroy() {
        if (_presenter != null) {
            _presenter.detachView();
        }
        super.onDestroy();
    }

}
