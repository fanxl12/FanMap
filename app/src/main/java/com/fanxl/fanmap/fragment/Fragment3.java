package com.fanxl.fanmap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanxl.fanmap.R;

/**
 * Created by fanxl on 2016/6/14 0014.
 */
public class Fragment3 extends Fragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment3, container, false);
		return view;
	}
}
