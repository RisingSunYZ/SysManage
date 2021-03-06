/**
 * 本文件中的方法主要是针对easyui以及其他jquery功能的扩展
 * 
 * @author 梅江顺
 */

/**
 * 扩展validatebox的验证功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	/* 密码一致验证 */
	eqPwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	},
	/* 汉字验证 */
	CHS : {
		validator : function(value, param) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message : '请输入汉字'
	},
	/* QQ号验证 */
	QQ : {
		validator : function(value, param) {
			return /^[1-9]\d{4,10}$/.test(value);
		},
		message : 'QQ号码不正确'
	},
	/* 验证手机号 */
	mobile : {
		validator : function(value, param) {
			return /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/.test(value);
		},
		message : '手机号码不正确'
	},
	/* 数字验证 */
	number : {
		validator : function(value, param) {
			return /^\d+$/.test(value);
		},
		message : '请输入数字'
	},
	/* 小数验证 */
	float : {
		validator : function(value, param) {
			return /^-?\d+\.\d+$/.test(value);
		},
		message : '请输入小数'
	},
	/* 实数验证(小数+整数) */
	realnumber : {
		validator : function(value, param) {
			return /^-?\d+(\.\d+)?$/.test(value);
		},
		message : '请输入整数或者小数'
	},
	/* 下拉框选择验证 */
	selectRequired : {
		validator : function(value, param) {
			if (value == "" || value.indexOf('选择') >= 0) {
				return false;
			} else {
				return true;
			}
		},
		message : '请选择'
	},
	/* 用户名验证 */
	loginName : {
		validator : function(value, param) {
			if (value.length < param[0] || value.length > param[1]) {
				$.fn.validatebox.defaults.rules.loginName.message = "用户名长度必须在" + param[0] + "与" + param[1] + "之间";
				return false;
			}
			if (!/^[\w]+$/.test(value)) {
				$.fn.validatebox.defaults.rules.loginName.message = "用户名只能由数字、字母、下划线构成";
				return false;
			}
			return true;
		},
		message : ''
	}
});

/**
 * 对datagrid的editors进行扩展
 */
$.extend($.fn.datagrid.defaults.editors, {
	datetimebox : {
		init : function(container, options) {
			var editor = $("<input />").appendTo(container);
			options.editable = false;
			return editor.datetimebox(options);
		},
		destroy : function(target) {
			$(target).datetimebox("destroy");
		},
		getValue : function(target) {
			return $(target).datetimebox("getValue");
		},
		setValue : function(target, value) {
			$(target).datetimebox("setValue", value);
		},
		resize : function(target, width) {
			$(target).datetimebox("resize", width);
		}
	}
});

/**
 * 对tabs扩展，添加验证方法，如果validatebox验证不通过则跳到对应的tab页面中
 */
$.extend($.fn.tabs.methods, {
	validate : function(jq) {
		var tabs = $(jq).tabs("tabs");// 将所有的tab找到
		if ($.fn.validatebox && tabs.length > 0) {
			for ( var i = 0; i < tabs.length; i++) {
				var box = $(".validatebox-text", tabs[i]);// tab下所有的validatebox
				if (box.length) {
					box.validatebox("validate");
					box.trigger("focus");
					box.trigger("blur");
					var valid = $(".validatebox-invalid:first", tabs[i]).focus();
					if (valid.length == 0)
						continue;
					else {
						$(jq).tabs("select", i);// 跳到出错的tab页面中
						return false;
					}
				}
			}
		}
		return true;
	}
});

/**
 * 给Date添加format方法
 * 
 * @param format
 * @returns
 */
Date.prototype.format = function(format) {
	if (isNaN(this.getMonth()))
		return "";
	if (!format || format == "") {
		format = "yyyy-MM-dd";
	}
	var o = {
		/* 月份 */
		"M+" : this.getMonth() + 1,
		/* 日 */
		"d+" : this.getDate(),
		/* 小时 */
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
		/* 小时 */
		"H+" : this.getHours(),
		/* 分 */
		"m+" : this.getMinutes(),
		/* 秒 */
		"s+" : this.getSeconds(),
		/* 季度 */
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		/* 毫秒 */
		"S" : this.getMilliseconds()
	};
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return format;
};