<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/9/30
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <style type="text/css">
        /************ 实现大屏幕div下ul的上下居中 ************/
        .large_screen{
            position: relative;
        }
        .large_screen ul{
            position: absolute;
            left: 50%;
            top: 50%;
            transform:translate(-50%,-50%);
        }
    </style>
</head>
<body>
<div class="container">
    <!-- 小屏幕的页头 -->
    <div class="small_screen" style="margin-top: 10px; margin-bottom: 10px;" >
        <div class="dropdown">
            <button class="btn dropdown-toggle btn-primary btn-lg btn-block" id="dLabel" type="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                <span>Welcome You</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dLabel">
                <li role="presentation">Profile</li>
                <li role="separator" class="divider"></li>
                <li role="presentation">Messages</li>
            </ul>
        </div>
    </div>

    <!-- 大屏幕的页头 -->
    <div  class="large_screen" style="margin-top: 10px;" >
        <nav class="navbar navbar-default navbar-static-top">
            <ul class="nav nav-justified nav-pills" role="tablist">
                <li role="presentation" class="active">
                    <a href="#home" class="text-primary" aria-controls="home" role="tab" data-toggle="tab">
							<span class="glyphicon glyphicon-home" aria-hidden="true"> <strong>主页</strong>
							</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#profile" class="text-info" aria-controls="profile" role="tab" data-toggle="tab">
							<span class="glyphicon glyphicon-book" aria-hidden="true"> <strong>书屋</strong>
							</span>
                    </a>
                </li>
                <li role="presentation">
                    <a href="#messages" class="text-muted" aria-controls="messages" role="tab" data-toggle="tab">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true">
								<strong>日记</strong>
							</span>
                    </a>
                </li>
                <li id="login" role="presentation">
                    <a href="#" class="text-success" role="tab" data-toggle="tab">
							<span class="glyphicon glyphicon-grain" aria-hidden="true">
								<strong>登入解锁更多功能</strong>
							</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <!--       对应标签页要显示的内容       -->
    <div class="tab-content">
        <!-- 主页显示的模块  -->
        <div role="tabpanel" class="tab-pane active" id="home">
            <div class="jumbotron">
                <marquee  scrollamount="15" behavior="alternate" direction="right" align="middle">公告栏！！！</marquee>
                <marquee  scrollamount="15">公告栏！！！</marquee>
                <marquee  scrollamount="15">公告栏！！！</marquee>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">文章内容</div>
                        <table class="table table-hover table-condensed">
                            <thead>
                            <tr>
                                <td>ID</td>
                                <td>标题</td>
                                <td>详情</td>
                                <td>作者</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>ID</td>
                                <td>标题</td>
                                <td>详情</td>
                                <td>作者</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-6 col-md-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title">精彩新闻</h3>
                        </div>
                        <table class="table table-hover table-condensed">
                            <thead>
                            <tr>
                                <td>ID</td>
                                <td>标题</td>
                                <td>详情</td>
                                <td>作者</td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>ID</td>
                                <td>标题</td>
                                <td>详情</td>
                                <td>作者</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!--     书屋显示的模块     -->
        <div role="tabpanel" class="tab-pane" id="profile">
            <div class="row">
                <div class="col-xs-6 col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>文章标题</strong>
                        </div>
                        <!-- 文章标题 -->
                        <!-- <table class="table table-hover table-striped"></table> -->
                        <ol class="list-unstyled">
                            <li>文章标题</li>
                            <li>文章标题</li>
                            <li>文章标题</li>
                            <li>文章标题</li>
                            <li>文章标题</li>
                        </ol>
                    </div>
                </div>
                <div class="col-xs-12 col-md-8">
                    <div class="well well-sm">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <p class="text-info">
                                    文章内容
                                    Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.

                                    Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec ullamcorper nulla non metus auctor fringilla. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Donec ullamcorper nulla non metus auctor fringilla.

                                    Maecenas sed diam eget risus varius blandit sit amet non magna. Donec id elit non mi porta gravida at eget metus. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.
                                </p>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="well well-sm">
                                    <input type="text" class="form-control" placeholder="输入你的讨论...">
                                    <button type="button" style="margin-top: 5px; margin-left: 93%;" class="btn btn-info btn-sm">评论</button>
                                </div>
                                <div class="well well-sm">
                                    <p class="text-left">
                                        Left aligned text. Left aligned text.Left aligned text.Left aligned text.Left aligned text.Left aligned text.
                                    </p>
                                    <p class="text-right">姓名  2017/8/9</p>
                                </div>
                                <div class="well well-sm">
                                    <p class="text-left">Left aligned text.</p>
                                    <p class="text-right">姓名  2017/8/9</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--     日记显示的模块     -->
        <div role="tabpanel" class="tab-pane" id="messages">
            <!-- 16:9 aspect ratio -->
            <div class="embed-responsive embed-responsive-16by9">
                <img src="../img/test.jpg" class="img-responsive" alt="Responsive image">
                <!-- <iframe class="embed-responsive-item" src="index.html">sadjaks</iframe>
            -->
            </div>
        </div>
    </div>
</div>

<!-- 登入模态框  -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">欢迎登入</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group has-primary">
                        <label  >用 户 名:</label>
                        <input class="form-control"  placeholder="请输入用户名"></div>
                    <div class="form-group has-primary">
                        <label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <input class="form-control" placeholder="请输入密码"></div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="registerButton" type="button" class="btn btn-success" style="float: left;">注册账号</button>
                <button id="loginButton" type="button" class="btn btn-primary" style="float: right;">点我登入</button>
            </div>
        </div>
    </div>
</div>

<!--       注册模态框       -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">注册账号</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group has-primary">
                        <label >用 户 名:</label>
                        <input class="form-control" placeholder="请输入用户名"></div>
                    <div class="form-group has-primary">
                        <label >密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <input class="form-control"  placeholder="请输入密码"></div>
                    <div class="form-group has-primary">
                        <label >确认密码</label>
                        <input class="form-control" placeholder="请输入确认密码"></div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="registerAccount" type="button" class="btn btn-primary">注册账号</button>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"/>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"/>
<script src ="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
<script type="text/javascript" src="./resources/js/index.js"></script>
<script type="text/javascript">
    //屏幕改变事件
    window.onresize = function(){
        var width = document.body.clientWidth;
        console.log('屏幕改变事件 width: '+width);
        index.show_hide(width);
    }
    //文档加载完毕,判定屏幕显示的规格
    window.onload = function(){
        var width = document.body.clientWidth;
        console.log('文档加载完毕 width: '+width);
        index.show_hide(width);
    }
    //打开一个模态框
    $('#login').click(function(){
        $('#loginModal').modal('toggle');
    })
    //点击注册按钮
    $('#register').click(function(){
        $('#loginModal').modal('toggle');
        $('#registerModal').modal('toggle');
    });
</script>
</body>
</html>