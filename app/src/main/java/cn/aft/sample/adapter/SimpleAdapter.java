package cn.aft.sample.adapter;

import java.util.List;

import cn.aft.sample.R;
import cn.aft.sample.adapter.delegate.SimpleClickDelegate;
import cn.aft.template.adapter.BaseViewHolder;
import cn.aft.template.adapter.BaseViewHolderAdapter;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class SimpleAdapter extends BaseViewHolderAdapter<String> {

    private SimpleClickDelegate delegate;

    public SimpleAdapter(List<String> datas, SimpleClickDelegate delegate) {
        super(datas);
        this.delegate = delegate;
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.widget_simple_item;
    }

    @Override
    protected BaseViewHolder<String> createViewHolder(int position) {
        return new SimpleViewHolder(delegate);
    }
}
