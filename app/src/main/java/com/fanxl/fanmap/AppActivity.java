package com.fanxl.fanmap;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public abstract class AppActivity extends BaseActivity {

	//获取第一个fragment
	protected abstract BaseFragment getFirstFragment();

	//获取Intent
	protected void handleIntent(Intent intent) {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getContentViewId());
		if (null != getIntent()) {
			handleIntent(getIntent());
		}
		//避免重复添加Fragment
		if (null == getSupportFragmentManager().getFragments()) {
			BaseFragment firstFragment = getFirstFragment();
			if (null != firstFragment) {
				addFragment(firstFragment);
			}
		}
	}

	@Override
	protected int getContentViewId() {
		return R.layout.app;
	}

	@Override
	protected int getFragmentContentId() {
		return R.id.fragment_container;
	}

}
