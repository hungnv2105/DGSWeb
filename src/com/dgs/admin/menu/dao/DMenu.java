package com.dgs.admin.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgs.admin.menu.object.MenuObject;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class DMenu extends DCoreImpl {
	
	final private String location = this.getClass().getName();
	
	private void getMenuObject(ResultSet rs, ListBeans list) throws DGException {
		String errorInf = this.location + " -> getMenuObject";
		try {
			MenuObject menu = null;
			while (rs.next()) {
				menu = new MenuObject();
				menu.setAppId(rs.getInt("appId"));
				menu.setMenuId(rs.getInt("idmenu"));
				menu.setGroupMenu(rs.getInt("groupMenu"));
				menu.setMenuName(rs.getString("menuName"));
				menu.setIsParent(rs.getInt("isParent"));
				menu.setOrder(rs.getInt("order"));
				menu.setFilePath(rs.getString("filepath"));
				list.add(menu);		
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
	}

	public ListBeans getListMenu(Connection connection, OBean bean) throws DGException {
		ListBeans result = new ListBeans();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from menu");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		getMenuObject(rs, result);
		return result;
	}

}
