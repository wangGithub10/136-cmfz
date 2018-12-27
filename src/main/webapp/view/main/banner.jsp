<%--
  Created by IntelliJ IDEA.
  User: Helpless boy
  Date: 2018/12/7
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<html>
<body>
    <script type="text/javascript">
        $(function(){
            $('#banner').edatagrid({
                url:'${path}/banner/queryAll.do',
                fitColumns:true,
                updateUrl:"${path}/banner/update.do",//修改方法
                columns:[[
                    {field:'title',title:'名字',width:100},
                    {field:'status',title:'状态',width:100,editor:{type:'validatebox',options:{required:true}}},
                    {field:'imgPath',title:'路径',width:100},
                    {field:'createDate',title:'时间',width:100}
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="/cmfz_wyq/'+rowData.imgPath+'" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>date: ' + rowData.createDate + '</p>' +
                        '<p>description: ' + rowData.description + '</p>' +
                        '<p>path: ' + rowData.imgPath + '</p>' +
                        '</td>' +
                        '</tr></table>';
                },
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function(){
                            $('#DBanner').dialog({
                                title:'添加轮播图',
                                width:400,
                                height:260,
                                modal:true,
                                buttons:[
                                    {
                                        text:'添加',
                                        handler:function(){
                                            $('#FBanner').form({
                                                url:'${path}/banner/insert.do',
                                                onSubmit:function(){
                                                    var validate = $('#FBanner').form('validate');
                                                    return validate;
                                                },
                                                success:function(data){
                                                    if(data=="ok"){
                                                        $('#DBanner').dialog('close');
                                                        $('#FBanner').form('reset');
                                                    }
                                                    $('#banner').datagrid('load');
                                                }
                                            });
                                            $('#FBanner').submit();
                                        }
                                    },{
                                        text:'重置',
                                        handler:function(){
                                            $('#FBanner').form('reset');
                                        }
                                    }
                                ]
                            })
                        }
                    },
                    {
                        text:'修改',
                        iconCls:'icon-edit',
                        handler:function(){
                            var selected = $('#banner').datagrid('getSelected');
                            if(selected!=null){
                                $('#banner').edatagrid("editRow",$("#banner").edatagrid("getRowIndex",selected));
                            }else{
                                $.messager.alert('警告','请选着一行信息','warning');
                            }
                        }
                    },
                    {
                        text:'删除',
                        iconCls:'icon-remove',
                        handler:function(){
                            var selected = $('#banner').datagrid('getSelected');
                            if(selected!=null){
                                $('#DBanner2').dialog({
                                    title:'删除',
                                    width:260,
                                    height:150,
                                    modal:true,
                                    buttons:[
                                        {
                                            text:'确定',
                                            handler:function(){
                                                console.log(selected)
                                                $.ajax({
                                                    type:'POST',
                                                    url:'${path}/banner/delete.do',
                                                    data:'id='+selected.id+'&imgPath='+selected.imgPath,
                                                    success:function(data){
                                                        console.log(data);
                                                        if(data){
                                                            $('#DBanner2').dialog('close');
                                                            $('#banner').datagrid('load');
                                                        }else{
                                                            $('#DBanner2').dialog('close');
                                                            $.messager.alert('警告','删除失败','warning');
                                                        }
                                                    },
                                                    error:function(){
                                                        alert("error");
                                                    }
                                                })
                                            }
                                        },{
                                            text:'取消',
                                            handler:function(){
                                                $('#DBanner2').dialog('close');
                                            }
                                        }
                                    ]
                                });
                            }else{
                                $.messager.alert('警告','请选着一行信息','warning');
                            }
                        }
                    },
                    {
                        text:'保存',
                        iconCls:'icon-save',
                        handler:function(){
                            $('#banner').edatagrid('saveRow');
                        }
                    }
                ],
                fit:true,//自动适应父容器
                pagination:true,//在底部显示分页工具栏
                //pageNumber:1,//初始化页码
                //pageSize:5,//初始化页面大小
                //pageListL:[5,10,15,20,25]//初始话页面大小选着框
                striped:true,//显示斑马效果
                loadMsg:'数据加载中',//远程数据加载时的提示信息
                singleSelect:true,//只能选择一行
            });
            $('input[name="title"]').validatebox({
                required:true,
                missingMessage:'请输入图片标题~'
            });
            $('input[name="description"]').validatebox({
                required:true,
                missingMessage:'请输入图片描述~'
            });
        });
    </script>
    <table id="banner"></table>
    <div id="DBanner" style="display: none">
        <form id="FBanner" method="post" enctype="multipart/form-data">
            <table style="margin-left: 65px;margin-top: 40px;">
                <tr>
                    <td>图片标题：</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>图片路径：</td>
                    <td><input type="file" name="fileName"></td>
                </tr>
                <tr>
                    <td>图片描述：</td>
                    <td><input type="text" name="description"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="DBanner2" style="display: none"><div style="font-size: 18px;">你确定要删除吗？</div></div>
</body>
</html>
