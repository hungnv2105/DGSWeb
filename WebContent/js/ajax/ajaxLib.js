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
	var data = parseData(param, postForm);
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
	var data = parseData(param, postForm);

	loadAjax(actionURL, position, data, 'GET', 'html');
}

function loadAjax(url, position, data, method, dataType) {

	var request = {
		url : url,
		type : method,
		contentType:'application/x-www-form-urlencoded',
		dataType : dataType,
		data : data,
		success : function(html) {
			$(position).html(html);
		}
	};
	$.ajax(request);
	console.log(request.data);
}

function parseData(param, postForm) {
	var data = {};
	var strOject = "{";

	// get data from postForm
	if (postForm != undefined && postForm != null) {
		$(postForm).each(function() {
			var obj = $(this).find(':input');
			if (obj != undefined && obj != null) {
				var paramName = obj.name != '' ? obj.name : obj.id;
				var paramValue = obj.val();
				strOject += "\"" + paramName + "\":\"" + paramValue + "\",";
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
	strOject = strOject.substring(0,strOject.length - 1);
	strOject += "}";

	data = jQuery.parseJSON(strOject);
	return data;
}