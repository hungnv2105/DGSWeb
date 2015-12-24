package com.dgs.pub.common.banner.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.banner.object.BannerPrmObject;
import com.dgs.pub.common.banner.object.BannerRstObject;
import com.dgs.pub.common.banner.service.BannerService;
import com.dgs.pub.inf.IKeyProcess;

public class ABanner {
	
	private BannerService bannerSevice = new BannerService();

	public BannerRstObject getBanner() {
		BannerPrmObject bean = new BannerPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		bean.setType(IKeyProcess.GET_ADVERTISE_BANNER);
		ListBeans listBiean = getBanner(bean);
		if(listBiean.isEmpty()){
			return null;
		}
		return (BannerRstObject)listBiean.get(0);
	}
	
	public BannerRstObject getLogo() {
		BannerPrmObject bean = new BannerPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		bean.setType(IKeyProcess.GET_ADVERTISE_LOGO);
		ListBeans listBiean = getBanner(bean);
		if(listBiean.isEmpty()){
			return null;
		}
		return (BannerRstObject)listBiean.get(0);
	}
	
	private ListBeans getBanner(BannerPrmObject bean) {
		try {
			return bannerSevice.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
