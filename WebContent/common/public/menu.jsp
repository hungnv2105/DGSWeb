<%@page import="com.dgs.object.ListBeans"%>
<%@page import="com.dgs.pub.common.menu.object.MenuRstObject"%>
<%@ page import="com.dgs.pub.common.menu.action.AMenu" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	AMenu menu = new AMenu();
	ListBeans list = menu.getListMenuTop(0, 1);
	out.print("<ul>");
	for(int i=0;i<list.size(); i++){
		MenuRstObject menuObject = (MenuRstObject)list.get(i);
		out.print("<li><a href=\"");
		out.print(menuObject.getLink());
		out.print("\" />");
		out.print(menuObject.getScreenName());
		out.print("</a></li>");
	}
	out.print("<ul>");
	
%>