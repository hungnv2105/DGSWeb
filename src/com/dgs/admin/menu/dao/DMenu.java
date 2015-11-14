package com.dgs.admin.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgs.admin.menu.object.GroupScreenObject;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
public class DMenu extends DCoreImpl {
	
	final private String location = this.getClass().getName();
	private int objType;

	public ListBeans getListGroupScreen(Connection connection) throws DGException {
		objType = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from group_screen order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		return getObjectInfo(rs);
	}

	public ListBeans getListScreen(Connection connection) throws DGException {
		objType = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from screen order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		return getObjectInfo(rs);
	}

	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		String errorInf = this.location + " -> getObjectInfo()";
		ListBeans list = new ListBeans();
		try {
			if (this.objType == 0) {
				GroupScreenObject grObj = null;
				while (rs.next()) {
					grObj = new GroupScreenObject();
					grObj.setGroupId(rs.getInt("group_id"));
					grObj.setGroupName(rs.getString("group_name"));
					grObj.setOrder(rs.getInt("ord"));
					list.add(grObj);		
				}
			} else if (this.objType == 1) {
				ScreenObject scrObj = null;
				while (rs.next()) {
					scrObj = new ScreenObject();
					scrObj.setScreenId(rs.getInt("screen_id"));
					scrObj.setScreenCode(rs.getString("screen_code"));
					scrObj.setScreenName(rs.getString("screen_name"));
					scrObj.setGroupId(rs.getInt("groupId"));
					scrObj.setType(rs.getInt("type"));
					scrObj.setAction(rs.getString("action"));
					scrObj.setLink(rs.getString("link"));
					scrObj.setOrder(rs.getInt("ord"));
					scrObj.setStatus(rs.getInt("status"));
					list.add(scrObj);		
				}
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
		finally {
			releaseResultSet(rs);
		}
		return list;
	}

}
