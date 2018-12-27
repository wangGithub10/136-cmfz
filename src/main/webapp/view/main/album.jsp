<%--
  Created by IntelliJ IDEA.
  User: Helpless boy
  Date: 2018/12/10
  Time: 19:18
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
            $('#album').treegrid({
                url:'${path}/album/queryAll.do',//路径
                fitColumns:true,//自动分配列表宽
                idField:'id',//定义关键字段来标识树节点
                treeField:'title',//定义树节点字段
                columns:[[
                    {field:'title',title:'名字',width:100},
                    {field:'audioPath',title:'下载路径',width:100},
                    {field:'size',title:'章节大小',width:100},
                    {field:'length',title:'章节时长',width:100}
                ]],
                toolbar:[
                    {
                        text:'专辑详情',
                        iconCls:'icon-tip',
                        handler:function(){
                            var album = $('#album').treegrid('getSelected');
                            if(album!=null){
                                if(album.size==null){
                                    $('#FAlbum').form('load',{
                                        title:album.title,
                                        author:album.author,
                                        broadCast:album.broadCast,
                                        count:album.count,
                                        score:album.score,
                                        status:album.status,
                                        publicDate:album.publicDate,
                                        brife:album.brife
                                    });
                                    $('#img').prop('src','${path}'+album.corverImg);
                                    $('#DAlbum').dialog({
                                        title:'专辑详情',
                                        width:480,
                                        height:320,
                                        modal:true
                                    });
                                }else{
                                    $.messager.alert('警告','请选择一行专辑','warning');
                                }
                            }else{
                                $.messager.alert('警告','请选择一行专辑','warning');
                            }
                        }
                    },
                    {
                        text:'添加专辑',
                        iconCls:'icon-save',
                        handler:function(){
                            $('#DAlbum3').dialog({
                                title:'添加专辑',
                                width:480,
                                height:320,
                                modal:true,
                                buttons:[
                                    {
                                        text:'提交',
                                        handler:function(){
                                            $('#FAlbum3').form({
                                                url:'${path}/album/insert.do',
                                                onSubmit:function(){
                                                    var validate = $('#FAlbum3').form('validate');
                                                    return validate;
                                                },
                                                success:function(data){
                                                    if(data=="ok") {
                                                        $('#DAlbum3').dialog('close');
                                                        $('#FAlbum3').form('reset');
                                                    }
                                                    $('#album').treegrid('load');
                                                }
                                            });
                                            $('#FAlbum3').submit();
                                        }
                                    },{
                                        text:'重置',
                                        handler:function(){
                                            $('#FAlbum3').form('reset')
                                        }
                                    }
                                ]
                            });
                        }
                    },
                    {
                        text:'添加章节',
                        iconCls:'icon-save',
                        handler:function(){
                            var album = $('#album').treegrid('getSelected');
                            if(album!=null){
                                if(album.size==null){
                                    $('#DChapter').dialog({
                                        title:'添加章节',
                                        width:400,
                                        height:200,
                                        modal:true,
                                        buttons:[
                                            {
                                                text:'提交',
                                                handler:function(){
                                                    $('#FChapter').form({
                                                        url:'${path}/album/insert2.do',
                                                        queryParams:{
                                                            album_id:album.id
                                                        },
                                                        onSubmit:function(){
                                                            var validate = $('#FChapter').form('validate');
                                                            return validate;
                                                        },
                                                        success:function(data){
                                                            if(data=="ok") {
                                                                $('#DChapter').dialog('close');
                                                                $('#FChapter').form('reset');
                                                            }
                                                            $('#album').treegrid('load');
                                                        }
                                                    });
                                                    $('#FChapter').submit();
                                                }
                                            },{
                                                text:'重置',
                                                handler:function(){
                                                    $('#FChapter').form('reset')
                                                }
                                            }
                                        ]
                                    });
                                }else{
                                    $.messager.alert('警告','请选择一行专辑','warning');
                                }
                            }else{
                                $.messager.alert('警告','请选择一行专辑','warning');
                            }
                        }
                    },
                    {
                        text:'下载音频',
                        iconCls:'icon-undo',
                        handler:function(){
                            var chapter = $('#album').treegrid('getSelected')
                            if(chapter!=null){
                                if(chapter.size!=null){
                                    location.href="${path}/album/download.do?fileName="+chapter.audioPath;
                                }else{
                                    $.messager.alert('警告','请选择一行章节','warning');
                                }
                            }else{
                                $.messager.alert('警告','请选择一行章节','warning');
                            }
                        }
                    }
                ],
                fit:true,//自动适应父容器
                pagination:true,//在底部显示分页工具栏
                //pageNumber:1,//初始化页码
                //pageSize:5,//初始化页面大小
                //pageListL:[5,10,15,20,25]//初始话页面大小选着框
                loadMsg:'数据加载中',//远程数据加载时的提示信息
                singleSelect:true,//只能选择一行
                onDblClickRow:function(row){
                    if(row.size!=null){
                        $('#audio').prop('src','${path}'+row.audioPath);
                        $('#DAlbum2').dialog({
                            title:'音频播放',
                            width:340,
                            height:120,
                            modal:true
                        });
                    }
                }
            });
        });
    </script>
    <table id="album"></table>
    <div id="DAlbum" style="display: none">
        <form id="FAlbum">
            <table style="margin-left: 100px;margin-top: 10px;">
                <tr>
                    <td>专辑名称：</td>
                    <td><input type="text" name="title" readonly></td>
                </tr>
                <tr>
                    <td>作者：</td>
                    <td><input type="text" name="author" readonly></td>
                </tr>
                <tr>
                    <td>播音：</td>
                    <td><input type="text" name="broadCast" readonly></td>
                </tr>
                <tr>
                    <td>集数：</td>
                    <td><input type="text" name="count" readonly></td>
                </tr>
                <tr>
                    <td>封面：</td>
                    <td><img id="img" style="width: 80px;height: 50px;"></td>
                </tr>
                <tr>
                    <td>评分：</td>
                    <td><input type="text" name="score" readonly></td>
                </tr>
                <tr>
                    <td>状态：</td>
                    <td><input type="text" name="status" readonly></td>
                </tr>
                <tr>
                    <td>发布日期：</td>
                    <td><input type="text" name="publicDate" readonly></td>
                </tr>
                <tr>
                    <td>内容简介：</td>
                    <td><input type="text" name="brife" readonly></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="DAlbum2" style="display: none"><audio id="audio" controls style="margin-left: 10px;margin-top: 20px;"></audio></div>
    <div id="DAlbum3" style="display: none">
        <form id="FAlbum3" method="post" enctype="multipart/form-data">
            <table style="margin-left: 100px;margin-top: 10px;">
                <tr>
                    <td>专辑名称：</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>作者：</td>
                    <td><input type="text" name="author"></td>
                </tr>
                <tr>
                    <td>播音：</td>
                    <td><input type="text" name="broadCast"></td>
                </tr>
                <tr>
                    <td>集数：</td>
                    <td><input type="text" name="count"></td>
                </tr>
                <tr>
                    <td>封面图片：</td>
                    <td><input type="file" name="fileName"></td>
                </tr>
                <tr>
                    <td>评分：</td>
                    <td><input type="text" name="score"></td>
                </tr>
                <tr>
                    <td>发布日期：</td>
                    <td><input type="date" name="publicDate"></td>
                </tr>
                <tr>
                    <td>内容简介：</td>
                    <td><input type="text" name="brife"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="DChapter" style="display: none">
        <form id="FChapter" method="post" enctype="multipart/form-data">
            <table style="margin-left: 60px;margin-top: 15px;">
                <tr>
                    <td>专辑名称：</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>音频文件：</td>
                    <td><input type="file" name="fileName"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
