package com.dgs.pub.common.menus.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.menus.object.MenuPrmObject;
import com.dgs.pub.common.menus.object.MenuRstObject;

public class DMenu extends DCoreImpl {
	final private String location = this.getClass().getName();

	public ListBeans getListScreen(Connection connection, MenuPrmObject param) throws DGException {
		StringBuilder sb = new StringBuilder();
		sb.append("select screen_id,screen_name,link,screen_group,screen_level ");
		sb.append("from screen ");
		sb.append("where screen_group = ? and screen_level = ? and type = ? and status = 1 ");
		sb.append("order by ord and screen_level and screen_group");
		List<Object> params = new ArrayList<Object>();
		params.add(param.getGroup());
		params.add(param.getLevel());
		params.add(param.getType());
		ResultSet rs = this.executeQuery(connection, sb.toString(), params);
		return getObjectInfo(rs);
	}
	
	public ListBeans getListScreenByLevel(Connection connection, MenuPrmObject param) throws DGException {
		StringBuilder sb = new StringBuilder();
		sb.append("select screen_id,screen_name,link,screen_group,screen_level ");
		sb.append("from screen ");
		sb.append("where screen_level = ? and type = ? and status = 1 ");
		sb.append("order by ord and screen_level and screen_group");
		List<Object> params = new ArrayList<Object>();
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

			 MenuRstObject scrObj = null;
			while (rs.next()) {
				scrObj = new MenuRstObject();
				scrObj.setScreenId(rs.getInt("screen_id"));
				scrObj.setScreenName(rs.getString("screen_name"));
				scrObj.setLink(rs.getString("link"));
				scrObj.setScreenGroup(rs.getInt("screen_group"));
				scrObj.setScreenLevel(rs.getInt("screen_level"));
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
