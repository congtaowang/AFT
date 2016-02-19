package cn.aft.sample.adapter;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.aft.sample.AFTApplicatioin;
import cn.aft.sample.R;
import cn.aft.sample.bean.Card;
import cn.aft.sample.widget.DigitalProgressDrawable;
import cn.aft.tools.Screen;

/**
 * 16/2/18 by congtaowang.
 * Version 1.0
 */
public class CardViewsHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.cardImgDisplayer)
    SimpleDraweeView displayer;
    @Bind(R.id.cardTitle)
    TextView title;
    @Bind(R.id.cardContent)
    TextView content;

    public CardViewsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindCard(Card card) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(card.getImgUrl()))
                .setImageType(ImageRequest.ImageType.SMALL)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(Screen.dip2px(itemView.getContext(), 90), Screen.dip2px(itemView.getContext(), 90)))
                .setAutoRotateEnabled(true).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        if (!(displayer.getTag() instanceof DraweeHierarchy)) {
            //圆角
            RoundingParams roundingParams = RoundingParams.fromCornersRadii(5f, 0, 0, 5f);
            roundingParams.setOverlayColor(Color.parseColor("#f1efef"));
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(AFTApplicatioin.getInstance().getResources());
            GenericDraweeHierarchy hierarchy = builder.setFadeDuration(300)
                    .setProgressBarImage(new DigitalProgressDrawable())
                    .setRoundingParams(roundingParams)
                    .build();
            controller.setHierarchy(hierarchy);
        }
        displayer.setController(controller);

        title.setText(card.getTitle());
        content.setText(card.getContent());
    }

}
