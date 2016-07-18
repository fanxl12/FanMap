package com.fanxl.fanmap.activity;

import com.fanxl.fanmap.AppActivity;
import com.fanxl.fanmap.BaseFragment;
import com.fanxl.fanmap.fragment.SecondHandMapHouse;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public class SecondHandHouse extends AppActivity {

	@Override
	protected BaseFragment getFirstFragment() {
		return SecondHandMapHouse.getInstance();
	}
}
