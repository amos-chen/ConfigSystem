<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenlunwei
  Date: 2017/5/6
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Page Description">
    <meta name="author" content="Amos">
    <title>ECO Plus配置管理系统</title>
    <%@include file="common/header.jsp" %>

    <%--bootstrapValidator.css--%>
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrapValidator.min.css">

    <%--jquery.steps.css--%>
    <link rel="stylesheet" href="/resources/css/jquery.steps.css">
    <%--bootstrap-select2--%>
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrap-select.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/colorbox.css">
    <script>
        FontAwesomeConfig = { searchPseudoElements: true };
    </script>
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
                    <span class="fa fa-leaf fa-fw"></span>配置管理管理系统
                </a>
            </div>

            <ul class="nav taotao-top-nav navbar-right">
                <li class="dropdown taotao-task">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="fa fa-tasks"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown taotao-alarm">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="fa fa-bell"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-caret" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="dropdown taotao-message">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="fa fa-comments"></span>
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
                        <li><a href="#"><span class="fa fa-cog fa-fw"></span>设置</a></li>
                        <li><a href="#"><span class="fa fa-user fa-fw"></span>个人中心</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="fa fa-sign-out fa-fw"></span>注销</a></li>
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
                                <span class="fa fa-search"></span>
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
                                    class="fa fa-plus fa-fw"></span>添加配置</a></li>
                            <li><a href="/config/listConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="fa fa-search fa-fw"></span>查询配置</a></li>

                        </ul>
                    </li>
                    <li>
                        <a href="#" aria-expanded="false">
                            <span class="folder"></span> 资料管理<span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/hardware">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="fa fa-align-left fa-fw"></span>硬件管理</a></li>
                            <li><a href="/config/download">&nbsp;&nbsp;&nbsp;&nbsp;<span class="fa fa-download fa-fw"></span>规格书下载</a>
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
                <a href="/config/index"><span class="fa fa-home fa-lg fa-fw"></span>首页</a>
            </li>
            <li><a href="#">配置管理</a></li>
            <li class="active">添加配置</li>
        </ol>
        <div class="wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <%--主体panel--%>
                    <div class="panel panel-default">
                        <%--panel头部--%>
                        <div class="panel-heading">
                            <h3 class="panel-title">添加配置</h3>
                        </div>
                        <%--panel的主体    --%>
                        <div class="panel-body container-fluid">
                            <div id="wizard">
                                <h3>应用场景</h3>
                                <section id="section1">
                                    <form class="form-horizontal" id="applicationForm" role="form">
                                        <%--项目标题--%>
                                        <div class="form-group">
                                            <label for="projectTitle" class="col-sm-2 control-label">项目标题<span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <input name="projectTitle" class="form-control" type="text"
                                                       id="projectTitle"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="application" class="col-sm-2 control-label">应用场景<span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="application" name="application"
                                                        class="selectpicker form-control"
                                                        title="请选择应用场景">
                                                    <option data-icon="fa fa-building fa-fw" value="1">数据中心</option>
                                                    <option data-icon="fa fa-signal fa-fw" value="2">电信</option>
                                                    <option data-icon="fa fa-bolt fa-fw" value="3">电力</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="managementFunction" class="col-sm-2 control-label">管理功能<span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="managementFunction" name="managementFunction"
                                                        class="selectpicker form-control"
                                                        title="是否需要管理功能">
                                                    <option data-icon="fa fa-check-circle fa-fw" value="true">是</option>
                                                    <option data-icon="fa fa-times-circle fa-fw" value="false">否</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="language" class="col-sm-2 control-label">语言<span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="language" name="language"
                                                        class="selectpicker form-control"
                                                        title="请选择语言">
                                                    <option data-icon="fa fa-language fa-fw" value="中文">中文</option>
                                                    <option data-icon="fa fa-language fa-fw" value="英文">英文</option>
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                </section>
                                <h3>电源信息</h3>
                                <section id="section2">
                                    <input type="hidden" value="0" id="powerInfo">
                                    <div id="powerTitle" class="powerTitle"></div>
                                    <div id="powerParam" class="powerParam"></div>
                                </section>
                                <h3>电池信息</h3>
                                <section id="section3">
                                    <input type="hidden" value="0" id="battInfo">
                                    <div id="batteryTitle" class="batteryTitle"></div>
                                    <div id="batteryParam" class="batteryParam"></div>
                                </section>
                                <h3>环境信息</h3>
                                <section id="section4">
                                    <input type="hidden" value="0" id="environInfo">
                                    <div id="environmentTitle" class="environmentTitle"></div>
                                    <div id="environmentParam" class="environmentParam"></div>
                                </section>
                            </div>
                            <div class="form-group" style="margin-top: -40px">
                                <div class="col-sm-6 col-sm-offset-2">
                                    <p class="help-block"><span class="text-danger">*</span>为必填项</p>
                                </div>
                            </div>

                            <%--点击提交后的弹出框--%>
                            <div class="modal fade" id="modal-download">
                                <div class="modal-dialog modal-sm">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                    aria-hidden="true">&times;
                                            </button>
                                            <h4 class="modal-title">操作提示</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="container-fluid text-center modal-delete">
                                                <div class="col-sm-12">
                                                    <h5>正在生成配置文件，请稍候...</h5>
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

<%--jquery.steps.js--%>
<script type="text/javascript" src="/resources/js/basicJs/jquery.steps.min.js"></script>
<!--bootstrapValidator.js-->
<script type="text/javascript" src="/resources/js/basicJs/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="/resources/js/basicJs/zh_CN.min.js"></script>
<%--bootstrap-select2.js--%>
<script type="text/javascript" src="/resources/js/basicJs/bootstrap-select.min.js"></script>
<%--jquery.colorbox--%>
<script type="text/javascript" src="/resources/js/basicJs/jquery.colorbox-min.js"></script>



<!-- 自定义js文件 -->
<script type="text/javascript" src="/resources/js/steps.js"></script>
<script type="text/javascript" src="/resources/js/applicationFormValidate.js"></script>
<script type="text/javascript" src="/resources/js/add_power_info.js"></script>
<script type="text/javascript" src="/resources/js/add_batt_info.js"></script>
<script type="text/javascript" src="/resources/js/add_environment_info.js"></script>
<script type="text/javascript" src="/resources/js/powerFormValidate.js"></script>
<script type="text/javascript" src="/resources/js/battFormValidate.js"></script>
<script type="text/javascript" src="/resources/js/environmentFormValidate.js"></script>

<script type="text/javascript">
    //初始化左侧菜单
    $("#menu").metisMenu({
//        toggle: false
    });

    //当页面加载完成后，初始化应用场景表单验证
    $(document).ready(function () {
        //加载所有JS文件
        applicationFormValidate.initValidator();
        powerFormValidate.initValidator();
        battFormValidate.initValidator();
        environmentFormValidate.initValidator();
        //当应用场景发生改变时，重置电源，电池和环境信息
        $('select#application').change(function() {
            $("#powerInfo").val(0);
            $("#battInfo").val(0);
            $("#environInfo").val(0);
        })
    });

    Steps.init();

</script>
</body>
</html>
