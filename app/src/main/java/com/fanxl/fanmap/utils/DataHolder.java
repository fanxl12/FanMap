package com.fanxl.fanmap.utils;

/**
 * Created by fanxl2 on 2016/7/18.
 */
public class DataHolder {

	private DataHolder(){}

	private static volatile DataHolder dataHolder;

	public static DataHolder getInstance(){
		if (dataHolder==null){
			synchronized (DataHolder.class){
				if (dataHolder==null){
					dataHolder = new DataHolder();
				}
			}
		}
		return dataHolder;
	}

	private double latitude;
	private double longitude;
	private float radius;

	public double getLatitude() {
		return latitude;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
