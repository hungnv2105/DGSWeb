package com.dgs.admin.controller.product;

import com.dgs.action.ACore;
import com.dgs.admin.product.object.Product;
import com.dgs.object.OBean;

public class AProduct extends ACore {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product bean = new Product();
	
	
	
	@Override
	public OBean getModel() {
		// TODO Auto-generated method stub
		return bean;
	}

}
