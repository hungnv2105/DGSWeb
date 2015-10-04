<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<html>
<head>
<jsp:include page="../../common/adm/setAdmin.jsp"></jsp:include>
</head>
<body>
	<div id="main">
		<div id="header">
			<jsp:include page="../../common/adm/admHeader.jsp"></jsp:include>
		</div>
		<div id="content">
			<div id="sidebar">
				<jsp:include page="../../common/adm/admSidebar.jsp"></jsp:include>
			</div>

			<div id="wrapper">
				<div id="menubar">
					<jsp:include page="../../common/adm/admMenubar.jsp"></jsp:include>
				</div>
				<div id="new-feeds">
					<jsp:include page="../../common/adm/admToolbar.jsp"></jsp:include>
				</div>
				<div id="main-content"></div>
				<div class="clr"></div>
			</div>
		</div>
	</div>

	<div class="clear"></div>

	<div id="footer">
		<jsp:include page="../../common/adm/admFooter.jsp"></jsp:include>
	</div>
</body>
</body>
</html>