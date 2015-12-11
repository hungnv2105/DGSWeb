package com.dgs.pub.common.slider.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.slider.object.SliderPathlRstObject;
import com.dgs.pub.common.slider.object.SliderPrmObject;
import com.dgs.pub.common.slider.service.SliderSevice;
import com.dgs.pub.inf.IKeyProcess;

public class ASlider {
	private SliderSevice sliderSevice = new SliderSevice();
	
	public SliderPathlRstObject getSliderPath(int uploadId) {
		SliderPrmObject bean = new SliderPrmObject();
		bean.setProcessId(IKeyProcess.GET_PATH_ADVERTISE);
		bean.setUploadId(uploadId);
		ListBeans listBiean = getSlider(bean);
		if(listBiean.isEmpty()){
			return new SliderPathlRstObject();
		}
		return (SliderPathlRstObject)listBiean.get(0);
	}
	
	public ListBeans getSlider() {
		SliderPrmObject bean = new SliderPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		return getSlider(bean);
	}
	
	private ListBeans getSlider(SliderPrmObject bean) {
		ListBeans listBiean = null;
		try {
			listBiean = sliderSevice.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
}
