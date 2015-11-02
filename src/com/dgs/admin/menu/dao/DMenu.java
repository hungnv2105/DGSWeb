package com.dgs.admin.menu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgs.admin.menu.object.GroupScreenObject;
import com.dgs.admin.menu.object.ScreenObject;
import com.dgs.admin.user.object.UserObject;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class DMenu extends DCoreImpl {
	
	final private String location = this.getClass().getName();

	public ListBeans getListGroupScreen(Connection connection) throws DGException {
		ListBeans result = new ListBeans();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from group_screen order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		getGroupScreenObject(rs, result);
		return result;
	}

	public ListBeans getListScreen(Connection connection) throws DGException {
		ListBeans result = new ListBeans();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from screen order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		getScreenObject(rs, result);
		return result;
	}
	
	private void getScreenObject(ResultSet rs, ListBeans list) throws DGException {
		String errorInf = this.location + " -> getScreenObject()";
		try {
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
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
	}
	
	private void getGroupScreenObject(ResultSet rs, ListBeans list) throws DGException {
		String errorInf = this.location + " -> getGroupScreenObject()";
		try {
			GroupScreenObject grObj = null;
			while (rs.next()) {
				grObj = new GroupScreenObject();
				grObj.setGroupId(rs.getInt("group_id"));
				grObj.setGroupName(rs.getString("group_name"));
				grObj.setOrder(rs.getInt("ord"));
				list.add(grObj);		
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
	}

	public ListBeans getListUsers(Connection connection) throws DGException {
		ListBeans result = new ListBeans();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from users order by user_name");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		getUserObject(rs, result);
		return result;
	}

	private void getUserObject(ResultSet rs, ListBeans list) throws DGException {
		String errorInf = this.location + " -> getUserObject()";
		try {
			UserObject bean = null;
			while (rs.next()) {
				bean = new UserObject();
				bean.setUserId(rs.getInt("user_id"));
				bean.setUserName(rs.getString("user_name"));
				bean.setPassword(rs.getString("password"));
				bean.setFullName(rs.getString("full_name"));
				//bean.setType(rs.getInt("birthday"));
				bean.setGender(rs.getInt("gender"));
				bean.setMobile(rs.getString("mobile"));
				bean.setEmail(rs.getString("email"));
				bean.setAddress(rs.getString("address"));
				bean.setSkypeId(rs.getString("skype_id"));
				bean.setYahooId(rs.getString("yahoo_id"));
				bean.setCreatedBy(rs.getString("created_by"));
				//bean.setStatus(rs.getInt("created_on"));
				bean.setModifiedBy(rs.getString("modified_by"));
				//bean.setStatus(rs.getInt("modified_on"));
				bean.setStatus(rs.getInt("status"));
				list.add(bean);		
			}
		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		}
	}

}
