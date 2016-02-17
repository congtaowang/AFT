package cn.aft.sample.ui;

import android.widget.GridView;

import java.util.ArrayList;
import java.util.Map;

import butterknife.Bind;
import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.R;
import cn.aft.sample.adapter.AlbumDisplayerAdapter;
import cn.aft.sample.album.ExecutorsServiceUtils;
import cn.aft.sample.album.NativeAlbumLoadedCallBack;
import cn.aft.sample.album.NativeImageLoader;
import cn.aft.sample.album.bean.NativeImageInfo;
import cn.aft.tools.Screen;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public class AlbumActivity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Bind(R.id.albumGrid)
    GridView albumGrid;

    private AlbumDisplayerAdapter displayerAdapter;

    private int gridItemWidth;
    private int gridItemHeight;

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_album;
    }

    @Override
    protected void onViewCreated() {
        gridItemWidth = gridItemHeight = (Screen.getWidth(getActivity()) - 30) / 3;
        NativeImageLoader.getImageLoader().loadNativeAlbum(getActivity(), callBack, false);
    }

    private NativeAlbumLoadedCallBack callBack = new NativeAlbumLoadedCallBack() {
        @Override
        public void onNativeAlbumLoaded(Map<String, ArrayList<NativeImageInfo>> entities) {
            ArrayList<NativeImageInfo> nativeImageInfos = entities.get("all");
            displayImgs(nativeImageInfos);
        }
    };

    private void displayImgs(ArrayList<NativeImageInfo> nativeImageInfos) {
        displayerAdapter = new AlbumDisplayerAdapter(nativeImageInfos, gridItemWidth, gridItemHeight);
        albumGrid.setAdapter(displayerAdapter);
    }

    @Override
    protected void onDestroy() {
        ExecutorsServiceUtils.stopAllExecutors();
        super.onDestroy();
    }
}
