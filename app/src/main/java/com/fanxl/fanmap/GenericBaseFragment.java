package com.fanxl.fanmap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public abstract class GenericBaseFragment extends Fragment {

	//获取布局文件ID
	protected abstract int getLayoutId();
	protected abstract void init();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(), container, false);
		ButterKnife.bind(this, view);
		init();
		return view;
	}

	protected GenericBaseActivity mActivity;

	//获取宿主Activity
	protected GenericBaseActivity getHoldingActivity() {
		return mActivity;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof GenericBaseActivity){
			this.mActivity = (GenericBaseActivity) context;
		}
	}

}
