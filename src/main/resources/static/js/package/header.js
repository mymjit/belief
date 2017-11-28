+function ($) {
    'use strict';

    // 打开登入的模态框  prototype 属性定义函数不污染全局
    $('#login_button').on('click', function () {
        Index.prototype.login_model();
    })

    $('#telephone_number').blur(function () {
        Index.prototype.telephone_number_verification();
    })

    $('#password').blur(function () {
        Index.prototype.password_verification();
    })

    $('#login').click(function () {
        Index.prototype.login_from_verification();
    })

    $('#register_button').click(function () {
        Index.prototype.login_model();
        Index.prototype.register_modal();
    })

    $('#register_telephone').blur(function () {
        Index.prototype.register_telephone_check();
    })

    $('#register_password').blur(function () {
        Index.prototype.register_password_verification();
    })

    $('#confirm_password').blur(function () {
        Index.prototype.confirm_password_verification();
    })
    //注册提交
    $('#register').click(function () {
        Index.prototype.register_button_from();
    })

    function Index() {
        return new Object();
    }



    Index.prototype.register_password_verification = function () {
        var flag = false;
        var regular_password = /^[a-zA-Z\d_]{8,}$/;
        var register_password = $('#register_password').val();
        if (regular_password.test(register_password)) {
            Index.prototype.help_block2_css_primary();
            flag = true;
        } else {
            //显示警告信息
            Index.prototype.help_block2_css_warning();
            Index.prototype.help_block2_html_update('密码长度必须大于八个字符,请重新输入！');
        }
        return flag;
    }

    Index.prototype.confirm_password_verification = function () {
        var flag = false;
        var register_password = $('#register_password').val();
        var confirm_password = $('#confirm_password').val();
        if (register_password == confirm_password) {
            Index.prototype.help_block3_css_primary();
            flag = true;
        } else {
            Index.prototype.help_block3_css_warning()
            Index.prototype.help_block3_html_update('密码与确认密码不一致,请重新输入！');
        }
        return flag;
    }

    Index.prototype.login_from_verification = function () {
        var flag1 = Index.prototype.telephone_number_verification();
        var flag2 = Index.prototype.password_verification();
        if (flag1 && flag2) { //账号密码都通过后提交表单
            Index.prototype.login_from();
        }
    }

    Index.prototype.register_from_verification = function () {
        var flag1 = Index.prototype.confirm_password_verification();
        if (flag1) {
            var flag2 = Index.prototype.register_telephone_verification();
            if (flag2) {
                var flag3 = Index.prototype.register_password_verification();
                if (flag3) {
                    return true;
                }
            }
        }
        return false;
    }

    Index.prototype.telephone_number_verification = function () {
        var flag = false;
        var regular = /^1\d{10}$/;
        var telephone_number = $('#telephone_number').val();
        if (regular.test(telephone_number)) {
            Index.prototype.help_user_css_primary();
            flag = true;
        } else {
            Index.prototype.help_user_html_update('请输入正确的手机号信息！');
            Index.prototype.help_user_css_warning();
        }
        return flag;
    }

    Index.prototype.password_verification = function () {
        var flag = false;
        var regular = /^[a-zA-Z\d_]{8,}$/;
        var password = $('#password').val();
        if (regular.test(password)) {
            Index.prototype.help_pass_css_primary();
            flag = true;
        } else {
            Index.prototype.help_pass_html_updaate('密码长度必须大于8个字符！');
            Index.prototype.help_pass_css_warning();
        }
        return flag;
    }

    Index.prototype.login_from = function () {
        var url = "/user/login"
        var data = $('#login_from').serialize();
        $.request(url, data, 'post',
            function (data) {
                //登入成功
                Index.prototype.login_model();
                Index.prototype.message_model_html_update(data.msg);
                Index.prototype.message_model_css_parimary();
                Index.prototype.message_model();
                if (602 == data.code) {
                    console.log("注册成功 {}: ", data);
                    Index.prototype.user_icon_css(data.data.telephoneNumber);
                    $.cookie('user', data.data.telephoneNumber);
                    $.cookie('token', data.data.token);
                } else {
                    $('#message_model').on('hidden.bs.modal', function () {
                        Index.prototype.message_close_login();
                    })
                }
            }
        )
    }

    Index.prototype.message_close_login = function () {
        Index.prototype.login_model();
    }

    Index.prototype.register_telephone_verification = function () {
        var flag = false;
        var regular_telephone = /^1\d{10}$/;
        var register_telephone = $('#register_telephone').val();
        if (regular_telephone.test(register_telephone)) {
            Index.prototype.help_block1_css_primary()
            flag = true;
        } else {
            Index.prototype.help_block1_css_warning()
            Index.prototype.help_block1_html_update('手机号码不正确,请重新输入');
        }
        return flag;
    }

    Index.prototype.register_telephone_check = function () {
        var register_telephone = $('#register_telephone').val();
        var url = "user/telephone/available";
        var data = {'telephone': register_telephone};
        var flag = Index.prototype.register_telephone_verification();
        if (flag) {
            $.request(url, data, 'get', function (data) {
                if (601 == data.code) { //账号可用
                    Index.prototype.help_block1_css_success();
                } else {

                    Index.prototype.help_block1_html_update("账号已注册");
                    Index.prototype.help_block1_css_warning();
                }
            }, function (data) {
                console.log('请求未正确的发送！');
            });
        }
    }
    //注册表单提交
    Index.prototype.register_button_from = function () {
        var flag = Index.prototype.register_from_verification();
        if (flag) { //注册验证通过提交表单
            var url = "/user/register";
            var data = $('#register_from').serialize();
            $.request(
                url, data, 'post',
                function (data) {
                    Index.prototype.register_modal();
                    Index.prototype.message_model_html_update(data.msg);
                    Index.prototype.message_model_css_parimary()
                    Index.prototype.message_model()
                    if (600 == data.code) {
                        //注册成功
                        console.log("注册成功 {}: ", data);
                    } else {
                        setTimeout(function () {
                            Index.prototype.message_model();
                            Index.prototype.register_modal();
                        }, 3000);
                    }
                }
            )
        }
    }

    Index.prototype.help_block1_css_success = function () {
        $('#help_block1').parent().attr('class', 'form-group has-success');
        $('#help_block1').attr('class', 'help-block hidden');
    }

    //注册模板中手机div的css控制 正常状态
    Index.prototype.help_block1_css_primary = function () {
        $('#help_block1').parent().attr('class', 'form-group has-primary');
        $('#help_block1').attr('class', 'help-block hidden');
    }

    //注册模板中手机div的css控制 警告状态
    Index.prototype.help_block1_css_warning = function () {
        $('#help_block1').parent().attr('class', 'form-group has-warning');
        $('#help_block1').attr('class', 'help-block show');
    }

    //注册模板中手机号码提示html控制
    Index.prototype.help_block1_html_update = function (str) {
        $('#help_block1').text(str);
    }

    Index.prototype.help_block2_css_primary = function () {
        $('#help_block2').parent().attr('class', 'form-group has-primary');
        $('#help_block2').attr('class', 'help-block hidden');
    }

    Index.prototype.help_block2_css_warning = function () {
        $('#help_block2').parent().attr('class', 'form-group has-warning');
        $('#help_block2').attr('class', 'help-block show');
    }
    //注册模板中手机号码提示html控制
    Index.prototype.help_block2_html_update = function (str) {
        $('#help_block3').text(str);
    }

    Index.prototype.help_block3_css_primary = function () {
        $('#help_block3').parent().attr('class', 'form-group has-primary');
        $('#help_block3').attr('class', 'help-block hidden');
    }

    Index.prototype.help_block3_css_warning = function () {
        $('#help_block3').parent().attr('class', 'form-group has-warning');
        $('#help_block3').attr('class', 'help-block show');
    }

    Index.prototype.help_block3_html_update = function (str) {
        $('#help_block3').text(str);
    }

    Index.prototype.login_model = function () {
        $('#login_modal').modal('toggle');
    }

    Index.prototype.register_modal = function () {
        $('#register_modal').modal('toggle');
    }

    Index.prototype.message_model = function () {
        $('#message_model').modal('toggle');
    }

    Index.prototype.message_model_css_warning = function () {
        $('#message').parent().attr('class', 'form-group has-warning');
    }

    Index.prototype.message_model_css_parimary = function () {
        $('#message').parent().attr('class', 'form-group has-parimary');
    }

    Index.prototype.message_model_html_update = function (str) {
        $('#message').text(str);
    }

    Index.prototype.help_user_css_primary = function () {
        $('#help_user').parent().attr('class', 'form-group has-parimary');
        $('#help_user').attr('class', 'help-block hidden');
    }

    Index.prototype.help_user_css_warning = function () {
        $('#help_user').parent().attr('class', 'form-group has-warning');
        $('#help_user').attr('class', 'help-block show');
    }

    Index.prototype.help_user_html_update = function (str) {
        $('#help_user').text(str);
    }

    Index.prototype.help_pass_css_primary = function () {
        $('#help_pass').parent().attr('class', 'form-group has-primary');
        $('#help_pass').attr('class', 'help-block hidden');
    }

    Index.prototype.help_pass_css_warning = function () {
        $('#help_pass').parent().attr('class', 'form-group has-warning');
        $('#help_pass').attr('class', 'help-block show');
    }

    Index.prototype.help_pass_html_updaate = function (str) {
        $('#help_pass').text(str);
    }

    Index.prototype.user_icon_css = function (userName) {
        $('#user_icon').attr('class', 'glyphicon glyphicon-user');
        $('#user_icon').children('strong').text(userName);
    }

    Index.prototype.user_update = function (id) {
        $('#token').text(id);
    }

}(jQuery)


