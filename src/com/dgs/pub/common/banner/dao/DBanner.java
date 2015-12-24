package com.dgs.pub.common.banner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.pub.common.banner.object.BannerPrmObject;
import com.dgs.pub.common.banner.object.BannerRstObject;
import com.dgs.pub.inf.IKeyProcess;

public class DBanner extends DCoreImpl {
	final private String location = this.getClass().getName();
	
	public ListBeans getListBanner(Connection connection, BannerPrmObject bean) throws DGException {
		StringBuilder sb = new StringBuilder();
		sb.append("select adv.advertise_id, adv.advertise_name, adv.link, fu.file_name, fu.file_path, fu.extendtion ");
		sb.append("from advertise adv join file_upload fu on adv.file_id = fu.upload_id ");
		sb.append("where adv.type = ?");
		sb.append(" and adv.status = ");
		sb.append(IKeyProcess.STATUS_ACTIVE);
		sb.append(" order by adv.ord");
		List<Object> param = new ArrayList<>();
		param.add(bean.getType());
		ResultSet rs = this.executeQuery(connection, sb.toString(), param);
		return getObjectInfo(rs);
	}

	@Override
	public ListBeans getObjectInfo(ResultSet rs) throws DGException {
		String errorInf = this.location + " -> getObjectInfo()";
		ListBeans list = new ListBeans();
		try {
			BannerRstObject scrObj = null;
			while (rs.next()) {
				scrObj = new BannerRstObject();
				scrObj.setAdvertiseId(rs.getInt("advertise_id"));
				scrObj.setAdvertiseName(rs.getString("advertise_name"));
				scrObj.setLink(rs.getString("link"));
				scrObj.setFileName(rs.getString("file_name"));
				scrObj.setFilePath(rs.getString("file_path"));
				scrObj.setExtendtion(rs.getString("extendtion"));
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
