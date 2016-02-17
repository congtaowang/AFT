package cn.aft.sample.album;

import java.util.ArrayList;
import java.util.Map;

import cn.aft.sample.album.bean.NativeImageInfo;


public interface NativeAlbumLoadedCallBack {

	public void onNativeAlbumLoaded(Map<String, ArrayList<NativeImageInfo>> entities);
}
