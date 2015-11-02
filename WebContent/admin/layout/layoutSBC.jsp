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
			<jsp:include page="../../common/adm/admHeader.jsp"></jsp:include>
		</header>
		<%-- End main-header --%>
		
		<%-- Main-sidebar --%>
		<aside class="main-sidebar">
			<jsp:include page="../../common/adm/admSidebar.jsp"></jsp:include>
		</aside>
		<%-- End main-sidebar --%>
		
		<%-- Content-wrapper --%>
		<div class="content-wrapper">
			<jsp:include page="../../common/adm/admContentHeader.jsp"></jsp:include>
			<section class="content">
			<div id="mainContent">
				
			</div>

        	</section>
        	<%-- End content --%>
		</div>
		<%-- End content-wrapper --%>
		
		<%-- Main-footer --%>
      	<footer class="main-footer">
      		<jsp:include page="../../common/adm/admHeader.jsp"></jsp:include>
      	</footer>
      	<%-- End Main-footer --%>
	</div>
	<%-- End wrapper --%>
	<jsp:include page="/common/adm/jsLibs.jsp"></jsp:include>
</body>
</html>