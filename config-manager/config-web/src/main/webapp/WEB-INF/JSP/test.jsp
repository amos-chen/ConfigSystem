<%--
  Created by IntelliJ IDEA.
  User: Amos
  Date: 2017/5/3
  Time: 10:10
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
    <title>配置管理管理系统</title>
    <%@include file="common/header.jsp" %>

    <script>
        FontAwesomeConfig = {searchPseudoElements: true};
    </script>

    <style>
        /*nav {
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            justify-content: space-between;
            align-items: center;
        }

        nav a {
            width: 30%;
            width: 15em;
            padding: 1em;
            color: rgba(255,255,255, 0.75);
            background-color: tomato;
            border-radius: 0.25em;
            text-decoration: none;
            text-align: center;
        }

        nav a:hover, nav a:focus {
            color: rgba(255,255,255, 1.0);
            text-decoration: none;
        }*/

        /* nav a::before {
             display: none;
         }*/

        /*nav .svg-inline--fa {
            margin-right: 0.5em;
        }*/

        .login::before {
            display: none;
            font-family: "Font Awesome 5 Solid";
            content: "\f07b";
        }

        .tps::before {
            display: none;
            font-family: "Font Awesome 5 Regular";
            content: "\f07b";
        }

        .twitter::before {
            display: none;
            font-family: "Font Awesome 5 Brands";
            content: "\f07b";
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
                            <span class="fa fa-folder fa-fw"></span>配置管理
                            <span class="fa arrow"></span></a>
                        <ul class="nav">
                            <li><a href="/config/addConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="fa fa-plus fa-fw"></span>添加配置</a></li>
                            <li><a href="/config/listConfig">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="fa fa-search fa-fw"></span>查询配置</a></li>
                            <li><a href="/config/hardware">&nbsp;&nbsp;&nbsp;&nbsp;<span
                                    class="fa fa-align-left fa-fw"></span>硬件管理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" aria-expanded="false">
                            <span class="fa fa-folder fa-fw"></span>资料管理<span class="fa arrow"></span></a>
                        <ul class="nav">
                            <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;<span class="fa fa-download fa-fw"></span>规格书下载</a>
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
            <div class="modal fade" id="modal-download">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;
                            </button>
                            <h5 class="modal-title">操作提示</h5>
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
            <button class="btn btn-info" id="test">测试</button>

            <div class="col-sm-6">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th colspan="5" style="text-align: center"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div>
                <h4>测试1</h4>
                <table class="table">
                    <tr>
                        <td>1</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                    </tr>
                </table>
                <h4>测试2</h4>
                <table class="table">
                    <tr>
                        <td rowspan="5">1</td>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                    <tr>
                        <td rowspan="5">1</td>
                        <td>2</td>
                        <td>2</td>
                    </tr>
                </table>




            </div>
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
