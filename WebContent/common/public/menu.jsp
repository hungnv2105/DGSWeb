<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dgs.pub.menu.action.AMenu" %>
<%@ page import="com.dgs.pub.menu.object.MenuObject" %>
<%
	AMenu menu = new AMenu();
	MenuObject menuObject = null;
	out.print("<ul>");
	for(int i=0;i<menu.getListBiean().size(); i++){
		menuObject = (MenuObject) menu.getListBiean().get(i);
		out.print("<li><a href=\"");
		out.print(menuObject.getLink());
		out.print("\" />");
		out.print(menuObject.getScreenName());
		out.print("</a></li>");
	}
	out.print("<ul>");
	
%>