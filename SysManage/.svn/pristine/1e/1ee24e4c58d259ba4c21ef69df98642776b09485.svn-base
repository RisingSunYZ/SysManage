/*document.domain = 'cnblogs.' + location.hostname.substring(location.hostname.lastIndexOf(".") + 1, location.hostname.length);
var saveDraftIntervalId;*/
tinyMCE.init({
    language: "cn",
    mode: "exact",
    elements: "note",
    width: "100",
    theme: "advanced",
	//template,emotions,layer
    plugins: "lists,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
    theme_advanced_buttons1: "forecolor,backcolor,|,bold,italic,underline,strikethrough,|,bullist,numlist,outdent,indent,blockquote,|,hr,sub,sup,charmap,|, justifyleft, justifycenter, justifyright,|,search,replace,|,insertdate,inserttime,preview", 
	theme_advanced_buttons2: "link,unlink,anchor,|,removeformat,cleanup,|,image,uploadImage,media,|,insertCode,syntaxHighlighter,|,code,fullscreen,|,formatselect,fontselect,fontsizeselect,|,undo,redo", //
    theme_advanced_buttons3: "table,tablecontrols",
    theme_advanced_resizing: true,
    theme_advanced_resize_horizontal: false,
    theme_advanced_toolbar_location: "top",
    theme_advanced_toolbar_align: "left",
    theme_advanced_statusbar_location: "bottom",
    theme_advanced_fonts: "宋体=宋体;黑体=黑体;仿宋=仿宋;楷体=楷体;隶书=隶书;幼圆=幼圆;Arial=arial,helvetica,sans-serif;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Tahoma=tahoma,arial,helvetica,sans-serif;Times New Roman=times new roman,times;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats",
    theme_advanced_font_sizes: "12px=12px,13px=13px,14px=14px,15px=15px,16px=16px,18px=18px,4(14pt)=14pt,5(18pt)=18pt",
  /*  forced_root_block: "p",
    convert_fonts_to_spans: true,
    remove_trailing_nbsp: true,
    convert_newlines_to_brs: false,
    force_br_newlines: false,
    force_p_newlines: true,
    remove_linebreaks: false,
    verify_html: true,*/
    //convert_urls: false,
    //document_base_url: '',
   /* relative_urls: false,
    remove_script_host: false,
    paste_auto_cleanup_on_paste: true,*/
//    paste_preprocess: function (pl, o) {
//        o.content = ChromeFilter(o.content);
//    },
  /*  extended_valid_elements: "pre[name|class],style",
	valid_children : "+body[style]",
	content_css: "http://common.cnblogs.com/blog/css/mce.css",
    handle_event_callback: "MCECheckIndent",
    whitespace_elements: "pre,script,style,textarea,br",
    cleanup: true,*/
    /*setup: function (ed) {
        ed.onInit.add(function (editor) {
            var loadingText = "编辑器加载中...";
            var content = editor.getContent();
            if (content == loadingText || content == '<p>' + loadingText + '</p>') {
                editor.setContent('');
            }

            editor.onInit.add(function (editor) {
                tinymce.dom.Event.add(editor.getBody(), "focus", function (e) {
                    saveDraftIntervalId = setInterval(localPreserver.saveDraftBody, 10000);
                });
            });

            tinymce.dom.Event.add(editor.getBody(), "blur", function (e) {
                localPreserver.saveDraftBody();
                window.clearInterval(saveDraftIntervalId);
            });
        });
       
        ed.onKeyDown.add(function (ed, e) {
            if (e.keyCode == 8) {
                console.log(ed.selection.getNode());
                //e.preventDefault();
                //e.stopPropagation();
                //return false;
            }
        });
    }*/
});

/*function CustomSetupContent(editor_id, body, doc) { 
	var loadingText = "编辑器加载中...";
    if (body.innerHTML == loadingText || body.innerHTML == '<p>'+loadingText+'</p>' || (body.inner.innerHTML < 30 && HTMLbody.innerHTML.indexOf(loadingText) >= 0)) {
        body.innerHTML = '';
    }
}


function MCECheckIndent(e) {
    if (e.type == 'keydown' && e.keyCode == 9) {
        tinyMCE.execCommand('mceInsertContent', false, '　　');
        try {
            return tinymce.dom.Event.cancel(e);
        }
        catch (e) {
            return false;
        }
    }
}

function InsertToEditor(content) {    
    tinyMCE.execCommand('mceInsertContent', false, content);
}

function ChromeFilter(content) {
    if (navigator.userAgent.indexOf('Chrome') >= 0) {
        content = content.replace(/style="([^"]*)"/g, '');
    }
    return content;
}
*/

