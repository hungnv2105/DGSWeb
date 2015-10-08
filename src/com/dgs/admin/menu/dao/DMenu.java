package com.dgs.admin.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dgs.admin.menu.object.MenuObject;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;

public class DMenu extends DCoreImpl {

	public List<MenuObject> getListMenu(Connection connection) throws DGException {
		List<MenuObject> result = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from menu");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		getMenuObject(rs, result);
		return result;
	}
	
	private void getMenuObject(ResultSet rs, List<MenuObject> list) throws DGException {
		try {
			MenuObject menu = null;
			while (rs.next()) {
				menu = new MenuObject();
				menu.setAppId(rs.getInt("appId"));
				menu.setMenuId(rs.getInt("menuId"));
						
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx);
		}
	}

}
