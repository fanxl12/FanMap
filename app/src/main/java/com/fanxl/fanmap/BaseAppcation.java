package com.fanxl.fanmap;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public class BaseAppcation extends Application {

	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		// 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
		SDKInitializer.initialize(this);
		mContext = this;
	}

	public static Context getContext() {
		return mContext;
	}
}
