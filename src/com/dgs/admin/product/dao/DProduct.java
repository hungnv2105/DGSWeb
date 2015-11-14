package com.dgs.admin.product.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgs.admin.inf.IKeyProcess;
import com.dgs.admin.product.object.Product;
import com.dgs.dao.DCoreImpl;
import com.dgs.dao.DGException;
import com.dgs.object.ListBeans;
import com.dgs.object.OBean;

public class DProduct extends DCoreImpl {

	private int objType;

	public ListBeans getListGroupProduct(Connection connection) throws DGException {
		ListBeans result = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select product_id, product_code, product_name ");
		sb.append("from products where is_parent > 0 ");
		sb.append("order by product_code");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		this.objType = IKeyProcess.GET_LIST_GROUP;
		result = getObjectInfo(rs);
		return result;
	}

	public ListBeans getListProductStatus(Connection connection) throws DGException {
		ListBeans result = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct status from products status");
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		this.objType = IKeyProcess.GET_LIST_STATUS;
		result = getObjectInfo(rs);
		return result;
	}

	public ListBeans getListProduct(Connection connection, OBean bean) throws DGException {
		ListBeans result = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select * from products where 1=1 ");
		if (bean != null) {
			Product obj = (Product) bean;
			sb.append("and parent_id=" + obj.getParentId() + " ");
			sb.append("and status=" + obj.getStatus() + " ");
			sb.append("and product_code=" + obj.getProductCode() + " ");
			sb.append("and product_name=" + obj.getProductName() + " ");
		}
		ResultSet rs = this.executeQuery(connection, sb.toString(), null);
		this.objType = IKeyProcess.GET_LIST_BEANS;
		result = getObjectInfo(rs);
		return result;
	}

	@Override
	public ListBeans getObjectInfo(ResultSet rs) {
		ListBeans list = new ListBeans();
		try {
			if (this.objType == IKeyProcess.GET_LIST_GROUP) {
				Product obj = null;
				while (rs.next()) {
					obj = new Product();
					obj.setProductId(rs.getInt("product_id"));
					obj.setProductCode(rs.getString("product_code"));
					obj.setProductName(rs.getString("product_name"));
					list.add(obj);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
