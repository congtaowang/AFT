package cn.aft.framework.mvp;

import android.app.Activity;

/**
 * 2016年1月1日 by congtaowang
 *
 * Version 1.0
 */
public interface BaseView {

	Activity visitActivity();

	void showToastMsg(String msg);

	void showToastMsg(int resId);

	void showProgressingDialog();

	void dismissProgressDialog();
}
