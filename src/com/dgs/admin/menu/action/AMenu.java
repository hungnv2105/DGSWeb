package com.dgs.admin.menu.action;

import java.util.ArrayList;
import java.util.List;

import com.dgs.action.ACoreImpl;
import com.dgs.admin.menu.object.MenuObject;
import com.dgs.admin.menu.service.MenuService;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;

public class AMenu extends ACoreImpl{

	/**
	 * author     : hungnv
	 * created on : 06/10/2015
	 */
	private static final long serialVersionUID = -5736939767190021553L;
	
	public AMenu() {
		this.bean = new MenuObject();
		this.service = new MenuService();
	}
	@Override
	public String execute() throws Exception {
		ListBeans listMenu = new ListBeans();
		bean.setBeanId(1);
		listMenu = this.service.getListBeans(bean);
		return SUCCESS;
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(service.getListMenu());
//		} catch (DGException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
