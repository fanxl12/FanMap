package com.fanxl.fanmap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.fanxl.fanmap.GenericBaseActivity;
import com.fanxl.fanmap.R;
import com.fanxl.fanmap.fragment.Fragment1;
import com.fanxl.fanmap.fragment.Fragment2;
import com.fanxl.fanmap.fragment.Fragment3;
import com.fanxl.fanmap.fragment.Fragment4;
import com.fanxl.fanmap.utils.DataHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends GenericBaseActivity {

	@BindView(R.id.main_tab_host)
	FragmentTabHost main_tab_host;

	private Class<?> fragmentArray[] = {Fragment1.class, Fragment2.class, Fragment3.class, Fragment4.class};

	private String mTextviewArray[] = {"首页", "项目2", "项目3", "项目4"};

	private int iconS[] = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon};

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		initLocation();
		initTabs();
	}

	private void initLocation() {
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);

		//设置定位条件
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);        //是否打开GPS
		option.setCoorType("bd09ll");
		option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要//设置返回值的坐标类型。
		option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
		option.setProdName("FanMap"); //设置产品线名称。强烈建议您使用自定义的产品线名称，方便我们以后为您提供更高效准确的定位服务。
		option.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
		option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
		mLocClient.setLocOption(option);
		getLocation();
	}

	public void getLocation(){
		if(mLocClient == null)return;
		if (mLocClient.isStarted()){
			mLocClient.requestLocation();
		}else{
			mLocClient.start();
		}
	}

	/**
	 * Tab初始化
	 */
	private void initTabs() {
		main_tab_host.setup(this, getSupportFragmentManager(), R.id.main_fragment_layout);
		main_tab_host.getTabWidget().setDividerDrawable(null);

		int count = fragmentArray.length;
		for (int i = 0; i < count; i++) {
			TabHost.TabSpec tabSpec = main_tab_host.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
			main_tab_host.addTab(tabSpec, fragmentArray[i], null);
		}
		main_tab_host.setCurrentTab(0);
	}

	/**
	 * 给Tab按钮设置图标和文字
	 */
	private View getTabItemView(int index) {
		View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);
		TextView tab_item_text = (TextView) view.findViewById(R.id.tab_item_text);
		tab_item_text.setText(mTextviewArray[index]);
		ImageView tab_item_icon = (ImageView) view.findViewById(R.id.tab_item_icon);
		tab_item_icon.setBackgroundResource(iconS[index]);
		return view;
	}

	//定位操作
	//定位操作
	private LocationClient mLocClient;
	private MyLocationListenner myListener = new MyLocationListenner();

	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null)return;

			DataHolder.getInstance().setLatitude(location.getLatitude());
			DataHolder.getInstance().setLongitude(location.getLongitude());

			//Receive Location
			StringBuffer sb = new StringBuffer(256);
			sb.append("time : ");
			sb.append(location.getTime());
			sb.append("\nlocationType: ");
			sb.append(location.getLocType());
			sb.append("\nlatitude : ");
			sb.append(location.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(location.getLongitude());
			sb.append("\nradius : ");
			sb.append(location.getRadius());

			sb.append("\naddr : ");
			sb.append(location.getAddrStr());

			sb.append("\nlocationdescribe : ");
			sb.append(location.getLocationDescribe());// 位置语义化信息
			List<Poi> list = location.getPoiList();// POI数据
			if (list != null) {
				sb.append("\npoilist size = : ");
				sb.append(list.size());
				for (Poi p : list) {
					sb.append("\npoi= : ");
					sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
				}
			}
			Log.i("BaiduLocationApiDem", sb.toString());

		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 退出时销毁定位
		mLocClient.stop();
	}
}
