package cn.aft.template.adapter;

import android.view.View;

/**
 * 16/1/12 by congtaowang.
 * Version 1.0
 */
public interface BaseViewHolder<T> {

    void attachView(View itemView);

    void bindData(T data, int position);
}
