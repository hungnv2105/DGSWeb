<%@ include file="../../common/tags.jsp"%>
<%@ include file="../../common/params.jsp"%>
<s:form name="frmUser" action="userAction.html" class="form-horizontal">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">Tieu chi tim kiem</h3>
		</div>
		<div class="form-horizontal">
			<div class="box-body">
				<div class="form-group">
					<label for="productParent" class="col-sm-2 control-label">Loai sp</label>
					<div class="col-sm-4">
						<select class="form-control" name="productParent" id="productParent">
							<s:iterator value="listGroup" status="gProduct">
								<option value="#gProduct.productCode" label="#gProduct.productName"/>
							</s:iterator>
						</select>
					</div>
					<label for="productStatus" class="col-sm-2 control-label">Trang thai</label>
					<div class="col-sm-4">
						<select class="form-control" name="productStatus" id="productStatus"></select>
					</div>
				</div>
				<div class="form-group">
					<label for="producCode" class="col-sm-2 control-label">Ma san pham</label>
					<div class="col-sm-4">
						<input name="producCode" type="text" class="form-control" id="producCode" />
					</div>
					<label for="producName" class="col-sm-2 control-label">Ten san pham</label>
					<div class="col-sm-4">
						<input name="producName" type="text" class="form-control" id="producName" />
					</div>
				</div>
				<div class="form-group">
					<label for="startDate" class="col-sm-2 control-label">Tu ngay</label>
					<div class="col-sm-4">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input name="startDate" type="text" class="form-control pull-right datepicker" id="startDate" />
						</div>
					</div>
					<label for="endDate" class="col-sm-2 control-label">Den ngay</label>
					<div class="col-sm-4">
						<div class="input-group">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input name="endDate" type="text" class="form-control pull-right datepicker" id="endDate" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<jsp:include page="../../common/editor.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div class="box-footer">
				<input type="button" class="btn btn-info pull-right" value="Tim kiem" />
			</div>
		</div>
	</div>
</s:form>
<script>
	$(function() {
		//Date picker
		$('.datepicker').datepicker({
		    language: 'vi'
		});
		
		$(".textarea").wysihtml5();
	});
</script>