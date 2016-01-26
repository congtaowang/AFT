package cn.aft.sample.ui;

import android.content.Intent;
import android.view.View;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.sample.R;
import cn.aft.sample.presenter.MainPresenter;
import cn.aft.sample.view.MainView;

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
        attachClickListener(R.id.toast);
        attachClickListener(R.id.baseAdapter);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.toast:
                showToastMsg("Toast");
                break;
            case R.id.baseAdapter:
                Intent intent = new Intent(getActivity(), SimpleAdapterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
