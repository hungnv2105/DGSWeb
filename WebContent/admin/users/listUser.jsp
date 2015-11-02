<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>

<div class="box">
	<div class="box-header">
		<h3 class="box-title">Data Table With Full Features</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<table id="example1" class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>UserID</th>
					<th>User name</th>
					<th>Full name</th>
					<th>Email</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listBeans">
					<tr>
						<td><s:property value="userId"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="fullName"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="status"/></td>
					</tr>
				</s:iterator>
			</tbody>
			<tfoot>
				<tr>
					<th>UserID</th>
					<th>User name</th>
					<th>Full name</th>
					<th>Email</th>
					<th>Status</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- /.box-body -->
</div>
	