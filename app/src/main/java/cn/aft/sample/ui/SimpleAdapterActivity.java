package cn.aft.sample.ui;

import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.sample.R;
import cn.aft.sample.adapter.SimpleAdapter;
import cn.aft.sample.adapter.delegate.SimpleClickDelegate;
import cn.aft.sample.presenter.SimpleAdapterPresenter;
import cn.aft.sample.view.SimpleAdapterView;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class SimpleAdapterActivity extends BaseMvpActivity<SimpleAdapterView, SimpleAdapterPresenter> implements SimpleAdapterView {


    @Bind(R.id.list) ListView list;

    private SimpleAdapter adapter;

    @Override
    protected SimpleAdapterPresenter createPresenterInstance() {
        return new SimpleAdapterPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_simple_list;
    }

    @Override
    protected void onViewCreated() {
        adapter = new SimpleAdapter(createSimpleData(), new SimpleClickDelegate() {
            @Override
            public void onItemClick(int position) {
                showToastMsg(position + "Clicked");
            }
        });
        list.setAdapter(adapter);
    }

    private ArrayList<String> createSimpleData() {
        ArrayList<String> datas = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            datas.add("Item " + index);
        }
        return datas;
    }
}
