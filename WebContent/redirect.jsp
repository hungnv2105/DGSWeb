<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<s:url namespace="/" action="index.html" >
      <s:param name="request_locale" >vi_VN</s:param>
</s:url>
<% 
	response.sendRedirect("admin/index.html");
%>