package cn.aft.sample.adapter;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.aft.sample.AFTApplicatioin;
import cn.aft.sample.R;
import cn.aft.sample.bean.SimpleDisplayer;
import cn.aft.template.adapter.BaseViewHolder;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public class SimpleFrescoImageViewHolder implements BaseViewHolder<SimpleDisplayer> {

    @Bind(R.id.pic) SimpleDraweeView pic;
    @Bind(R.id.desc) TextView desc;

    @Override
    public void attachView(View itemView) {
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void bindData(SimpleDisplayer data, int position) {
        desc.setText(data.getDesc());
        if (!(pic.getTag() instanceof GenericDraweeHierarchy)) {
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(AFTApplicatioin.getInstance().getResources());
            builder.setFadeDuration(300).setProgressBarImage(new ProgressBarDrawable());
            GenericDraweeHierarchy hierarchy = builder.build();
            hierarchy.setPlaceholderImage(R.drawable.ic_placeholder);
            pic.setHierarchy(hierarchy);
        }
        ImageRequest lowResImageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(data.getThumbPic()))
                .setAutoRotateEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setLowResImageRequest(lowResImageRequest)
                .setUri(Uri.parse(data.getPic())).build();
        pic.setController(controller);
    }
}
