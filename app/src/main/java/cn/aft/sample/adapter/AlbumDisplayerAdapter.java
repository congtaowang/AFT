package cn.aft.sample.adapter;

import java.util.List;

import cn.aft.sample.R;
import cn.aft.sample.album.bean.NativeImageInfo;
import cn.aft.template.adapter.BaseViewHolder;
import cn.aft.template.adapter.BaseViewHolderAdapter;

/**
 * 16/1/29 by congtaowang.
 * Version 1.0
 */
public class AlbumDisplayerAdapter extends BaseViewHolderAdapter<NativeImageInfo> {

    private int displayImgWidth;
    private int displayImgHeight;

    public AlbumDisplayerAdapter(List<NativeImageInfo> datas, int displayImgWidth, int displayImgHeight) {
        super(datas);
        this.displayImgWidth = displayImgWidth;
        this.displayImgHeight = displayImgHeight;
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.widget_album_displayer;
    }

    @Override
    protected BaseViewHolder<NativeImageInfo> createViewHolder(int position) {
        return new ImgDisplayerViewHolder(displayImgWidth, displayImgHeight);
    }
}
