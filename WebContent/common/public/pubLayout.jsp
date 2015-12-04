<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/themes/default/default.css" type="text/css" media="screen" />
<script src="js/jquery-1.9.0.min.js" type="text/javascript" ></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="baner">
				<tiles:insertAttribute name="banner" />
			</div><!-- end #baner -->
			 <div id="mainNav">
				<tiles:insertAttribute name="menu" />
			</div><!-- end #mainNav -->
			<div id="slide">
				<tiles:insertAttribute name="slider" />
			</div><!-- end #slide -->
			<div class="clr"></div>
		</div><!-- end #header -->
		<div id="content">
			<div id="sideBar">
				<tiles:insertAttribute name="sideBar" />
			</div><!-- End #sideBar-->
			<div id="mainContent">
				<tiles:insertAttribute name="mainContent" />
			</div><!-- End #mainContent-->
			<div id="primary">
				<tiles:insertAttribute name="primary" />
			</div><!-- End #primary-->
			<div class="clr"></div>
		</div><!-- End #content-->
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div><!-- End #footer-->
	</div><!-- end #wrapper -->
</body>
</html>