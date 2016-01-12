package cn.aft;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.presenter.MainPresenter;
import cn.aft.view.MainView;

public class MainActivity extends BaseMvpActivity<MainView, MainPresenter> {

    @Override
    protected MainPresenter createPresenterInstance() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {

    }
}
