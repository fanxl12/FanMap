package com.fanxl.fanmap.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 租售区域板块房源数量
 * Created by guilin on 16/2/16.
 */
public class RegionPostBo implements Parcelable {

    private int AllCount;
    private String FirstPY;
    private String FullPY;
    private String GScopeCnName;
    private String GScopeCode;
    private String GScopeEnName;
    private int GScopeId;
    private int GScopeLevel;
    private double Lng;
    private double Lat;
    private int ParentId;
    private double RegionAvgPrice;
    private double RegionMatchPrice;
    private int RentCount;
    private int SaleCount;

    public int getAllCount() {
        return AllCount;
    }

    public void setAllCount(int allCount) {
        AllCount = allCount;
    }

    public String getFirstPY() {
        return FirstPY;
    }

    public void setFirstPY(String firstPY) {
        FirstPY = firstPY;
    }

    public String getFullPY() {
        return FullPY;
    }

    public void setFullPY(String fullPY) {
        FullPY = fullPY;
    }

    public String getGScopeCnName() {
        return GScopeCnName;
    }

    public void setGScopeCnName(String GScopeCnName) {
        this.GScopeCnName = GScopeCnName;
    }

    public String getGScopeCode() {
        return GScopeCode;
    }

    public void setGScopeCode(String GScopeCode) {
        this.GScopeCode = GScopeCode;
    }

    public String getGScopeEnName() {
        return GScopeEnName;
    }

    public void setGScopeEnName(String GScopeEnName) {
        this.GScopeEnName = GScopeEnName;
    }

    public int getGScopeId() {
        return GScopeId;
    }

    public void setGScopeId(int GScopeId) {
        this.GScopeId = GScopeId;
    }

    public int getGScopeLevel() {
        return GScopeLevel;
    }

    public void setGScopeLevel(int GScopeLevel) {
        this.GScopeLevel = GScopeLevel;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double lng) {
        Lng = lng;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public int getParentId() {
        return ParentId;
    }

    public void setParentId(int parentId) {
        ParentId = parentId;
    }

    public double getRegionAvgPrice() {
        return RegionAvgPrice;
    }

    public void setRegionAvgPrice(double regionAvgPrice) {
        RegionAvgPrice = regionAvgPrice;
    }

    public double getRegionMatchPrice() {
        return RegionMatchPrice;
    }

    public void setRegionMatchPrice(double regionMatchPrice) {
        RegionMatchPrice = regionMatchPrice;
    }

    public int getRentCount() {
        return RentCount;
    }

    public void setRentCount(int rentCount) {
        RentCount = rentCount;
    }

    public int getSaleCount() {
        return SaleCount;
    }

    public void setSaleCount(int saleCount) {
        SaleCount = saleCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.AllCount);
        dest.writeString(this.FirstPY);
        dest.writeString(this.FullPY);
        dest.writeString(this.GScopeCnName);
        dest.writeString(this.GScopeCode);
        dest.writeString(this.GScopeEnName);
        dest.writeInt(this.GScopeId);
        dest.writeInt(this.GScopeLevel);
        dest.writeDouble(this.Lng);
        dest.writeDouble(this.Lat);
        dest.writeInt(this.ParentId);
        dest.writeDouble(this.RegionAvgPrice);
        dest.writeDouble(this.RegionMatchPrice);
        dest.writeInt(this.RentCount);
        dest.writeInt(this.SaleCount);
    }

    public RegionPostBo() {
    }

    protected RegionPostBo(Parcel in) {
        this.AllCount = in.readInt();
        this.FirstPY = in.readString();
        this.FullPY = in.readString();
        this.GScopeCnName = in.readString();
        this.GScopeCode = in.readString();
        this.GScopeEnName = in.readString();
        this.GScopeId = in.readInt();
        this.GScopeLevel = in.readInt();
        this.Lng = in.readDouble();
        this.Lat = in.readDouble();
        this.ParentId = in.readInt();
        this.RegionAvgPrice = in.readDouble();
        this.RegionMatchPrice = in.readDouble();
        this.RentCount = in.readInt();
        this.SaleCount = in.readInt();
    }

    public static final Parcelable.Creator<RegionPostBo> CREATOR = new Parcelable.Creator<RegionPostBo>() {
        public RegionPostBo createFromParcel(Parcel source) {
            return new RegionPostBo(source);
        }

        public RegionPostBo[] newArray(int size) {
            return new RegionPostBo[size];
        }
    };
}
