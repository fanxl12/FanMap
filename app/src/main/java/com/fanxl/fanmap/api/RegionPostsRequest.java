package com.fanxl.fanmap.api;

import com.fanxl.fanmap.BaseAppcation;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fanxl2 on 2016/7/15.
 */
public class RegionPostsRequest {

	private static final String CACHE_CONTROL = "Cache-Control";

//	private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

	private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
		@Override
		public Response intercept(Chain chain) throws IOException {
			Response originalResponse = chain.proceed(chain.request());
			int maxAge = 60; // 在线缓存在1分钟内可读取
			return originalResponse.newBuilder()
					.removeHeader("Pragma")
					.removeHeader(CACHE_CONTROL)
					.header(CACHE_CONTROL, "public, max-age=" + maxAge)
					.build();
		}
	};

	private static File httpCacheDirectory = new File(BaseAppcation.getContext().getCacheDir(), "RegionCache");
	private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
	private static Cache cache = new Cache(httpCacheDirectory, cacheSize);

	private static OkHttpClient client = new OkHttpClient.Builder()
//			.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
			.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)//不添加离线缓存无效
			.cache(cache)
			.build();


	private static RegionPosts3Api regionPosts3Api = null;

	public static RegionPosts3Api getRegionPosts3Api() {
//		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		synchronized (RegionPostsRequest.class) {
			if (regionPosts3Api == null) {
				regionPosts3Api = new Retrofit.Builder()
						.baseUrl("http://114.80.110.197")
						.client(client)
						.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
						.addConverterFactory(GsonConverterFactory.create())
						.build()
						.create(RegionPosts3Api.class);
			}
			return regionPosts3Api;
		}
	}

}
