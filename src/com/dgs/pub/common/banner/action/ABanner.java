package com.dgs.pub.common.banner.action;

import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.banner.object.BannerPathRstObject;
import com.dgs.pub.common.banner.object.BannerPrmObject;
import com.dgs.pub.common.banner.object.BannerRstObject;
import com.dgs.pub.common.banner.service.BannerService;
import com.dgs.pub.inf.IKeyProcess;

public class ABanner {
private BannerService bannerSevice = new BannerService();
	
	public BannerPathRstObject getBannerPath(int uploadId) {
		BannerPrmObject bean = new BannerPrmObject();
		bean.setProcessId(IKeyProcess.GET_PATH_ADVERTISE);
		bean.setUploadId(uploadId);
		ListBeans listBiean = getBanner(bean);
		if(listBiean.isEmpty()){
			return new BannerPathRstObject();
		}
		return (BannerPathRstObject)listBiean.get(0);
	}
	
	public BannerRstObject getBanner() {
		BannerPrmObject bean = new BannerPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		bean.setType(IKeyProcess.GET_ADVERTISE_BANNER);
		ListBeans listBiean = getBanner(bean);
		if(listBiean.isEmpty()){
			return new BannerRstObject();
		}
		return (BannerRstObject)listBiean.get(0);
	}
	
	public BannerRstObject getLogo() {
		BannerPrmObject bean = new BannerPrmObject();
		bean.setProcessId(IKeyProcess.GET_LIST_BEANS);
		bean.setType(IKeyProcess.GET_ADVERTISE_LOGO);
		ListBeans listBiean = getBanner(bean);
		if(listBiean.isEmpty()){
			return new BannerRstObject();
		}
		return (BannerRstObject)listBiean.get(0);
	}
	
	private ListBeans getBanner(BannerPrmObject bean) {
		ListBeans listBiean = null;
		try {
			listBiean = bannerSevice.process(bean).getListResponse();
		} catch (DGException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listBiean;
	}
}
