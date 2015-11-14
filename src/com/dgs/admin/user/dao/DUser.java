package com.dgs.admin.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgs.admin.user.object.UserObject;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class DUser extends DCoreImpl {
	final private String location = this.getClass().getName();
	
	public ListBeans getListUsers(Connection connection, OBean bean) throws DGException {
		ListBeans result = new ListBeans();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from users order by user_name");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		result = getObjectInfo(rs);
		return result;
	}
	
	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		String errorInf = this.location + " -> getObjectInfo()";
		ListBeans list = new ListBeans();
		UserObject obj = null;
		try {
			while (rs.next()) {
				obj = new UserObject();
				obj.setUserId(rs.getInt("user_id"));
				obj.setUserName(rs.getString("user_name"));
				obj.setPassword(rs.getString("password"));
				obj.setFullName(rs.getString("full_name"));
				//obj.setType(rs.getInt("birthday"));
				obj.setGender(rs.getInt("gender"));
				obj.setMobile(rs.getString("mobile"));
				obj.setEmail(rs.getString("email"));
				obj.setAddress(rs.getString("address"));
				obj.setSkypeId(rs.getString("skype_id"));
				obj.setYahooId(rs.getString("yahoo_id"));
				obj.setCreatedBy(rs.getString("created_by"));
				//obj.setStatus(rs.getInt("created_on"));
				obj.setModifiedBy(rs.getString("modified_by"));
				//obj.setStatus(rs.getInt("modified_on"));
				obj.setStatus(rs.getInt("status"));
				list.add(obj);		
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
