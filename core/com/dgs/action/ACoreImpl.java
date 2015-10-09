/**
 * 
 */
package com.dgs.action;

import com.dgs.inf.ACore;
import com.dgs.object.OBean;
import com.dgs.service.BaseService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author hungnv
 *
 */
public class ACoreImpl extends ActionSupport implements ModelDriven, ACore {
	
	protected OBean bean;
	protected BaseService service;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return bean;
	}


}
