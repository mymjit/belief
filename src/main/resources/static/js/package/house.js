+function (window, $) {
    'use strict';

    var House = function () {

    }

    var editor;
    $(function () {
        House.prototype.initialization();
    })

    $('#title').on('change', function () {
        House.prototype.titleVerification();
    })

    $('#author').on('change', function () {
        House.prototype.authorVerification();
    })

    $('#labelName').on('blur', function () {
        House.prototype.obtainLabers();
    })

    $('#labelName').on('change', function () {
        House.prototype.labelNameVerification();
    })

    $('#articleReleaseButton').on('click', function () {
        var flag = House.prototype.verification();
        if (flag) {
            var editorHtml = editor.getValue();
            var data = $('#articleFrom').serialize();
            data = data + "&paragraphContent=" + editorHtml;
            var url = "/article";
            $.request(url, data, 'post', function (data) {
                console.log(' success function : ', data);
                if (200 == data.code) {
                    //显示刚发布的文章

                    //tab切换
                    House.prototype.article_toggle();
                }
            })
        }
    })

    $('#break_button').on('click', function (e) {
        e.preventDefault();
        House.prototype.article_toggle();
    })


    House.prototype.article_toggle = function () {
        House.prototype.article_add_page_css_toggle();
        House.prototype.article_default_page_css_toggle();
    }

    House.prototype.article_add_page_css_toggle = function () {
        var article_add_page_class = $('#article_add_page').attr('class');
        if ('tab-pane fade' === article_add_page_class) {
            $('#article_add_page').attr('class', 'tab-pane fade in active');
        } else {
            $('#article_add_page').attr('class', 'tab-pane fade');
        }
    }

    House.prototype.article_default_page_css_toggle = function () {
        var article_default_page_class = $('#article_default_page').attr('class');
        if ('tab-pane fade' === article_default_page_class) {
            $('#article_default_page').attr('class', 'tab-pane fade in active');
        } else {
            $('#article_default_page').attr('class', 'tab-pane fade');
        }
    }

    House.prototype.initialization = function () {
        House.prototype.carouselInit();
        House.prototype.simditorInit();
        House.prototype.selectpickerInit();
    }

    House.prototype.obtainLabers = function () {
        var label = $('#labelName');
        var value = label.val();
        if ("" === value) {
            console.warn('House.prototype.obtainLabers labelName is Null character ')
        } else {
            var url = '/labers';
            var data = {'laberName': value}
            $.request(url, data, 'get', function (data) {
                console.log(' accord with laberName  : ', data);
            })
        }
    }

    House.prototype.carouselInit = function () {
        $('#carousel-example-generic').carousel({
            //滚动时间设置
            interval: 5000
        });

    }

    House.prototype.simditorInit = function () {
        var toolbar = ['title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale', 'color', 'ol', 'ul',
            'blockquote', 'code', 'table', 'link', 'image', 'hr', 'indent', 'outdent', 'alignment']
        editor = new Simditor({
            textarea: $('#paragraphContent'),
            toolbar: toolbar,
            placeholder: '请输入文章内容信息'
        });
    }

    House.prototype.selectpickerInit = function () {
        $("#labelName").multipleSelect({
            selectAllDelimiter: [ '=====','=====' ],
            selectAllText:'选中全部',
            allSelected:'全部选中',
            countSelected: '选中: #   &nbsp;&nbsp;    总计: %',
            noMatchesFound:'<button onclick="$.addLabel()" type="button" class="btn btn-default btn-sm btn-block">' +
            '添加标签？</button>',
            placeholder:'请选择或添加标签信息(多选)',
            selectAll: true,
            filter: true,
            multiple: false,
            onFilter: function () {
                // console.log('输入框拦截事件！');
            }
        });
    }
    // 为jQuery 装上新的 方法供multipleSelect 内部调用
    $.extend({
        addLabel: function () {
            var _text = $('.ms-search > input').val();
            var _html  = '<option >'+_text+'</option>';
            $("#labelName").append(_html).multipleSelect("refresh");
        }
    })

    House.prototype.titleVerification = function () {
        var title = $('#title').val();
        if ('' === title) {
            House.prototype.titleCssWarning();
            return false;
        }
        House.prototype.titleCssDefault();
        return true;
    }

    House.prototype.titleCssWarning = function () {
        $('#title').parent().attr('class', 'col-sm-4 has has-warning');
        $('#titlePrompt').attr('class', 'help-block show');
    }

    House.prototype.titleCssDefault = function () {
        $('#title').parent().attr('class', 'col-sm-4 has has-default');
        $('#titlePrompt').attr('class', 'help-block hidden');
    }

    House.prototype.authorVerification = function () {
        var author = $('#author').val();
        if ('' === author) {
            House.prototype.authorCssWarning();
            return false;
        }
        House.prototype.authorCssDefault();
        return true;
    }

    House.prototype.authorCssWarning = function () {
        $('#author').parent().attr('class', 'col-sm-4 has has-warning');
        $('#authorPrompt').attr('class', 'help-block show');
    }

    House.prototype.authorCssDefault = function () {
        $('#author').parent().attr('class', 'col-sm-4 has has-default');
        $('#authorPrompt').attr('class', 'help-block hidden');
    }

    House.prototype.labelNameVerification = function () {
        var labelName = $('#labelName').val();
        if ('' === labelName) {
            House.prototype.labelNameCssWarning();
            return false;
        }
        House.prototype.labelNameCssDefault();
        return true;
    }

    House.prototype.labelNameCssWarning = function () {
        $('#labelName').parent().attr('class', 'col-sm-4 has has-warning');
        $('#labelNamePrompt').attr('class', 'help-block show');
    }

    House.prototype.labelNameCssDefault = function () {
        $('#labelName').parent().attr('class', 'col-sm-4 has has-default');
        $('#labelNamePrompt').attr('class', 'help-block hidden');
    }

    House.prototype.paragraphContentVerification = function () {
        var paragraphContent = editor.getValue();
        if ('' === paragraphContent) {
            House.prototype.paragraphContentCssWarning();
            return false;
        }
        House.prototype.paragraphContentCssDefault();
        return true;
    }

    House.prototype.paragraphContentCssWarning = function () {
        $('#paragraphContent').parent('.col-xs-10').attr('class', 'col-sm-10 has has-warning');
        $('#paragraphContentPrompt').attr('class', 'help-block show');
    }

    House.prototype.paragraphContentCssDefault = function () {
        $('#paragraphContent').parents('.col-xs-10').attr('class', 'col-sm-10 has has-default');
        $('#paragraphContentPrompt').attr('class', 'help-block hidden');
    }

    House.prototype.verification = function () {
        var flag = true;
        flag = House.prototype.titleVerification();
        if (flag) {
            flag = House.prototype.authorVerification();
        }

        if (flag) {
            flag = House.prototype.authorVerification();
        }

        if (flag) {
            flag = House.prototype.paragraphContentVerification();
        }
        return flag;
    }
    

}(window, jQuery);


