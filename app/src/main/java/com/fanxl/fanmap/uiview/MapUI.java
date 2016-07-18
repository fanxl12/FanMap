package com.fanxl.fanmap.uiview;

import com.fanxl.fanmap.bean.RegionPostBo;
import com.fanxl.fanmap.bean.RegionPostRo;

import java.util.List;


/**
 * Created by fanxl2 on 2016/7/15.
 */
public interface MapUI {

	void setRegions(List<RegionPostBo> regions);

	void setRegionPostRo(RegionPostRo regionPostRo);

}
