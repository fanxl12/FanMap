package com.fanxl.fanmap.api;

import com.fanxl.fanmap.bean.RegionPostRo;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by fanxl2 on 2016/7/15.
 */
public interface RegionPosts3Api {

	@GET("http://114.80.110.197/021/api/RegionPosts?id=0&area=0&room=0&level=0&price=0&maxInputPrice=&postType=s&minInputPrice=")
	Observable<RegionPostRo> getZuoBiao();


	@GET("http://114.80.110.197/021/api/RegionPosts")
	Observable<RegionPostRo> getZuoBiaoMap(@QueryMap(encoded = true) Map<String, String> params);


}
