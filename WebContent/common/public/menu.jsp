<%@page import="com.dgs.object.ListBeans"%>
<%@page import="com.dgs.pub.common.menu.object.MenuRstObject"%>
<%@ page import="com.dgs.pub.common.menu.action.AMenu" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	AMenu menu = new AMenu();
	ListBeans list = menu.getListMenuTopByLeve(1);
	out.print("<ul>");
	for(Object item : list){
		MenuRstObject menuObject = (MenuRstObject)item;
		out.print("<li><a href=\"");
		out.print(menuObject.getLink());
		out.print("\" />");
		out.print(menuObject.getScreenName());
		out.print("</a>");
		ListBeans listSub1 = menu.getListMenuTopByLevel(menuObject.getScreenGroup(), 2);
		if(!listSub1.isEmpty()){
			out.print("<ul>");
			for(Object itemSub : listSub1){
				MenuRstObject menuObjectSub = (MenuRstObject)itemSub;
				out.print("<li><a href=\"");
				out.print(menuObjectSub.getLink());
				out.print("\" />");
				out.print(menuObjectSub.getScreenName());
				out.print("</a></li>");
			}
			out.print("</ul>");
		}
		out.print("</li>");
	}
	out.print("</ul>");
%>