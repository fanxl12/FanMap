package com.fanxl.fanmap.api;

import com.fanxl.fanmap.bean.RegionPostBo;
import com.fanxl.fanmap.bean.RegionPostRo;
import com.fanxl.fanmap.presenter.RegionPresenter;
import com.fanxl.fanmap.uiview.MapUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fanxl2 on 2016/7/15.
 */
public class RegionPost3Impl implements RegionPresenter {

	private MapUI mapUI;

	public RegionPost3Impl(MapUI mapUI){
		if (mapUI==null)throw new IllegalArgumentException("mapUI can not be null");
		this.mapUI=mapUI;
		regionPostBos = new ArrayList<>();
	}

	private List<RegionPostBo> regionPostBos;
	private static final String TAG = "RegionPost3Impl";

	@Override
	public void getRegions(Map<String, String> params) {
		RegionPostsRequest.getRegionPosts3Api().getZuoBiaoMap(params)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<RegionPostRo>() {
					@Override
					public void call(RegionPostRo regionPostRo) {
						mapUI.setRegionPostRo(regionPostRo);
					}
				});
//				.flatMap(new Func1<RegionPostRo, Observable<RegionPostBo>>() {
//					@Override
//					public Observable<RegionPostBo> call(RegionPostRo regionPostRo) {
//						return getRegionPostBo(regionPostRo);
//					}
//				})
//				.filter(new Func1<RegionPostBo, Boolean>() {
//					@Override
//					public Boolean call(RegionPostBo regionPostBo) {
//						return regionPostBo.getGScopeLevel()==2;
//					}
//				})
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Observer<RegionPostBo>() {
//					@Override
//					public void onCompleted() {
//						mapUI.setRegions(regionPostBos);
//					}
//
//					@Override
//					public void onError(Throwable e) {
//						e.printStackTrace();
//					}
//
//					@Override
//					public void onNext(RegionPostBo regionPostBo) {
//						regionPostBos.add(regionPostBo);
//					}
//				});
	}

	public Observable<RegionPostBo> getRegionPostBo(final RegionPostRo regionPostRo){
		return  Observable.create(new Observable.OnSubscribe<RegionPostBo>(){

			@Override
			public void call(Subscriber<? super RegionPostBo> subscriber) {
				for (RegionPostBo bo : regionPostRo.getList()){
					subscriber.onNext(bo);
				}
			}
		});
	}

	@Override
	public void getRegionByGet() {
//		RegionPostsRequest.getRegionPosts3Api().getZuoBiao()
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(new Observer<RegionPostBo>() {
//					@Override
//					public void onCompleted() {
//						mapUI.setRegions(regionPostBos);
//					}
//
//					@Override
//					public void onError(Throwable e) {
//
//					}
//
//					@Override
//					public void onNext(RegionPostBo regionPostBo) {
//						regionPostBos.add(regionPostBo);
//					}
//				});
	}
}
