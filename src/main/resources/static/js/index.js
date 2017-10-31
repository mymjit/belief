var index = {
    //ajax 验证账号是否可用
    register_telephone_check: function () {
        var register_telephone = $('#register_telephone').val();

        var url = "user/telephone/available";
        var data = {'telephone': register_telephone};
        var flag = index.register_telephone_verification();
        if (flag) {
            my_ajax.ajax_common(url, data, 'get', function (data) {
                if (601 == data.code) { //账号可用
                    index.help_block1_css_success();
                } else {
                    index.help_block1_html_update("账号已注册!")
                    index.help_block1_css_warning();
                }
            }, function (data) {
                console.log('请求未正确的发送！');
            });
        }

    },

    //注册模板中手机div的css控制 正常状态
    help_block1_css_primary: function () {
        $('#help_block1').parent().attr('class', 'form-group has-primary');
        $('#help_block1').attr('class', 'help-block hidden');
    },

    //注册模板中手机号div的css控制 可用状态
    help_block1_css_success: function () {
        $('#help_block1').parent().attr('class', 'form-group has-success');
        $('#help_block1').attr('class', 'help-block hidden');
    },

    //注册模板中手机div的css控制 错误状态
    help_block1_css_error: function () {
        $('#help_block1').parent().attr('class', 'form-group has-error');
        $('#help_block1').attr('class', 'help-block show');
    },

    //注册模板中手机div的css控制 警告状态
    help_block1_css_warning: function () {
        $('#help_block1').parent().attr('class', 'form-group has-warning');
        $('#help_block1').attr('class', 'help-block show');
    },

    //注册模板中手机号码提示html控制
    help_block1_html_update: function (str) {
        $('#help_block1').text(str);
    },


    //注册模块中密码的提示信息css 正常状态
    help_block2_css_primary: function () {
        $('#help_block2').parent().attr('class', 'form-group has-primary');
        $('#help_block2').attr('class', 'help-block hidden');
    },

    //注册模板中手机号div的css控制 可用状态
    help_block2_css_success: function () {
        $('#help_block2').parent().attr('class', 'form-group has-success');
        $('#help_block2').attr('class', 'help-block hidden');
    },

    //注册模块中确认密码的提示信息css 错误状态
    help_block2_css_error: function () {
        $('#help_block2').parent().attr('class', 'form-group has-error');
        $('#help_block2').attr('class', 'help-block show');
    },

    //注册模块中确认密码的提示信息css 警告状态
    help_block2_css_warning: function () {
        $('#help_block2').parent().attr('class', 'form-group has-warning');
        $('#help_block2').attr('class', 'help-block show');
    },

    //注册模板中手机号码提示html控制
    help_block2_html_update: function (str) {
        $('#help_block3').text(str);
    },


    //注册模块中确认密码的提示信息css 正常状态
    help_block3_css_primary: function () {
        $('#help_block3').parent().attr('class', 'form-group has-primary');
        $('#help_block3').attr('class', 'help-block hidden');
    },

    //注册模块中确认密码的提示信息css 错误状态
    help_block3_css_error: function () {
        $('#help_block3').parent().attr('class', 'form-group has-error');
        $('#help_block3').attr('class', 'help-block show');
    },

    //注册模块中确认密码的提示信息css 警告状态
    help_block3_css_warning: function () {
        $('#help_block3').parent().attr('class', 'form-group has-warning');
        $('#help_block3').attr('class', 'help-block show');
    },

    //注册模板中手机号码提示html控制
    help_block3_html_update: function (str) {
        $('#help_block3').text(str);
    },


    //注册模板提交表单
    register_button_from: function () {
        var flag = index.register_from_verification();
        if (flag) { //注册验证通过提交表单
            var url = "/user/register";
            var data = $('#register_from').serialize();
            my_ajax.ajax_common(
                url, data, 'post',
                function (data) {
                    index.register_modal(); //关闭按钮
                    index.message_model_html_update(data.msg);
                    index.message_model_css_parimary();
                    index.message_model();  //弹出提示
                    if (600 == data.code) {
                        //注册成功
                        console.log("注册成功 {}: ", data);
                    } else {
                        setTimeout( function () {
                            index.message_model(); //关闭提示
                            index.register_modal(); //弹出注册修改
                        } , 3000);
                    }
                }, function (e) {
                    //注册失败
                    console.log("请求发送失败 :" + e);
                }
            )
        }
    },

    // 手机号码前端验证
    register_telephone_verification: function () {
        var flag = false;
        var regular_telephone = /^1\d{10}$/;
        var register_telephone = $('#register_telephone').val();
        if (regular_telephone.test(register_telephone)) {
            index.help_block1_css_primary();
            flag = true;
        } else {
            index.help_block1_css_warning();
            index.help_block1_html_update("手机号吗不正确,请重新输入！");
        }
        return flag;
    },

    // 密码正则验证
    register_password_verification: function () {
        var flag = false;
        var regular_password = /^[a-zA-Z\d_]{8,}$/;
        var register_password = $('#register_password').val();
        if (regular_password.test(register_password)) {
            index.help_block2_css_primary();
            flag = true;
        } else {
            //显示警告信息
            index.help_block2_css_warning();
            index.help_block2_html_update("密码长度必须大于八个字符,请重新输入！")
        }
        return flag;
    },

    //确认密码验证
    confirm_password_verification: function () {
        var flag = false;
        var register_password = $('#register_password').val();
        var confirm_password = $('#confirm_password').val();
        if (register_password == confirm_password) {
            index.help_block3_css_primary();
            flag = true;
        } else {
            index.help_block3_css_warning();
            index.help_block3_html_update("密码与确认密码不一致,请重新输入！");
        }
        return flag;
    },

    // 注册提交前对整个表单进行验证
    register_from_verification: function () {
        var flag1 = index.confirm_password_verification();
        if (flag1) {
            var flag2 = index.register_telephone_verification();
            if (flag2) {
                var flag3 = index.register_password_verification();
                if (flag3) {
                    return true;
                }
            }
        }
        return false;
    },

    //打开或 关闭登入弹窗
    login_model: function () {
        $('#login_modal').modal('toggle');
    },
    //打开或关闭注册弹窗
    register_modal: function () {
        $('#register_modal').modal('toggle');
    },
    //打开或关闭消息弹窗
    message_model: function () {
        $('#message_model').modal('toggle');
    },


    message_model_css_warning: function () {
        $('#message').parent().attr('class', 'form-group has-warning');
    },

    message_model_css_parimary: function () {
        $('#message').parent().attr('class', 'form-group has-parimary');
    },

    //修改message 弹出框的内容
    message_model_html_update: function (str) {
        $('#message').text(str);
    },

    /******* 登入事件处理 ********/
    //登入账号div css 状态 一般
    help_user_css_primary: function () {
        $('#help_user').parent().attr('class', 'form-group has-parimary');
        $('#help_user').attr('class', 'help-block hidden');
    },
    //登入账号div css 状态 好的
    help_user_css_success: function () {
        $('#help_user').parent().attr('class', 'form-group has-success');
        $('#help_user').attr('class', 'help-block hidden');
    },
    //登入账号div css 状态 警告
    help_user_css_warning: function () {
        $('#help_user').parent().attr('class', 'form-group has-warning');
        $('#help_user').attr('class', 'help-block show');
    },
    //登入账号div html 修改
    help_user_html_update: function (str) {
        $('#help_user').text(str);
    },

    //登入密码div css 状态 一般
    help_pass_css_primary: function () {
        $('#help_pass').parent().attr('class', 'form-group has-primary');
        $('#help_pass').attr('class', 'help-block hidden');
    },
    //登入密码div 样式 状态 成功
    help_pass_css_success: function () {
        $('#help_pass').parent().attr('class', 'form-group has-success');
        $('#help_pass').attr('class', 'help-block hidden');
    },
    //登入密码div css 状态 警告
    help_pass_css_warning: function () {
        $('#help_pass').parent().attr('class', 'form-group has-warning');
        $('#help_pass').attr('class', 'help-block show');
    },
    //登入密码div html 修改
    help_pass_html_updaate: function (str) {
        $('#help_pass').text(str);
    },

    //账号验证
    telephone_number_verification: function () {
        var flag = false;
        var regular = /^1\d{10}$/;
        var telephone_number = $('#telephone_number').val();
        if (regular.test(telephone_number)) {
            index.help_user_css_primary();
            flag = true;
        } else {
            index.help_user_html_update("请输入正确的手机号信息！")
            index.help_user_css_warning();
        }
        return flag
    },

    //密码验证
    password_verification: function () {
        var flag = false;
        var regular = /^[a-zA-Z\d_]{8,}$/;
        var password = $('#password').val();
        if (regular.test(password)) {
            index.help_pass_css_primary();
            flag = true;
        } else {
            index.help_pass_html_updaate("密码长度必须大于8个字符！")
            index.help_pass_css_warning();
        }
        return flag;
    },

    //登入前验证
    login_from_verification: function () {
        var flag1 = index.telephone_number_verification();
        var flag2 = index.password_verification();
        if (flag1 && flag2) { //账号密码都通过后提交表单
            index.login_from();
        }
    },


    login_from: function () {
        var url = "/user/login"
        var data = $('#login_from').serialize();
        console.log(data);
        my_ajax.ajax_common(
            url, data, 'post',
            function (data) {
                //登入成功
                index.login_model();    //关闭登入框
                index.message_model_html_update(data.msg);
                index.message_model_css_parimary();
                index.message_model();  //弹出提示
                if( 602 == data.code ){
                    console.log("注册成功 {}: ", data);
                    index.user_update(data.data.id);
                    index.user_icon_css(data.data.telephoneNumber);
                } else {
                    setTimeout(function () {
                        index.message_model_css_warning();
                        index.message_model();
                        index.login_model();
                    },3000)
                }
            }, function (e) {
                //注册失败
                console.log("请求发送失败 : {}", e);
            }
        )
    },

    //登入成功将用户图标改变
    user_icon_css : function (userName) {
        $('#user_icon').attr('class','glyphicon glyphicon-user');
        $('#user_icon').children('strong').text(userName);
    },

    user_update: function (id) {
        $('#token').text(id);
    }

}

