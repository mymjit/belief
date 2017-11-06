//针对一些常用的代码进行封装
+function ($) {
    'use strict';
    //对jquery ajax进行二次封装
    $.extend({
        request : function ( url, data , type , success ) {
            $.ajax({
                url : url,
                data : data,
                type : type,
                dataType : 'json',
                success : function (data) {
                    success(data);
                },
                error : function (e) {
                    console.error( '错误信息 : ', e );
                }
            })

        }
    })
}(jQuery)





