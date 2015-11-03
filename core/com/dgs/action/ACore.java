/**
 * 
 */
package com.dgs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dgs.object.OBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author hungnv
 *
 */
public abstract class ACore extends ActionSupport implements ModelDriven<OBean> {

	private static final long serialVersionUID = 3651620411305481229L;
	
	protected HttpServletRequest request = ServletActionContext.getRequest();
	protected HttpServletResponse response = ServletActionContext.getResponse();
	
	
}
