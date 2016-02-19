package cn.aft.sample.ui;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.File;

import butterknife.Bind;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.AFTApplicatioin;
import cn.aft.sample.R;
import cn.aft.sample.widget.DigitalProgressDrawable;
import cn.aft.tools.LauncherManager;
import cn.aft.tools.Logger;
import cn.aft.tools.PhotoResultManager;
import cn.aft.tools.Screen;

/**
 * 2016/02/19 by congtaowang.
 * Version 1.0
 */
public class TakePhotoActivity extends BaseActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Bind(R.id.openCamera)
    Button button;

    @Bind(R.id.tokenPhoto)
    SimpleDraweeView photo;

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_takephoto;
    }

    @Override
    protected void onViewCreated() {
        attachClickListener(R.id.openCamera);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.openCamera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                LauncherManager.getLauncher().launchForResult(getActivity(), intent, Config.Code.REQUEST_TAKEPHOTO);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Config.Code.REQUEST_TAKEPHOTO:
                if (resultCode == RESULT_OK) {
                    String path = PhotoResultManager.getManager().getPath(getActivity(), data);
                    Logger.e(TAG, path);
                    displayPhoto(path);
                }
                break;
        }
    }

    private void displayPhoto(String path) {
        int imgHeight = Screen.getHeight(getActivity()) - button.getHeight();
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(new File(path)))
                .setImageType(ImageRequest.ImageType.DEFAULT)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(Screen.getWidth(getActivity()), imgHeight))
                .setAutoRotateEnabled(true).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        if (!(photo.getTag() instanceof DraweeHierarchy)) {
            GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(AFTApplicatioin.getInstance().getResources());
            GenericDraweeHierarchy hierarchy = builder.setFadeDuration(300)
                    .setProgressBarImage(new DigitalProgressDrawable())
                    .build();
            controller.setHierarchy(hierarchy);
        }
        photo.setController(controller);
    }
}
