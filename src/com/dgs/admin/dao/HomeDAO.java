package com.dgs.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.dgs.admin.object.ScreenObj;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class HomeDAO extends DCoreImpl {
	
	public ListBeans getAllMenus(OBean bean, Connection conn) {
		ListBeans list = new ListBeans();
		ScreenObj so = new ScreenObj();
		so.setScreenId(1);
		so.setScreenName("can loi giai thich");
		list.add(so);
		return list;
	}
	
	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		// TODO Auto-generated method stub
		return null;
	}

}
