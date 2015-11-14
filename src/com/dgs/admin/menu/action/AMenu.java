package com.dgs.admin.menu.action;

import org.apache.log4j.Logger;

import com.dgs.action.ACore;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.admin.product.service.ProductService;
import com.dgs.admin.user.service.UserService;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;
import com.dgs.service.BaseService;

public class AMenu extends ACore implements IMenuKey {

	/**
	 * author : hungnv 
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;

	private OBean bean = new ScreenObject();
	private BaseService service = null;
	final static Logger LOGGER = Logger.getLogger(AMenu.class);

	private ListBeans listGroup;
	private ListBeans listBeans;
	private ListBeans listDropDown;
	
	private String pageForward;

	public String getPageForward() {
		return pageForward;
	}
	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}

	@Override
	public String execute() {
		service = new MenuService();
		try {
			bean.setProcessId(GET_LIST_GROUP);
			listGroup = service.process(bean).getListResponse();
			bean.setProcessId(GET_LIST_BEANS);
			listBeans = service.process(bean).getListResponse();
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return SUCCESS;
	}

	public String changePage() {
		try {
			if (this.pageForward.equals(VIEW_USER_PAGE)) {
				service = new UserService();
				bean.setProcessId(GET_LIST_BEANS);
				listBeans = service.process(bean).getListResponse();
			} else if (this.pageForward.equals(VIEW_ROLE_PAGE)) {
				listBeans = new ListBeans();
			} else if (this.pageForward.equals(VIEW_PRODUCT_PAGE)) {
				service = new ProductService();
				bean.setProcessId(GET_LIST_GROUP);
				listGroup = service.process(bean).getListResponse();
				bean.setProcessId(GET_LIST_STATUS);
				listDropDown = service.process(bean).getListResponse();
				bean.setProcessId(GET_LIST_BEANS);
				listBeans = service.process(bean).getListResponse();
			}
		} catch (DGException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
		return this.pageForward;
	}

	@Override
	public OBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

	public ListBeans getListBeans() {
		return listBeans;
	}

	public void setListBeans(ListBeans listBeans) {
		this.listBeans = listBeans;
	}

	public ListBeans getListGroup() {
		return listGroup;
	}

	public void setListGroup(ListBeans listGroup) {
		this.listGroup = listGroup;
	}
	public ListBeans getListDropDown() {
		return listDropDown;
	}
	public void setListDropDown(ListBeans listDropDown) {
		this.listDropDown = listDropDown;
	}
}
