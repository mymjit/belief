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

    // processData用于对 data参数进行序列化处理，默认值是true
    // 因为 summernote已经对图片进行了序列化所以这里就不需要
    $.extend({
        sendFiles : function (url,data , success) {
            $.ajax({
                url  : url,
                type : 'post',
                data : data,
                processData: false,
                contentType: false,
                dataType: 'json',
                success: function (data) {
                    success(data);
                }
            })
        }
    })

}(jQuery)





