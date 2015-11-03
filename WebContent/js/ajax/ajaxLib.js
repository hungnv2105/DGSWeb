/**
 * Created by hungnv on 11/1/2015.
 */

function postAjax(formName, position, param) {
	var postForm = $('form[name=' + formName + ']');
	var actionURL;
	if (postForm != null) {
		actionURL = postForm.attr('action');
	} else {
		actionURL = formName;
	}
	var data = parseData(param, formName);
	position = "#" + position;
	loadAjax(actionURL, position, data, 'POST', 'html');
}

function getAjax(formName, position, param) {
	var postForm = $('form[name=' + formName + ']');
	var actionURL;
	if (postForm != null) {
		actionURL = postForm.attr('action');
	} else {
		actionURL = formName;
	}
	var data = parseData(param, formName);

	loadAjax(actionURL, position, data, 'GET', 'html');
}

function loadAjax(url, position, data, method, dataType) {

	var request = {
		url : url,
		type : method,
		dataType : dataType,
		data : data,
		success : function(result) {
			$(position).html(result);
		}
	};
	$.ajax(request);
	console.log(request.data);
}

function parseData(param, formName) {
	var data = {};
	var strOject = "{";

	// get data from postForm
	if (formName != undefined && formName != null) {
		$($('form[name=' + formName + '] :input')).each(
				function() {
					var obj = $(this);
					if (obj != undefined && obj != null) {
						var paramName = obj.attr('name') != '' ? obj.attr('name') : obj.attr('id');
						var paramValue = obj.val();
						if (paramName != undefined) {
							strOject += "\"" + paramName + "\":\"" + paramValue + "\",";
						}
					}
				});
	}

	// get data from param
	if (param != null && param != '') {
		var arrParam = param.split(":");
		for (var i = 0; i < arrParam.length; i++) {
			strOject += "\"" + arrParam[i] + "\"";
			if (i % 2 == 0) {
				strOject += ":"
			} else {
				strOject += ",";
			}
		}
	}
	strOject = strOject.substring(0, strOject.length - 1);
	strOject += "}";

	data = jQuery.parseJSON(strOject);
	return data;
}