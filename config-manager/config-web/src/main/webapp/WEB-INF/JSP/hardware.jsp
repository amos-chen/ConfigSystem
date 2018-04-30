<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenlunwei
  Date: 2017/5/6
  Time: 19:23
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
    <title><spring:message code="common.title"/></title>
    <%@include file="common/header.jsp" %>
    <link rel="stylesheet" href="/resources/css/basicCss/jstree-style.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/select2.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/select2-bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrap-table.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrapValidator.min.css">
    <style type="text/css">
        body{
            padding-right: 0px!important;
        }
        .modal-open {
            overflow: initial !important;
        }
    </style>
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
            <li class="active"><spring:message code="common.page.data.datasheet"/></li>
        </ol>
        <div class="wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><spring:message code="common.page.data.datasheet"/></h3>
                            </div>
                            <div class="panel-body">
                                <div id="CatTree" class="CatTree col-lg-3">
                                    <div class="btn-group">
                                        <button type="button" id="catAdd" class="btn btn-default">
                                            <span class="fa fa-plus fa-fw"></span> <spring:message code="hardware.add"/>
                                        </button>
                                        <button type="button" id="catEdit" class="btn btn-default">
                                            <span class="fa fa-edit fa-fw"></span> <spring:message
                                                code="hardware.edit"/>
                                        </button>
                                        <button type="button" id="catDel" class="btn btn-default">
                                            <span class="fa fa-trash fa-fw"></span> <spring:message
                                                code="hardware.delete"/>
                                        </button>
                                    </div>
                                    <hr>
                                    <div id="jstree"></div>
                                    <input type="hidden" id="firstTimeLoaded" value="true"/>

                                    <%--当新增或删除父类节点时，需要重新加载select里的值--%>
                                    <input type="hidden" id="booleanLoadContentCat">
                                </div>
                                <div class="col-lg-9">
                                    <%--增删改的工具条--%>
                                    <div class="toolbar">
                                        <div class="btn-group">
                                            <a href="#" id="btn-add" type="button"
                                               class="btn btn-default">
                                                <span class="fa fa-plus fa-fw"></span> <spring:message
                                                    code="hardware.add.device"/></a>
                                            <a id="delete-selected" type="button" class="btn btn-default">
                                                <span class="fa fa-trash fa-fw"></span> <spring:message
                                                    code="hardware.delete.selected"/></a>
                                        </div>
                                    </div>

                                    <div class="table-content">
                                        <table id="hardware-content-table"></table>
                                    </div>
                                </div>
                            </div>

                            <%--新增以及修改内容类目modal--%>
                            <div class="modal" id="CatManage">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                            <h4 class="modal-title" id="CatManageModalTitle"></h4>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-horizontal" id="contentCatForm" role="form">
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label"
                                                           for="ParentId"><spring:message
                                                            code="hardware.add.father.name"/>：</label>
                                                    <div class=" col-sm-8">
                                                        <p>
                                                            <select class="form-control" name="ParentId"
                                                                    id="ParentId" style="width: 100%;"
                                                                    multiple="multiple"></select>
                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-4 control-label"
                                                           for="ContentName"><spring:message
                                                            code="hardware.add.category.name"/>：</label>
                                                    <div class=" col-sm-8">
                                                        <input type="text" class="form-control"
                                                               name="ContentName"
                                                               id="ContentName">
                                                    </div>
                                                </div>
                                            </form>
                                            <div class="modal-footer">
                                                <button type="submit" id="ContentCatSave" class="btn btn-primary">
                                                    <spring:message code="hardware.add.save"/>
                                                </button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">
                                                    <spring:message code="hardware.add.cancel"/>
                                                </button>
                                            </div>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->

                            <%--内容类目删除提示--%>
                            <div class="modal fade deleteModal" id="deleteModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                            <h4 class="modal-title"><span class="fa fa-warning fa-fw"></span>
                                                <spring:message code="hardware.operation.warning"/>:</h4>
                                        </div>
                                        <div class="modal-body">
                                            <h2 class="text-center text-danger"><spring:message
                                                    code="hardware.operation.deleteMessage"/></h2>
                                            <h5 class="text-center text-danger"><span
                                                    class="fa fa-warning fa-fw"></span>
                                                <spring:message code="hardware.operation.deleteInfo"/>
                                            </h5>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-success" data-dismiss="modal">
                                                <spring:message code="hardware.operation.cancel"/>
                                            </button>
                                            <button id="deleteConfirm" type="button" class="btn btn-danger">
                                                <spring:message code="hardware.operation.confirm"/></button>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.modal -->

                            <%--点击删除按键时的弹出框--%>
                            <div class="modal fade" id="modal-delete">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <div class="container-fluid text-center modal-delete">
                                                <div class="col-sm-12">
                                                    <div class="warnning-icon">
                                                        <span class="fa fa-warning fa-lg"></span>
                                                    </div>
                                                    <h1><strong><spring:message
                                                            code="hardware.operation.warning"/></strong></h1>
                                                    <p><spring:message code="hardware.operation.deleteMessage"/></p>
                                                    <a href="#" class="btn btn-success"
                                                       data-dismiss="modal"><spring:message
                                                            code="hardware.operation.cancel"/></a>
                                                    <a href="#" id="btn-remove" class="btn btn-danger"><spring:message
                                                            code="hardware.operation.confirm"/></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.modal -->

                            <%--内容新增/修改弹出框--%>
                            <div class="modal fade" id="contentManager">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                            <h3 class="contentManagerTitle"></h3>
                                        </div>
                                        <div class="modal-body">
                                            <form id="paramForm" class="form-horizontal" role="form"
                                                  enctype="multipart/form-data" method="post">

                                                <input type="hidden" id="contentId" name="id"/>
                                                <input type="hidden" id="contentCat" name="categoryId"/>

                                                <%--<div class="form-group">
                                                    <label for="model" class="col-sm-4 control-label"><spring:message code="hardware.add.device.model"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <input name="model" class="form-control" type="text"
                                                               id="model"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="length" class="col-sm-4 control-label"><spring:message code="hardware.add.device.length"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <input name="length" class="form-control" type="text"
                                                               id="length"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="width" class="col-sm-4 control-label"><spring:message code="hardware.add.device.width"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <input name="width" class="form-control" type="text"
                                                               id="width"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="height" class="col-sm-4 control-label"><spring:message code="hardware.add.device.height"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <input name="height" class="form-control" type="text"
                                                               id="height"/>
                                                    </div>
                                                </div>--%>

                                                <div class="form-group">
                                                    <label for="language" class="col-sm-4 control-label"><spring:message
                                                            code="hardware.add.device.language"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <select id="language" name="language"
                                                                class="form-control"
                                                                title="<spring:message code='hardware.add.device.languageInfo'/>">
                                                            <option value="中文"><spring:message
                                                                    code="hardware.add.device.Chinese"/></option>
                                                            <option value="英文"><spring:message
                                                                    code="hardware.add.device.English"/></option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label for="fileInput"
                                                           class="col-sm-4 control-label"><spring:message
                                                            code="hardware.add.device.uploadFile"/><span
                                                            class="text-danger">*</span>:</label>
                                                    <div class="col-sm-6">
                                                        <input id="fileInput" multiple="multiple" name="fileInput"
                                                               type="file" class="file" data-show-preview="false">
                                                        <input id="filePath" name="filePath" type="hidden"/>
                                                    </div>
                                                </div>

                                                <%--&lt;%&ndash;summernote提交表单用&ndash;%&gt;--%>
                                                <%--<input id="contentDesc" name="contentDesc" type="hidden">--%>

                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-4">
                                                        <p class="help-block"><span class="text-danger">*</span>
                                                            <spring:message code="hardware.add.device.needed"/></p>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                                <spring:message code="hardware.add.device.cancel"/>
                                            </button>
                                            <button type="button" id="contentSaveConfirm" class="btn btn-primary">
                                                <spring:message code="hardware.add.device.save"/>
                                            </button>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->

                            <%--点击提交后的弹出框--%>
                            <div class="modal fade" id="modal-upload">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                    aria-hidden="true">&times;
                                            </button>
                                            <h4 class="modal-title">操作</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="container-fluid text-center modal-delete">
                                                <div class="col-sm-12">
                                                    <h5>文件上传中，请稍候...</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- /.modal -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<%@include file="common/footer.jsp" %>
<script type="text/javascript" src="/resources/js/basicJs/jstree.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/select2.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/select2-zh-CN.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/bootstrap-table-zh-CN2.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/jquery.form.min.js"></script>


<%--自定义的JS--%>
<script type="text/javascript" src="/resources/js/hardware.js"></script>
<script type="text/javascript" src="/resources/js/select2.js"></script>
<script type="text/javascript" src="/resources/js/hardwareTable.js"></script>
<script type="text/javascript" src="/resources/js/paramFormValidate.js"></script>


<script type="text/javascript">
    //初始化左侧菜单
    $("#menu").metisMenu({
//        toggle: false
    });
    hardware.initTree();
    select2.init();
    hardwareTable.showTabale();

</script>
</body>
</html>
