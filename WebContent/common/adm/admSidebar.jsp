<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<div id="sb-search">
		<div id="user-info">
			<div id="user-avatar">
				<img src="images/avatar2.png">
			</div>
			<div id="user-display">
				<ul>
					<li>UserName</li>
					<li>is Online</li>
				</ul>
			</div>
		</div>
		<div id="search-box">
			<input type="text" name="txtSearch" placeholder="enter text hear ...">
			<input type="button" name="txtSearchIcon" value="search">
		</div>
	</div>
	<div id="sb-titles">
		<h2 class="nav-title">Quan tri he thong</h2>
	</div>
	<jsp:include page="menuTree.jsp"></jsp:include>