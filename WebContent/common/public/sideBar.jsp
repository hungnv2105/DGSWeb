<%@page import="com.dgs.object.ListBeans"%>
<%@ page import="com.dgs.pub.common.menu.action.AMenu" %>
<%@ page import="com.dgs.pub.common.menu.object.MenuRstObject" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	AMenu action = new AMenu();
	ListBeans list = action.getListMenuSideBarByLeve(1);
	for(Object item : list){
		MenuRstObject rst = (MenuRstObject)item;
		out.print("<div class=\"block\">");
		out.print("<h2>"+rst.getScreenName()+"</h2>");
		
		out.print("</div>");
	}
%>