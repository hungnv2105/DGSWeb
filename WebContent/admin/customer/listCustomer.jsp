<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<%
	String test = "Test";
%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">List Customer</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="tableViewData" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>UserID</th>
							<th>User name</th>
							<th>Full name</th>
							<th>Email</th>
							<th>Status</th>
						</tr>
					</thead>
					<s:iterator value="listBeans" status="beanStatus">
						<tr>
							<td><s:property value="userId" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="fullName" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="status" /></td>
						</tr>
					</s:iterator>
					<tfoot>

					</tfoot>
				</table>
			</div>
			<!-- /.box-body -->
		</div>
	</div>
</div>
<script>
	$(function() {
		$('#tableViewData').DataTable({
			"paging" : true,
			"lengthChange" : false,
			"searching" : false,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false
		});
	});
</script>
