<%--
  Created by IntelliJ IDEA.
  User: zahui
  Date: 2019-07-28
  Time: 下午 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/css.css">
    <link rel="icon" href="/favicon.ico">

    <script type="text/javascript" src="<%=basePath %>layui/layui.js"></script>
    <title>客户信息管理系统</title>
</head>

<div class="login shadow">
    <div class="logo shadow">
        <img src="./img/logo.png" alt="">
    </div>
    <div class="logintop">
        <p class="title titleshadow">商家档案管理系统</p>
    </div>
    <form class="logintext usertext" id="utext">
        <div id="user" class="userlogin">
            <div class="input">
                <div>
                    <i class="iconfont icon-wo iconlogin"></i>
                    <input id="mid"  name="mid" type="text" placeholder="登录账号" required="" autocomplete="on">
                </div>
                <div>
                    <i class="iconfont icon-suo iconlogin"></i>
                    <input type="password" id="password" name="password" placeholder="密码" required="" autocomplete="on">
                </div>
            </div>
            <div class="action">
                <a class="fa" href="javascript:forget();">忘记密码</a>
                <br/>
                <input type="button" id="button1" class="login-button" lay-submit value="登录" lay-filter="submitBtn">
            </div>
        </div>
    </form>
    <form class="logintext phonetext" id="ptext">
        <div id="phone" class="phonelogin">
            <div class="input">
                <div>
                    <i class="iconfont icon-shouji iconlogin"></i>
                    <input id="userphone" name="phone" type="text" placeholder="手机号" required="" autocomplete="on">
                </div>
                <div>
                    <i class="iconfont icon-yanzhengma iconlogin"></i>
                    <input class="yzpasword" style="width: 130px;" name="yzpassword" type="password" placeholder="验证码"
                           required="" autocomplete="on">
                    <button class="yzbtu" type="button">点击获取</button>
                </div>
            </div>
            <div class="action">
                <a class="fa" href="javascript:forget();">忘记密码</a>
                <br />
                <input type="button" id="button2" class="login-button" lay-submit value="登录" lay-filter="submitBtn1">
            </div>
        </div>
    </form>
    <div class="tab">
        <a href="javascript:changeLogin();">
            <i id="tabuser" class="iconfont icon-diannao icondiannao"></i></a>
        <a href="javascript:changeLogin();">
            <i id="tabphone" class="iconfont icon-shouji1 iconphone"></i></a>
    </div>
    <div class="tablogo">
        <div class="tabfont">
            <p id="fontuser" class="font">验证码登录</p>
            <p id="fontphone" class="font">密码登录</p>
        </div>
        <div class="em"></div>
    </div>
</div>

<div class="bottom">
    <p class="banquan">2019 <a href="http://www.cap.edu.cn" target="_blank">成都航院信息工程学院</a>-学生会外联部©版权所有</p>
</div>
</body>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>js/login.js"></script>
<script src="<%=basePath%>js/index.js" data-main="login"></script>
<script src="<%=basePath%>js/changeImg.js"></script>
</html>
