package com.fanxl.fanmap.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * 租售小区房源数量
 * Created by guilin on 16/2/16.
 */
public class RegionPostRo extends BaseRo{

    @SerializedName("Result")
    private ArrayList<RegionPostBo> list;

    public ArrayList<RegionPostBo> getList() {
        return list;
    }

    public void setList(ArrayList<RegionPostBo> list) {
        this.list = list;
    }
}
