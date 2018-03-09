jQuery.extend({
	createUploadIframe : function(jq, id, uri) {
		// 创建 frame
		var frameId = 'jUploadFrame' + id;
		var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
		if (window.ActiveXObject) {
			if (typeof uri == 'boolean') {
				iframeHtml += ' src="' + 'javascript:false' + '"';
			} else if (typeof uri == 'string') {
				iframeHtml += ' src="' + uri + '"';
			}
		}
		iframeHtml += ' />';
		jQuery(iframeHtml).appendTo(jq.parent());
		return jQuery('#' + frameId).get(0);
	},
	createUploadForm : function(jq, id, fileElementId, data) {
		// create form
		var formId = 'jUploadForm' + id;
		var fileId = 'jUploadFile' + id;
		var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');
		if (data) {
			for ( var i in data) {
				jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
			}
		}
		for ( var i = 0; i < fileElementId.length; i++) {
			var oldElement = jQuery('#' + fileElementId[i]);
			var newElement = jQuery(oldElement).clone();
			jQuery(newElement).removeAttr('id');
			jQuery(newElement).appendTo(form);
		}
		// 设置属性
		jQuery(form).css('position', 'absolute');
		jQuery(form).css('top', '-1200px');
		jQuery(form).css('left', '-1200px');
		jQuery(form).appendTo(jq.parent());
		return form;
	},
	uploadHttpData : function(r, type) {
		var data = !type;
		data = type == "xml" || data ? r.responseXML : r.responseText;
		// If the type is "script", eval it in global context
		if (type == "script")
			jQuery.globalEval(data);
		// Get the JavaScript object, if JSON is used.
		if (type == "json")
			data = eval("(" + data + ")");
		// evaluate scripts within html
		if (type == "html")
			jQuery("<div>").html(data).evalScripts();
		return data;
	},
	ajaxFileUpload : function(s) {
		var $this = $(this);
		s = jQuery.extend({}, jQuery.ajaxSettings, s);
		var id = new Date().getTime();
		var form = jQuery.createUploadForm($this, id, s.fileElementId, (typeof (s.data) == 'undefined' ? false : s.data));
		var io = jQuery.createUploadIframe($this, id, s.secureuri);
		var frameId = 'jUploadFrame' + id;
		var formId = 'jUploadForm' + id;
		// 监控请求
		if (s.global && !jQuery.active++) {
			jQuery.event.trigger("ajaxStart");
		}
		// 上传前
		if (s.before)
			s.before();
		var requestDone = false;
		// 创建请求对象
		var xml = {};
		if (s.global)
			jQuery.event.trigger("ajaxSend", [ xml, s ]);
		// 等待一个响应返回
		var uploadCallback = function(isTimeout) {
			var io = document.getElementById(frameId);
			try {
				if (io.contentWindow) {
					xml.responseText = io.contentWindow.document.body ? io.contentWindow.document.body.innerHTML : null;
					xml.responseXML = io.contentWindow.document.XMLDocument ? io.contentWindow.document.XMLDocument : io.contentWindow.document;
				} else if (io.contentDocument) {
					xml.responseText = io.contentDocument.document.body ? io.contentDocument.document.body.innerHTML : null;
					xml.responseXML = io.contentDocument.document.XMLDocument ? io.contentDocument.document.XMLDocument : io.contentDocument.document;
				}
			} catch (e) {
				jQuery.handleError(s, xml, null, e);
			}
			if (xml || isTimeout == "timeout") {
				requestDone = true;
				var status;
				try {
					status = isTimeout != "timeout" ? "success" : "error";
					// 请求成功
					if (status != "error") {
						// 处理数据
						var data = jQuery.uploadHttpData(xml, s.dataType);
						// 触发成功事件
						if (s.success)
							s.success(data, status);
						// 触发全局返回
						if (s.global)
							jQuery.event.trigger("ajaxSuccess", [ xml, s ]);
					} else
						jQuery.handleError(s, xml, status);
				} catch (e) {
					status = "error";
					jQuery.handleError(s, xml, status, e);
				}
				// 请求完成
				if (s.global)
					jQuery.event.trigger("ajaxComplete", [ xml, s ]);
				// 处理全局AJAX计数器
				if (s.global && !--jQuery.active)
					jQuery.event.trigger("ajaxStop");
				// 处理结果
				if (s.complete)
					s.complete(xml, status);
				jQuery(io).unbind();
				setTimeout(function() {
					try {
						jQuery(io).remove();
						jQuery(form).remove();
					} catch (e) {
						jQuery.handleError(s, xml, null, e);
					}
				}, 100);
				xml = null;
			}
		};
		// 超时检查
		if (s.timeout > 0) {
			setTimeout(function() {
				// 查看请求是否仍然发生
				if (!requestDone)
					uploadCallback("timeout");
			}, s.timeout);
		}
		try {
			var form = jQuery('#' + formId);
			jQuery(form).attr('action', s.url);
			jQuery(form).attr('method', 'POST');
			jQuery(form).attr('target', frameId);
			if (form.encoding) {
				jQuery(form).attr('encoding', 'multipart/form-data');
			} else {
				jQuery(form).attr('enctype', 'multipart/form-data');
			}
			jQuery(form).submit();
		} catch (e) {
			jQuery.handleError(s, xml, null, e);
		}
		if (window.attachEvent) {// IE
			document.getElementById(frameId).attachEvent('onload', uploadCallback);
		} else {// 非IE
			document.getElementById(frameId).addEventListener('load', uploadCallback, false);
		}
		return {
			abort : function() {
			}
		};
	},
	handleError : function(s, xhr, status, e) {
		// If a local callback was specified, fire it
		if (s.error) {
			console.info(e);
			s.error.call(s.context || s, xhr, status, e);
		}
		// Fire the global callback
		if (s.global) {
			(s.context ? jQuery(s.context) : jQuery.event).trigger("ajaxError", [ xhr, s, e ]);
		}
	}
});
