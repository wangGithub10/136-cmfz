<%--
  Created by IntelliJ IDEA.
  User: Helpless boy
  Date: 2018/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    request.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>

    <link rel="stylesheet" type="text/css" href="${path}/view/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/view/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${path}/view/themes/IconExtension.css">
    <script type="text/javascript" src="${path}/view/js/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/view/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${path}/view/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${path}/view/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${path}/view/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        <!--菜单处理-->
        $(function(){
            $.ajax({
                type:'POST',
                url:'${path}/menu/queryAll.do',
                success:function(data){
                    for(var i=0;i<data.length;i++){
                        var contents = "";
                        for(var j=0;j<data[i].menus.length;j++){
                            contents += "<a class='easyui-linkbutton' data-options='width:210,plain:true' onclick='addTab("+JSON.stringify(data[i].menus[j])+")'>"+data[i].menus[j].title+"</a><br/>";
                        }
                        $('#aa').accordion("add", {
                            title: data[i].title,
                            selected:false,
                            content:contents
                        });
                    }
                },
                error:function(){
                    alert("error");
                }
            });
            $('#linkbutton').linkbutton({
                iconCls:'icon-edit',
                onClick:function(){
                    $('#DPassword').dialog({
                       title:'修改密码',
                        width:280,
                        height:230,
                        buttons:[
                            {
                                text:'确定',
                                handler:function(){
                                    $('#changePassword').form({
                                        url:'${path}/manager/update.do',
                                        onSubmit:function(){
                                            var validate = $('#changePassword').form("validate");
                                            return validate;
                                        },
                                        success:function(data){
                                            if(data=="true"){
                                                $('#DPassword').dialog('close');
                                                $('#changePassword').form('reset');
                                            }else{
                                                alert("旧密码错误，请重新输入！");
                                            }
                                        }
                                    });
                                    $('#changePassword').submit();
                                }
                            },{
                                text:'取消',
                                handler:function(){
                                    $('#DPassword').dialog('close');
                                    $('#changePassword').form('reset');
                                }
                            }
                        ]
                    });
                }
            });
            $('input[name="oldPassword"]').validatebox({
                required:true,
                missingMessage:'请输入旧密码'
            });
            $('input[name="newPassword"]').validatebox({
                required:true,
                missingMessage:'请输入新密码'
            });
        });
        function addTab(menus){
            var f = $('#tt').tabs('exists',menus.title);
            if(!f){
                $('#tt').tabs("add",{
                    title:menus.title,
                    closable:true,
                    href:"${path}"+menus.href
                });
            }else{
                $('#tt').tabs("select",menus.title);
            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
        <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
        <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.manager.username} &nbsp;<a id="linkbutton">修改密码</a>&nbsp;&nbsp;<a href="${path}/manager/logout.do" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>

    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
        <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
        <div id="aa" class="easyui-accordion" data-options="fit:true">

        </div>
    </div>

    <div data-options="region:'center'">
        <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
            <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
        </div>
    </div>

    <div id="DPassword" style="display: none">
        <form id="changePassword" method="post">
            <table style="margin-left: 25px;margin-top: 20px;">
                <tr>
                    <td>旧密码：</td>
                    <td><input type="password" name="oldPassword"></td>
                </tr>
                <tr>
                    <td>新密码：</td>
                    <td><input type="password" name="newPassword"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
