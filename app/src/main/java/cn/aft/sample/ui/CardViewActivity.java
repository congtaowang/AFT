package cn.aft.sample.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.R;
import cn.aft.sample.adapter.CardViewAdapter;
import cn.aft.sample.adapter.MarginItemDecoration;
import cn.aft.sample.tools.BeanFactory;

/**
 * 16/2/18 by congtaowang.
 * Version 1.0
 */
public class CardViewActivity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Bind(R.id.cardViews)
    RecyclerView cardViews;

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cardview;
    }

    @Override
    protected void onViewCreated() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        cardViews.setLayoutManager(manager);
        cardViews.addItemDecoration(new MarginItemDecoration());
        CardViewAdapter adapter = new CardViewAdapter(BeanFactory.createCards());
        cardViews.setAdapter(adapter);
    }
}
