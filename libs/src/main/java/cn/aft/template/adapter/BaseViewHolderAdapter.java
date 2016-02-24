package cn.aft.template.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.aft.tools.Data;
import cn.aft.tools.Predictor;

/**
 * 16/1/12 by congtaowang.
 * Version 1.0
 */
public abstract class BaseViewHolderAdapter<T> extends BaseAdapter {

    private List<T> mDatas;

    public BaseViewHolderAdapter(List<T> datas) {
        this.mDatas = datas;
    }

    @Override

    public int getCount() {
        return Data.getSize(mDatas);
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressWarnings("unchecked")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder<T> holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(), null);
            holder = createViewHolder(position);
            if (holder == null) {
                throw new NullPointerException("BaseViewHolderAdapter#getView createViewHolder return null");
            }
            holder.attachView(convertView);
            convertView.setTag(holder);
        } else {
            holder = ((BaseViewHolder<T>) convertView.getTag());
        }
        holder.bindData(getItem(position), position);
        return convertView;
    }

    protected abstract int getItemLayoutId();

    /**
     * @param position which item is building or re using
     * @return can not be null
     */
    protected abstract BaseViewHolder<T> createViewHolder(int position);

    protected List<T> getDatas() {
        return mDatas;
    }

    public void refresh(List<T> newDatas) {
        this.mDatas = newDatas;
        notifyDataSetChanged();
    }

    public void appendRefresh(List<T> appendDatas) {
        if (Predictor.isEmpty(mDatas)) {
            mDatas = new ArrayList<>();
        }
        if (Predictor.isNotEmpty(appendDatas)) {
            mDatas.addAll(appendDatas);
        }
        notifyDataSetChanged();
    }
}
