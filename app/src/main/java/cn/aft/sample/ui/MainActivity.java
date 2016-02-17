package cn.aft.sample.ui;

import android.view.View;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.sample.R;
import cn.aft.sample.presenter.MainPresenter;
import cn.aft.sample.ui.pattern.PatternsActivity;
import cn.aft.sample.view.MainView;
import cn.aft.tools.LauncherManager;

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
        attachClickListener(R.id.recyclerImageView);
        attachClickListener(R.id.album);
        attachClickListener(R.id.designPattern);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.toast:
                showToastMsg("Toast");
                break;
            case R.id.baseAdapter:
                LauncherManager.getLauncher().launch(getActivity(), SimpleAdapterActivity.class);
                break;
            case R.id.recyclerImageView:
                LauncherManager.getLauncher().launch(getActivity(), SimpleFrescoImageViewsActivity.class);
                break;
            case R.id.album:
                LauncherManager.getLauncher().launch(getActivity(), AlbumActivity.class);
                break;
            case R.id.designPattern:
                LauncherManager.getLauncher().launch(getActivity(), PatternsActivity.class);
                break;
        }
    }
}
