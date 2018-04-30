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

    <%--bootstrapValidator.css--%>
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrapValidator.min.css">

    <%--bootstrap-select2--%>
    <link rel="stylesheet" href="/resources/css/basicCss/bootstrap-select.min.css">
    <link rel="stylesheet" href="/resources/css/basicCss/colorbox.css">
    <script type="text/javascript">
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
                    <span class="iconfont icon-fw icon-msnui-sys-set" style="font-size: 18px!important;"></span><spring:message code="common.navbar.brand"/>
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
                        <li><a href="#"><span class="iconfont icon-shezhi icon-fw"></span> <spring:message code="common.user.setting"/></a></li>
                        <li><a href="#"><span class="iconfont icon-gerenzhongxin icon-fw"></span> <spring:message code="common.user.info"/></a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="iconfont icon-tuichu icon-fw"></span> <spring:message code="common.user.logout"/></a></li>
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
                    <li class="active">
                        <a href="#" aria-expanded="true">
                            <%--<span class="fa fa-folder fa-fw"></span>配置管理
                            <span class="fa arrow"></span></a>--%>
                            <span class="folder"></span> <spring:message code="common.page.config.manage"/>
                            <span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/addConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-jia"></span> <spring:message code="common.page.config.add"/></a></li>
                            <li><a href="/config/listConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-fw icon-chaxun"></span> <spring:message code="common.page.config.list"/></a></li>

                        </ul>
                    </li>
                    <li>
                        <a href="#" aria-expanded="false">
                            <span class="folder"></span> <spring:message code="common.page.data.manage"/><span class="arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/hardware">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="iconfont icon-guanli icon-fw"></span></span> <spring:message code="common.page.data.datasheet"/></a></li>
                            <li><a href="/config/download">&nbsp;&nbsp;&nbsp;&nbsp;<span class="iconfont icon-msnui-download icon-fw"></span>
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
            <li><a href="#"><spring:message code="common.page.config.manage"/></a></li>
            <li class="active"><spring:message code="common.page.config.add"/></li>
        </ol>
        <div class="wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <%--主体panel--%>
                    <div class="panel panel-default">
                        <%--panel头部--%>
                        <div class="panel-heading">
                            <h3 class="panel-title"><spring:message code="common.page.config.add"/></h3>
                        </div>
                        <%--panel的主体    --%>
                        <div class="panel-body container-fluid">
                            <div id="wizard">
                                <h3><spring:message code="addConfig.application"/></h3>
                                <section id="section1">
                                    <form class="form-horizontal" id="applicationForm" role="form">
                                        <%--项目标题--%>
                                        <div class="form-group">
                                            <label for="projectTitle" class="col-sm-2 control-label"><spring:message code="addConfig.application.projectTitle"/><span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <input name="projectTitle" class="form-control" type="text"
                                                       id="projectTitle"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="application" class="col-sm-2 control-label"><spring:message code="addConfig.application"/><span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="application" name="application"
                                                        class="selectpicker form-control"
                                                        title="<spring:message code='addConfig.application.select'/>">
                                                    <option data-icon="iconfont icon-yidongduanicon- icon-fw" value="1"><spring:message code="addConfig.application.datacenter"/></option>
                                                    <option data-icon="iconfont icon-tongxin icon-fw"
                                                            value="2"><spring:message code="addConfig.application.telecom"/></option>
                                                    <option data-icon="iconfont icon-dianlixingye icon-fw"
                                                            value="3"><spring:message code="addConfig.application.powerutility"/></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="managementFunction" class="col-sm-2 control-label"><spring:message code="addConfig.application.management"/><span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="managementFunction" name="managementFunction"
                                                        class="selectpicker form-control"
                                                        title="<spring:message code='addConfig.application.management.info'/>">
                                                    <option data-icon="iconfont icon-yes icon-fw"
                                                            value="true"><spring:message code="addConfig.application.management.yes"/></option>
                                                    <option data-icon="iconfont icon-no icon-fw"
                                                            value="false"><spring:message code="addConfig.application.management.no"/></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="language" class="col-sm-2 control-label"><spring:message code="addConfig.application.language"/><span
                                                    class="text-danger">*</span>:</label>
                                            <div class="col-sm-6">
                                                <select id="language" name="language"
                                                        class="selectpicker form-control"
                                                        title="<spring:message code='addConfig.application.language.select'/>">
                                                    <option data-icon="iconfont icon-zhongwenyuyan icon-fw" value="中文"><spring:message code="addConfig.application.language.Chinese"/></option>
                                                    <option data-icon="iconfont icon-yingwenyuyan icon-fw"
                                                            value="英文"><spring:message code="addConfig.application.language.English"/></option>
                                                </select>
                                            </div>
                                        </div>
                                    </form>
                                </section>
                                <h3><spring:message code="addConfig.power"/></h3>
                                <section id="section2">
                                    <input type="hidden" value="0" id="powerInfo">
                                    <div id="powerTitle" class="powerTitle"></div>
                                    <div id="powerParam" class="powerParam"></div>
                                </section>
                                <h3><spring:message code="addConfig.battery"/></h3>
                                <section id="section3">
                                    <input type="hidden" value="0" id="battInfo">
                                    <div id="batteryTitle" class="batteryTitle"></div>
                                    <div id="batteryParam" class="batteryParam"></div>
                                </section>
                                <h3><spring:message code="addConfig.environment"/></h3>
                                <section id="section4">
                                    <input type="hidden" value="0" id="environInfo">
                                    <div id="environmentTitle" class="environmentTitle"></div>
                                    <div id="environmentParam" class="environmentParam"></div>
                                </section>
                            </div>
                            <div class="form-group" style="margin-top: -40px">
                                <div class="col-sm-6 col-sm-offset-2">
                                    <p class="help-block"><span class="text-danger">*</span><spring:message code="addConfig.needed"/></p>
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
                                            <h4 class="modal-title"><spring:message code="addConfig.operation"/></h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="container-fluid text-center modal-delete">
                                                <div class="col-sm-12">
                                                    <h5><spring:message code="addConfig.operation.info"/></h5>
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
        $('select#application').change(function () {
            $("#powerInfo").val(0);
            $("#battInfo").val(0);
            $("#environInfo").val(0);
        })
    });
    Steps.init();

</script>
</body>
</html>
