package com.fanxl.fanmap.fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.fanxl.fanmap.BaseFragment;
import com.fanxl.fanmap.R;
import com.fanxl.fanmap.utils.DataHolder;

import butterknife.BindView;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public class SecondHandMapHouse extends BaseFragment {

	public static SecondHandMapHouse getInstance(){
		return new SecondHandMapHouse();
	}

	@BindView(R.id.id_bmapView)
	MapView mMapView;

	private BaiduMap mBaiduMap;
	private UiSettings mUiSettings;

	//是否是第一次定位
	private boolean isFirstLocation = true;

	@Override
	protected int getLayoutId() {
		return R.layout.second_hand_house;
	}

	@Override
	protected void init() {
		//隐藏放大缩小按钮
		mMapView.showZoomControls(false);
		//隐藏比例尺
		mMapView.showScaleControl(false);
		mBaiduMap = mMapView.getMap();
		mUiSettings = mBaiduMap.getUiSettings();
		//隐藏指南针
		mUiSettings.setCompassEnabled(false);

		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);

		DataHolder dataHolder = DataHolder.getInstance();

		toLocation(dataHolder.getRadius(), dataHolder.getLatitude(), dataHolder.getLongitude());
	}

	private void toLocation(float radius, double latitude, double longitude){
		MyLocationData locData = new MyLocationData.Builder()
				.accuracy(radius)
				// 此处设置开发者获取到的方向信息，顺时针0-360
				.direction(100).latitude(latitude)
				.longitude(longitude).build();

		mBaiduMap.setMyLocationData(locData);

		// 第一次定位时，将地图位置移动到当前位置
		if (isFirstLocation){
			isFirstLocation = false;
			LatLng ll = new LatLng(latitude, longitude);
			MapStatus.Builder builder = new MapStatus.Builder();
			builder.target(ll).zoom(18.0f);
			mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		//在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		//在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		//在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
		mMapView.onDestroy();
		mMapView = null;
	}
}
