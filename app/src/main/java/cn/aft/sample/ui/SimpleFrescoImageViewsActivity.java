package cn.aft.sample.ui;

import android.widget.ListView;

import butterknife.Bind;
import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.R;
import cn.aft.sample.adapter.SimpleFrescoImagesAdapter;
import cn.aft.sample.tools.BeanFactory;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public class SimpleFrescoImageViewsActivity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Bind(R.id.recyclerImageViews)
    ListView recyclerImageViews;

    private SimpleFrescoImagesAdapter adapter;

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recyclerimageviews;
    }

    @Override
    protected void onViewCreated() {
        adapter = new SimpleFrescoImagesAdapter(BeanFactory.createSimpleDisplayer(100));
        recyclerImageViews.setAdapter(adapter);
    }
}
