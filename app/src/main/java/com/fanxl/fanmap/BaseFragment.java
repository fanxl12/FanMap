package com.fanxl.fanmap;

import android.content.Context;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public abstract class BaseFragment extends GenericBaseFragment{

	protected BaseActivity mActivity;

	//获取宿主Activity
	protected BaseActivity getHoldingActivity() {
		return mActivity;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof BaseActivity){
			this.mActivity = (BaseActivity) context;
		}
	}

	//添加fragment
	protected void addFragment(BaseFragment fragment) {
		if (null != fragment) {
			getHoldingActivity().addFragment(fragment);
		}
	}

	//移除fragment
	protected void removeFragment() {
		getHoldingActivity().removeFragment();
	}
}
