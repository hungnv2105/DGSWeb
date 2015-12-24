<%@ page import="com.dgs.pub.common.banner.action.ABanner"%>
<%@ page import="com.dgs.pub.common.banner.object.BannerRstObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ABanner action = new ABanner();
	BannerRstObject rst = action.getLogo();
	out.print("<div id=\"logo\"");
	if(rst != null){
		out.print("<a href=\""+rst.getLink()+"\">");
		out.print("<img src=\"" + rst.getFilePath() + "\" alt=\"" + rst.getAdvertiseName() + "\" width=\"120\" />");
		out.print("</a></div>");
	}
	
	rst = action.getBanner();
	if(rst != null){
		out.print("<img class=\"banner_bg\" src=\"" + rst.getFilePath()
				+ "\" alt=\"" + rst.getAdvertiseName() + "\" width=\"1000\" />");
	}
	
%>