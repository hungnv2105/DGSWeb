/**
 * 
 */
package com.dgs.object;

/**
 * @author hungnv
 *
 */
public abstract class OBean {
	protected int processId;
	protected String resMessage;
	protected String reqMessage;
	protected int objId;
	protected ListBeans listBean;

	public int getObjId() {
		return objId;
	}

	public void setObjId(int objId) {
		this.objId = objId;
	}

	public String getResMessage() {
		return resMessage;
	}

	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}

	public String getReqMessage() {
		return reqMessage;
	}

	public void setReqMessage(String reqMessage) {
		this.reqMessage = reqMessage;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	public ListBeans getListBean() {
		return listBean;
	}
	public void setListBean(ListBeans listBean) {
		this.listBean = listBean;
	}

}
