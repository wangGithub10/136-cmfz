<%--
  Created by IntelliJ IDEA.
  User: Helpless boy
  Date: 2018/12/6
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    request.setAttribute("path",request.getContextPath());
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/common.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>

    <link rel="stylesheet" type="text/css" href="${path}/view/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/view/themes/icon.css">
    <script type="text/javascript" src="${path}/view/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/view/js/jquery.easyui.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //点击更换验证码
            $("#captchaImage").click(function(){//点击更换验证码
                $(this).prop("src","${path}/gainValidateCode.do?time="+(new Date()).getTime()+"");
            });

            //效验验证码
            $('#enCode').blur(function(){
                var enCode = $('input[name="enCode"]').val();
                $.ajax({
                    type:'POST',
                    url:'${path}/manager/compare.do',
                    data:'enCode='+enCode,
                    success:function(data){
                        if(data){
                            $('#enCode').validatebox({
                                validType:'equalsCode['+data+']',
                            });
                        }else{
                            $('#enCode').validatebox({
                                validType:'equalsCode['+data+']',
                            });
                        }
                    },
                    error:function(){
                       alert("error");
                    }
                });
            });

            //验证账户文本框
            $('#username2').validatebox({
                required:true,
                missingMessage:'请输入账户名',
            });

            //验证密码文本框
            $('input[name="password"]').validatebox({
                required:true,
                missingMessage:'请输入密码'
            });

            //验证验证码
            $('#enCode').validatebox({
                required:true,
                missingMessage:'请输入验证码',
                tipPosition:'left'
            });

            //  form 表单提交
            $("#loginForm").form({
                url:'${path}/manager/login.do',
                onSubmit:function(){
                    var validate = $(this).form("validate");
                    return validate;
                },
                success:function(data){
                    var a = eval('(' + data + ')');/* 将json转换成javascript对象 */
                    if(a.mess!=null){
                        alert(a.mess);
                    }else{
                        location.href="${path}/view/main/main.jsp";
                    }
                }
            });
            $('#loginForm').submit();

            //重写效验规则
            $.extend($.fn.validatebox.defaults.rules, {
                //校验验证码
                equalsCode:{
                    validator: function(value,param){
                        return param[0];
                    },
                    message:'验证码错误'
                },
            });
        });
    </script>
</head>
<body>
    <div class="login">
        <form id="loginForm" action="${path}/manager/login.do" method="post" >

            <table><tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif" />
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" id="username2" name="username" class="text" value="" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" value="" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="${path}/gainValidateCode.do" title="点击更换验证码" style="width: 100px;"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='..'"><input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody></table>
            <div class="powered">COPYRIGHT © 2008-2017.</div>
            <div class="link">
                <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
                <a href="http://www.chimingbbs.com/">交流论坛</a> |
                <a href="">关于我们</a> |
                <a href="">联系我们</a> |
                <a href="">授权查询</a>
            </div>
        </form>
    </div>
</body>
</html>