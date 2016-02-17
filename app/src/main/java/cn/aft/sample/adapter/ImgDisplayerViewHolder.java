package cn.aft.sample.adapter;

import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
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
import cn.aft.sample.album.bean.NativeImageInfo;
import cn.aft.sample.widget.DigitalProgressDrawable;
import cn.aft.template.adapter.BaseViewHolder;

/**
 * 16/1/29 by congtaowang.
 * Version 1.0
 */
public class ImgDisplayerViewHolder implements BaseViewHolder<NativeImageInfo> {

    @Bind(R.id.imgDisplayer)
    SimpleDraweeView img;

    private int imgWidth;
    private int imgHeight;

    public ImgDisplayerViewHolder(int imgWidth, int imgHeight) {
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
    }

    @Override
    public void attachView(View itemView) {
        ButterKnife.bind(this, itemView);
        RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams) img.getLayoutParams());
        params.width = imgWidth;
        params.height = imgHeight;
        img.setLayoutParams(params);
    }

    @Override
    public void bindData(NativeImageInfo data, int position) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(data.url))
                .setImageType(ImageRequest.ImageType.SMALL)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(imgWidth, imgHeight))
                .setAutoRotateEnabled(true).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        if (!(img.getTag() instanceof DraweeHierarchy)) {
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(AFTApplicatioin.getInstance().getResources());
            GenericDraweeHierarchy hierarchy = builder.setFadeDuration(300)
                    .setProgressBarImage(new DigitalProgressDrawable())
                    .build();
            controller.setHierarchy(hierarchy);
        }
        img.setController(controller);
    }
}
