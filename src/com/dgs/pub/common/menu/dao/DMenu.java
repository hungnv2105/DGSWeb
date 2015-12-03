package com.dgs.pub.common.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.menu.object.MenuObject;
import com.dgs.pub.common.menu.object.MenuPrmObject;

public class DMenu extends DCoreImpl {
	final private String location = this.getClass().getName();

	public ListBeans getListScreen(Connection connection, MenuPrmObject param) throws DGException {
		StringBuilder sb = new StringBuilder();
		sb.append("select screen_id,screen_name,link,group,level ");
		sb.append("from screen ");
		sb.append("where group = ? and level = ? and type = ? and status = 1 ");
		sb.append("order by ord and level and group");
		List<Object> params = new ArrayList<Object>();
		params.add(param.getGroup());
		params.add(param.getLevel());
		params.add(param.getType());
		ResultSet rs = this.executeQuery(connection, sb.toString(), params);
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
