package com.fanxl.fanmap.fragment;

import android.content.Intent;

import com.fanxl.fanmap.GenericBaseFragment;
import com.fanxl.fanmap.R;
import com.fanxl.fanmap.activity.SecondHandHouse;

import butterknife.OnClick;

/**
 * Created by fanxl on 2016/6/14 0014.
 */
public class Fragment1 extends GenericBaseFragment {

	@Override
	protected int getLayoutId() {
		return R.layout.fragment1;
	}

	@Override
	protected void init() {

	}

	@OnClick(R.id.bt_second_hand)
	public void goToSecondHand(){
		startActivity(new Intent(getActivity(), SecondHandHouse.class));
	}
}
