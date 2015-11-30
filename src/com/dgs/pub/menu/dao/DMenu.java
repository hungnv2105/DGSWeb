package com.dgs.pub.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.menu.object.MenuObject;

public class DMenu extends DCoreImpl {
	final private String location = this.getClass().getName();

	public ListBeans getListScreen(Connection connection) throws DGException {
		StringBuilder sb = new StringBuilder();
		sb.append("select screen_id,screen_name,link from screen where type = 2 and status=1 order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		return getObjectInfo(rs);
	}

	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		String errorInf = this.location + " -> getObjectInfo()";
		ListBeans list = new ListBeans();
		try {

			MenuObject scrObj = null;
			while (rs.next()) {
				scrObj = new MenuObject();
				scrObj.setScreenId(rs.getInt("screen_id"));
				scrObj.setScreenName(rs.getString("screen_name"));
				scrObj.setLink(rs.getString("link"));
				list.add(scrObj);
			}

		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		} finally {
			releaseResultSet(rs);
		}
		return list;
	}

}
