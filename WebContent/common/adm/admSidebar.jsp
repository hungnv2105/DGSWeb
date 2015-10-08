<%@ page contentType="text/html;charset=UTF-8" %>
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
		<s:textfield name="txtSearch" cssClass="input-text" />
		<s:div value="getText('search')" ></s:div>
	</div>
</div>
<div id="sb-titles">
	<h2 class="nav-title">
		<s:property value="getText('menu.title')" />
	</h2>
</div>
<jsp:include page="menuTree.jsp"></jsp:include>