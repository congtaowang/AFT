package cn.aft.sample.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.aft.framework.listener.OnOnceClickListener;
import cn.aft.sample.R;
import cn.aft.sample.adapter.delegate.SimpleClickDelegate;
import cn.aft.template.adapter.BaseViewHolder;
import cn.aft.tools.Predictor;

/**
 * 16/1/26 by congtaowang.
 * Version 1.0
 */
public class SimpleViewHolder implements BaseViewHolder<String> {

    private SimpleClickDelegate delegate;

    @Bind(R.id.text)
    TextView text;

    @Bind(R.id.img)
    ImageView img;

    public SimpleViewHolder(SimpleClickDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void attachView(View itemView) {
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(String data, final int position) {
        text.setText(data);
        text.setOnClickListener(new OnOnceClickListener() {
            @Override
            public void onOnceClick(View v) {
                if (Predictor.isNotNull(delegate)) {
                    delegate.onItemClick(position);
                }
            }
        });
    }
}
