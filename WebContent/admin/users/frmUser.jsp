<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<s:form name="frmUser" action="userAction.html">
	<div class="row">
		<div class="col-xs-2"><span>UserName</span></div>
		<div class="col-xs-4"><input name="userName" type="text"/></div>
		<div class="col-xs-2"><span>FullName</span></div>
		<div class="col-xs-4"><input name="fullName" type="text"/></div>
	</div>
	<div class="row">
		<div class="col-xs-12"><input type="button" value="submit" onclick="postAjax('frmUser','idListUser')"></div>
	</div>
</s:form>