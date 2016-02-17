package cn.aft.sample.ui.pattern;

import android.view.View;

import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.R;
import cn.aft.tools.LauncherManager;

/**
 * 16/1/31 by congtaowang.
 * Version 1.0
 */
public class PatternsActivity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_patterns;
    }

    @Override
    protected void onViewCreated() {
        attachClickListener(R.id.chainOfResponsibility);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.chainOfResponsibility:
                LauncherManager.getLauncher().launch(getActivity(), ChainOfResponsibilityPatternActivity.class);
                break;
        }
    }
}
