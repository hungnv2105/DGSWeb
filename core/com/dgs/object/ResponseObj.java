package com.dgs.object;

public class ResponseObj extends RespMesg {
	private ListBeans listResponse;
	private OBean beanResponse;
	public ListBeans getListResponse() {
		return listResponse;
	}
	public void setListResponse(ListBeans listResponse) {
		this.listResponse = listResponse;
	}
	public OBean getBeanResponse() {
		return beanResponse;
	}
	public void setBeanResponse(OBean beanResponse) {
		this.beanResponse = beanResponse;
	}
}
