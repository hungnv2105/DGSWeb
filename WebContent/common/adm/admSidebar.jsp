<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">

	<!-- Sidebar user panel (optional) -->
	<div class="user-panel">
		<div class="pull-left image">
			<img src="<%=contextPath%>/images/avatar2.png" class="img-circle"
				alt="User Image">
		</div>
		<div class="pull-left info">
			<p>Alexander Pierce</p>
			<!-- Status -->
			<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		</div>
	</div>

	<!-- search form (Optional) -->
	<form action="#" method="get" class="sidebar-form">
		<div class="input-group">
			<input type="text" name="txtSearch" class="form-control"
				placeholder="Search..."/> <span class="input-group-btn">
				<button type="submit" name="search" id="search-btn"
					class="btn btn-flat">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
	</form>
	<!-- /.search form -->

	<!-- Sidebar Menu -->
	<s:form name="menuForm" action="changePage.html">
		<ul class="sidebar-menu">
			<li class="header">Administration System</li>
			<s:iterator value="listGScreen">
				<li class="treeview"><a href="#"> <i class="fa fa-share"></i><span><s:property
								value="groupName" /></span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<s:iterator value="listScreen" status="Status">
							<s:if test="groupId == [1].groupId">
								<li><s:a href=""
										onclick="postAjax('menuForm', 'mainContent', 'pageForward:'+ '%{listScreen[#Status.index].action}');">
										<i class="fa fa-circle-o"></i>
										<s:property value="screenName" />
									</s:a></li>
							</s:if>
						</s:iterator>
					</ul></li>
			</s:iterator>
		</ul>
	</s:form>
	<!-- /.sidebar-menu -->
</section>
<!-- /.sidebar -->