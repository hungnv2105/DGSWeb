package com.dgs.pub.common.slider.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.slider.object.SliderPathlRstObject;
import com.dgs.pub.common.slider.object.SliderPrmObject;
import com.dgs.pub.common.slider.object.SliderRstObject;
import com.dgs.pub.inf.IKeyProcess;

public class DSlider extends DCoreImpl {
	final private String location = this.getClass().getName();
	private int objType;
	
	public ListBeans getListSlider(Connection connection) throws DGException {
		this.objType = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("select advertise_id,advertise_name,link,file_id ");
		sb.append("from advertise ");
		sb.append("where type = ");
		sb.append(IKeyProcess.GET_ADVERTISE_SLIDER);
		sb.append(" and status = ");
		sb.append(IKeyProcess.STATUS_ACTIVE);
		sb.append(" order by ord");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		return getObjectInfo(rs);
	}
	
	public ListBeans getPathSlider(Connection connection, SliderPrmObject bean) throws DGException {
		this.objType = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("select upload_id,file_name,file_path,extendtion ");
		sb.append("from file_upload ");
		sb.append("where upload_id = ?");
		sb.append(" and status = ");
		sb.append(IKeyProcess.STATUS_ACTIVE);
		List<Object> params = new ArrayList<>();
		params.add(bean.getUploadId());
		ResultSet rs = this.executeQuery(connection, sb.toString(), params);
		return getObjectInfo(rs);
	}

	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		String errorInf = this.location + " -> getObjectInfo()";
		ListBeans list = new ListBeans();
		try {
			if (objType == 0) {
				SliderRstObject scrObj = null;
				while (rs.next()) {
					scrObj = new SliderRstObject();
					scrObj.setAdvertiseId(rs.getInt("advertise_id"));
					scrObj.setAdvertiseName(rs.getString("advertise_name"));
					scrObj.setLink(rs.getString("link"));
					scrObj.setFileId(rs.getInt("file_id"));
					list.add(scrObj);
				}
			} else {
				SliderPathlRstObject scrObj = null;
				while (rs.next()) {
					scrObj = new SliderPathlRstObject();
					scrObj.setUploadId(rs.getInt("upload_id"));
					scrObj.setFileName(rs.getString("file_name"));
					scrObj.setFilePath(rs.getString("file_path"));
					scrObj.setExtendtion(rs.getString("extendtion"));
					list.add(scrObj);
				}
			}

		} catch (SQLException sqlEx) {
			throw new DGException(sqlEx, errorInf);
		} finally {
			releaseResultSet(rs);
		}
		return list;
	}
}
