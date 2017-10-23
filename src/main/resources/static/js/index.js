var index ={
    show_hide: function(width){
        if(  770 > width ){
            // 小屏幕显示方案
            this.small_show_large_hidden();
        }
        else{
            //大屏幕显示方案
            this.small_hidden_large_show();
        }
    },
    //小屏幕显示,大屏幕隐藏
    small_show_large_hidden : function(){
        this.large_hidden()
        this.small_show();
    },
    //小屏幕隐藏,大屏幕显示
    small_hidden_large_show : function(){
        this.small_hidden();
        this.large_show();
    },
    //小屏幕显示
    small_show : function(){
        $('.small_screen').show();
    },
    //小屏幕隐藏
    small_hidden : function(){
        $('.small_screen').hide();
    },
    //大屏幕显示
    large_show : function(){
        $('.large_screen').show();
    },
    //大屏幕隐藏
    large_hidden: function(){
        $('.large_screen').hide();
    },

    //校验注册二次输入的密码是否一致
    passworderification : function () {
        var registerPassWord =  $('#registerPassWord').val();
        var confirmPassWord  =  $('#confirmPassWord').val();
        if ( registerPassWord==confirmPassWord  ){
            return true;
        } else {
            index.tooltipToggle();
            window.setTimeout(function () {
                $('#helpBlock1').attr('class','help-block hidden');
                $('#confirmPassWord').parent().attr('class','form-group has-primary');
            },3000);
            return false;
        }
    },

    tooltipToggle : function () {
        var flag = $('#confirmPassWord').parent().attr('form-group has-error');
        if( typeof(flag) == 'undefined' ){
            $('#helpBlock1').attr('class','help-block show');
            $('#confirmPassWord').parent().attr('class','form-group has-error');
        }
    },

    //注册
    register_from : function (data , url) {
        var flag = index.passworderification();
        if( flag ){
            $.ajax({
                url : url,
                data: data,
                type: 'POST',
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success : function ( data ) {
                    console.log( 'code : '+ data.code + 'msg : ' +data.msg +' data : '+data.data)
                    if( 11000 == data.code ){
                        index.register_modal(); //关闭注册框
                        index.message_model_init(true,data.msg);
                        index.message_model();
                    } else {
                        index.register_modal(); //关闭注册框
                        index.message_model_init(false,data.msg);
                        index.message_model();
                    }

                },
                error : function (data) {
                    index.message_model_init(false,"注册失败,请检查网络连接！");
                    index.message_model();
                }
            })
        }
    },

    //登入
    login_from : function(data ,url) {
        $.ajax({
            url : url,
            data: data,
            type: 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success : function ( data ) {
            }
        })
    },

    //打开或 关闭登入弹窗
    login_model : function () {
        $('#loginModal').modal('toggle');
    },
    //打开或关闭注册弹窗
    register_modal : function () {
        $('#registerModal').modal('toggle');
    },
    //消息弹窗参数
    message_model_init : function (boo , message) {
        if ( true == boo ){
            $('#message').attr('class','text-success');
        } else{
            $('#message').attr('class','text-danger');
        }
        $('#message').html(message);
    },
    //消息弹窗的调用方法
    message_model : function () {
        $('#messageModel').modal('toggle');
    }

}

