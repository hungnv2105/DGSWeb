<%@ page import="com.dgs.pub.common.banner.action.ABanner"%>
<%@ page import="com.dgs.pub.common.banner.object.BannerRstObject"%>
<%@ page import="com.dgs.pub.common.banner.object.BannerPathRstObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ABanner action = new ABanner();
	BannerRstObject rst = action.getLogo();
	out.print("<div id=\"logo\"");
	out.print("<a href=\"index.html\">");
	out.print("<img src=\""+ action.getBannerPath(rst.getFileId()) +"\" alt=\""+rst.getAdvertiseName()+"\" width=\"120\" />");
	rst = action.getBanner();
	out.print("<img src=\""+ action.getBannerPath(rst.getFileId()) +"\" alt=\""+rst.getAdvertiseName()+"\" width=\"120\" />");
	out.print("</a></div>");
%>