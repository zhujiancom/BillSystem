(function($) {
    var docLoaded = false;
    $(document).ready(function() {
        docLoaded = true;
    });
    $.fn.tabs = function(options) {
        return this.each(function() {
            if (!docLoaded) {
                var t = this;
                $(document).ready(function() {
                    generateTab(t, options);
                });
            } else {
                generateTab(this, options);
            }
        });
    };
    var generateTab = function(obj, options) {
        if (obj.tab) return false;
        // 如果tab已经存在，直接返回
        options = $.extend({
            ajax:false,
            //要异步执行的action
            dataType:"json",
            //默认使用json格式传输数据
            method:"POST"
        }, options);
        var iframePanel;
        var currentTab;
        var g = {
            /**
				初始化tab组件
			*/
            init:function() {
                $(obj).addClass("tab_box");
                currentTab = $("ul", obj).children(":first");
                currentTab.addClass("active");
                iframePanel = g.generateContentpanel();
                $(".contentpanel", obj).append(iframePanel);
//                iframePanel.attr("src", $("a", currentTab).attr("href"));
                $("a", currentTab).attr("target","contentPanel").children("span").click();
                $("ul li", obj).each(function(index, value) {
                    var _this = $(this);
                    $("a", _this).click(function(event) {
                        g.selectTab(_this, event);
                    });
                });
            },
            generateContentpanel:function() {
                var _iframe = document.createElement("iframe");
                var $_iframe = $(_iframe);
                $_iframe.attr({
                    id:"contentPanel",
                    name:"contentPanel",
                    "class":"iframeclass",
                    frameborder:"none",
                    border:0
                });
                $_iframe.bind("load",function(){
                	$(this).height($(this).contents().find("body").attr("scrollHeight")+20);
                });
                return $_iframe;
            },
            selectTab:function(ctab, event) {
                currentTab.removeClass("active").removeAttr("selected");
                currentTab = ctab;
                currentTab.addClass("active").attr("selected", "selected");
                var _this_ = ctab.find("a");
                var href = _this_.attr("href");
                if (_this_.attr("form")) {
                    //以form表单方式提交
                    event.preventDefault();
                    var formName = _this_.attr("rel");
                    var form = $("form[name=" + formName + "]");
                    form.attr("action", href).attr("target", "contentPanel");
                    form.submit();
                } else {
                    //以a标签方式提交
                    _this_.attr("target", "contentPanel");
                }
            }
        };
        obj.tab = g;
        obj.tab.init();
        return obj;
    };
})(jQuery);