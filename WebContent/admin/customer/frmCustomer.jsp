<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<s:form name="frmCustomer" action="CustomerAction.html">
	<div class="row">
		<div class="col-xs-12"><span class="header">Detail Customer</span></div>
	</div>
	<div class="row">
		<div class="col-xs-2"><span>UserName</span></div>
		<div class="col-xs-4"><input name="userName" type="text" style="width:100%"/></div>
		<div class="col-xs-2"><span>FullName</span></div>
		<div class="col-xs-4"><input name="fullName" type="text" style="width:100%"/></div>
	</div>
	<div class="row">
		<div class="col-xs-12"><input type="button" value="submit" onclick="postAjax('frmCustomer','idListCustomer')"></div>
	</div>
</s:form>