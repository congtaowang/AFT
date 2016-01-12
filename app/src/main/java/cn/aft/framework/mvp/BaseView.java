package cn.aft.framework.mvp;

import android.app.Activity;

/**
 * 2016年1月1日 by congtaowang
 *
 * Version 1.0
 */
public interface BaseView {

	public Activity visitActivity();

	public void showToastMsg(String msg);

	public void showToastMsg(int resId);

	public void showProgressingDialog();

	public void dismissProgressDialog();
}
