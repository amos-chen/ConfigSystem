<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/5/3
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Page Description">
    <meta name="author" content="Amos">
    <title>配置管理管理系统</title>
    <%@include file="common/header.jsp" %>

</head>
<body>
<div class="wrapper">
    <div class="top-navbar">
        <nav class="navbar navbar-default navbar-static-top navbar-inverse" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <span class="iconfont icon-fw icon-msnui-sys-set"></span>配置管理管理系统
                </a>
            </div>

            <ul class="nav taotao-top-nav navbar-right">
                <li class="dropdown taotao-task">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="iconfont icon-02"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown taotao-alarm">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="iconfont icon-alarm"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown taotao-message">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="iconfont icon-xiazai16"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown taotao-user">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        USER <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#"><span class="iconfont icon-shezhi icon-fw"></span>设置</a></li>
                        <li><a href="#"><span class="iconfont icon-gerenzhongxin icon-fw"></span>个人中心</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="iconfont icon-tuichu icon-fw"></span>注销</a></li>
                    </ul>
                </li>
            </ul>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav metisFolder" id="menu">
                    <div class="input-group sidebar-search">
                        <input type="text" class="form-control" placeholder="search.."/>
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default">
                                <span class="iconfont icon-chaxun icon-fw" ></span>
                            </button>
                        </span>
                    </div>
                    <li class="active">
                        <a href="#" aria-expanded="true">
                            <%--<span class="fa fa-folder fa-fw"></span>配置管理
                            <span class="fa arrow"></span></a>--%>
                            <span class="folder"></span> 配置管理
                            <span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/addConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-jia"></span>添加配置</a></li>
                            <li><a href="/config/listConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-chaxun"></span>查询配置</a></li>

                        </ul>
                    </li>
                    <li>
                        <a href="#" aria-expanded="false">
                            <span class="folder"></span> 资料管理<span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/hardware">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-guanli icon-fw"></span>硬件管理</a></li>
                            <li><a href="/config/download">&nbsp;&nbsp;&nbsp;&nbsp;<span class="iconfont icon-msnui-download icon-fw"></span>规格书下载</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </div>
    <div class="page-wrapper">
        <ol class="breadcrumb bread-navbar">
            <li>
                <a href="#"><span class="fa fa-home fa-lg fa-fw"></span>首页</a>
            </li>
        </ol>
        <div class="wrapper-content">
            <h1><spring:message code="common.page.home"/> </h1>
        </div>
    </div>
</div>

<script type="text/javascript" src="/resources/js/loading.js"></script>

<%@include file="common/footer.jsp" %>
<script type="text/javascript">
    $("#menu").metisMenu({
//        toggle: false
    });

    $(document).ready(function () {
        $("#test").on('click', function () {
            $("#modal-download").modal('show');

        })
    })


</script>
</body>
</html>
