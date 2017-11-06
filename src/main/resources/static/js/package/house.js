+function($) {
    'use strict'; //严格模式


    // 页面点击事件的捕获
    $('#article_button').on('click' , function () {
        console.log("文章发布按钮的点击事件！！！");
        // 弹出发布文章的模态框
        House.prototype.article_add_page_show();
    });



    function House() {}

    //控制弹出的显示与隐藏
    House.prototype.article_model_toggle = function () {
        $('#article_model').modal('toggle');
    }

    House.prototype.article_add_page_show = function (e) {
        console.log("添加页面的切换！！");
        e.ppreventDefault();
        $('#article_add_page').tab('show');
    }

}(jQuery);
