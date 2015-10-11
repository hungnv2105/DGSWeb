<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<html>
<head>
<jsp:include page="../../common/adm/setAdmin.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<%-- Wrapper --%>
	<div class="wrapper">
	
		<%-- Main-header --%>
		<header class="main-header">
			<tiles:insertAttribute name="header" />
		</header>
		<%-- End main-header --%>
		
		<%-- Main-sidebar --%>
		<aside class="main-sidebar">
			<tiles:insertAttribute name="sidebar" />
		</aside>
		<%-- End main-sidebar --%>
		
		<%-- Content-wrapper --%>
		<div class="content-wrapper">
			<tiles:insertAttribute name="contentHeader" />
			<section class="content">

          	<tiles:insertAttribute name="mainContent" />

        	</section>
        	<%-- End content --%>
		</div>
		<%-- End content-wrapper --%>
		
		<%-- Main-footer --%>
      	<footer class="main-footer">
      		<tiles:insertAttribute name="footer" />
      	</footer>
      	<%-- End Main-footer --%>
	</div>
	<%-- End wrapper --%>
	<jsp:include page="/common/adm/jsLibs.jsp"></jsp:include>
</body>
</html>