<%--
  Created by IntelliJ IDEA.
  User: chenlunwei
  Date: 2017/5/6
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title><spring:message code="common.title"/></title>
    <%@include file="common/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/basicCss/jstree-style.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrap-table.min.css">

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
                    <span class="iconfont icon-fw icon-msnui-sys-set" style="font-size: 18px!important;"></span><spring:message
                        code="common.navbar.brand"/>
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
                        <li><a href="#"><span class="iconfont icon-shezhi icon-fw"></span> <spring:message
                                code="common.user.setting"/></a></li>
                        <li><a href="#"><span class="iconfont icon-gerenzhongxin icon-fw"></span> <spring:message
                                code="common.user.info"/></a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="iconfont icon-tuichu icon-fw"></span> <spring:message
                                code="common.user.logout"/></a></li>
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
                                <span class="iconfont icon-chaxun icon-fw"></span>
                            </button>
                        </span>
                    </div>
                    <li>
                        <a href="#" aria-expanded="true">
                            <%--<span class="fa fa-folder fa-fw"></span>配置管理
                            <span class="fa arrow"></span></a>--%>
                            <span class="folder"></span> <spring:message code="common.page.config.manage"/>
                            <span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/addConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-jia"></span> <spring:message
                                    code="common.page.config.add"/></a></li>
                            <li><a href="/config/listConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-chaxun"></span> <spring:message
                                    code="common.page.config.list"/></a></li>

                        </ul>
                    </li>
                    <li class="active">
                        <a href="#" aria-expanded="false">
                            <span class="folder"></span> <spring:message code="common.page.data.manage"/><span
                                class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/hardware">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-guanli icon-fw"></span> <spring:message
                                    code="common.page.data.datasheet"/></a></li>
                            <li><a href="/config/download">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-msnui-download icon-fw"></span>
                                <spring:message code="common.page.data.download"/></a>
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
                <a href="/"><span class="iconfont icon-fw icon-shouye"></span> <spring:message code="common.page.home"/></a>
            </li>
            <li><a href="#"><spring:message code="common.page.data.manage"/></a></li>
            <li class="active"><spring:message code="common.page.data.download"/></li>
        </ol>
        <div class="wrapper-content">
            <div class="row">
                <div class="col-lg-3">
                    <div class="panel panel-default">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">导航</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group" style="display: -webkit-box;">
                                    <div class="col-sm-12 search-group">
                                        <input id="tree-search" type="text" placeholder="search..."/>
                                        <span class="iconfont icon-chaxun icon-fw"/>
                                    </div>
                                </div>
                                <div id="jstree" style="padding-left: 10px"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="panel panel-default">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">资料下载</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-content">
                                    <table id="download-table"></table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<%@include file="common/footer.jsp" %>
<script type="text/javascript" src="/resources/js/basicJs/jstree.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/bootstrap-table-zh-CN2.min.js"></script>


<script type="text/javascript" src="/resources/js/hardware.js"></script>
<script type="text/javascript" src="/resources/js/downloadTable.js"></script>


<script type="text/javascript">
    //初始化左侧菜单
    $("#menu").metisMenu({
//        toggle: false
    });
    hardware.initTree();
    downloadTable.showTabale();
</script>
</body>
</html>
