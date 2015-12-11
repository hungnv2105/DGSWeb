<%@page import="com.dgs.object.ListBeans"%>
<%@page import="com.dgs.pub.common.slider.action.ASlider"%>
<%@ page import="com.dgs.pub.common.slider.object.SliderRstObject" %>
<%@ page import="com.dgs.pub.common.slider.object.SliderPathlRstObject" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ASlider aSlider = new ASlider();
	ListBeans listBean = new ListBeans();
	listBean = aSlider.getSlider();
	out.print("<div class=\"slider-wrapper theme-default\">");
	out.print("<div id=\"slider\" class=\"nivoSlider\">");
	for(Object item : listBean){
		SliderRstObject sliderRstObject = (SliderRstObject)item;
		SliderPathlRstObject sliderPathlRstObject = aSlider.getSliderPath(sliderRstObject.getFileId());
		out.print("<a href=\"" + sliderRstObject.getLink() + "\" >");
		out.print("<img src=\"" + sliderPathlRstObject.getFilePath() + "\"");
		out.print(" data-thumb=\"" + sliderPathlRstObject.getFilePath() +"\"");
		out.print(" alt=\"" + sliderRstObject.getAdvertiseName() +"\"");
		out.print(" title=\"" + sliderPathlRstObject.getDescription() +"\" />");
		out.print("<a/>");
	}
	out.print("</div>");
	out.print("</div>");
%>
<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>