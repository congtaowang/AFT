package cn.aft.framework.mvp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.aft.framework.listener.OnOnceClickListener;
import cn.aft.tools.TipToast;

/**
 * 2016/1/1 by congtaowang
 * <p>
 * Version 1.0
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements
        BaseView {

    protected P _presenter;
    private View contentView;

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _presenter = createPresenterInstance();
        if (_presenter != null) {
            _presenter.attachView((V) this);
        }
    }

    protected abstract P createPresenterInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        contentView = view;
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public Activity visitActivity() {
        return getActivity();
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
     * Invoke the method after you have implemented method {@link BaseMvpFragment#onViewClicked(View, int)}
     *
     * @param id id of view
     */
    protected void attachClickListener(int id) {
        if (contentView != null) {
            View view = contentView.findViewById(id);
            if (view != null) {
                view.setOnClickListener(clickListener);
            }
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
     * @param view which view has clicked
     * @param id   id of view
     */
    protected void onViewClicked(View view, int id) {

    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (_presenter != null) {
            _presenter.detachView();
        }
        super.onDestroy();
    }

}
