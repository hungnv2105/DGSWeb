/**
 * 
 */
package com.dgs.action;

import com.dgs.object.OBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author hungnv
 *
 */
public abstract class ACore extends ActionSupport implements ModelDriven<OBean> {

	private static final long serialVersionUID = 3651620411305481229L;
	
	@Override
	public String execute() throws Exception {
		return doProcess();
	}
	
	public abstract String doProcess();

	public void processId(OBean bean, int processId) {
		bean.setProcessId(processId);
	}
}
