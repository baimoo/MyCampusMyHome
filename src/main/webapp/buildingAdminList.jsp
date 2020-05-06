<%--
  Created by IntelliJ IDEA.
  User: BaiMo
  Date: 2020/5/3 0003
  Time: 15:38:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zh-cmn-Hans">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>楼宇管理员管理 | 我的校园我的家</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
    <!-- x-editor CSS
		============================================ -->
    <link rel="stylesheet" href="css/editor/select2.css">
    <link rel="stylesheet" href="css/editor/datetimepicker.css">
    <link rel="stylesheet" href="css/editor/bootstrap-editable.css">
    <link rel="stylesheet" href="css/editor/x-editor-style.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="css/data-table/bootstrap-editable.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    <link rel="stylesheet" href="css/newCss.css">
</head>

<body>
<!--[if lt IE 8]>
<p class="browserupgrade">你正在使用<strong>旧</strong> 浏览器。请 <a href="https://www.google.cn/chrome/">更新你的浏览器</a>改善体验。</p>
<![endif]-->
<!-- 左侧菜单区域 -->
<div class="left-sidebar-pro">
    <nav id="sidebar" class="">
        <div class="sidebar-header">
            <a href="index.jsp"><img class="main-logo" src="img/logo/logo.png" alt="首页"/></a>
            <strong><a href="index.jsp"><img src="img/logo/logosn.png" alt="首页"/></a></strong>
        </div>
        <div class="left-custom-menu-adp-wrap comment-scrollbar">
            <nav class="sidebar-nav left-sidebar-menu-pro">
                <ul class="metismenu" id="menu1">
                    <li>
                        <a title="首页" href="index.jsp">
                            <span class="educate-icon educate-home icon-wrap"></span>
                            <span class="mini-click-non">首页</span>
                        </a>
                    </li>
                    <c:if test="${level eq 0}">
                        <li>
                            <a title="楼宇管理员管理" href="ba?method=selectBuildingAdmins"><span
                                    class="educate-icon educate-professor icon-wrap"></span><span
                                    class="mini-click-non">楼宇管理员管理</span></a>
                        </li>
                        <li>
                            <a title="学生管理" href="student?method=selectStudents"><span
                                    class="educate-icon educate-student icon-wrap"></span><span
                                    class="mini-click-non">&nbsp;学生管理</span></a>
                        </li>
                        <li>

                            <a title="楼宇管理" href="bd?method=selectBuildings"><span
                                    class="educate-icon educate-course icon-wrap"></span> <span
                                    class="mini-click-non">楼宇管理</span></a>
                        </li>
                        <li>
                            <a title="宿舍管理" href="room?method=selectRooms"><span
                                    class="educate-icon educate-event icon-wrap sub-icon-mg"></span><span
                                    class="mini-click-non">宿舍管理</span></a>
                        </li>
                    </c:if>
                    <c:if test="${level eq 1}">
                        <li>
                            <a title="学生管理" href="student?method=selectStudents"><span
                                    class="educate-icon educate-student icon-wrap"></span><span
                                    class="mini-click-non">&nbsp;学生管理</span></a>
                        </li>
                        <li>
                            <a title="学生寝室调换" href="rc?method=selectRoomChanges"><span
                                    class="educate-icon educate-department icon-wrap"></span> <span
                                    class="mini-click-non">学生寝室调换</span></a>

                        </li>

                        <li>
                            <a title="学生迁出管理" href="quit?method=selectQuits"><span
                                    class="educate-icon educate-interface icon-wrap"></span> <span
                                    class="mini-click-non">学生迁出管理</span></a>
                        </li>

                        <li>
                            <a title="学生缺寝记录" href="late?method=selectLates"><span
                                    class="educate-icon educate-data-table icon-wrap"></span> <span
                                    class="mini-click-non">学生缺寝记录</span></a>
                        </li>
                    </c:if>
                    <c:if test="${level eq 2}">
                        <li>
                            <a title="我的缺寝记录" href="late?method=selectLates"><span
                                    class="educate-icon educate-data-table icon-wrap"></span> <span
                                    class="mini-click-non">我的缺寝记录</span></a>
                        </li>
                    </c:if>
                    <li id="removable">
                        <a title="退出系统" href="javascript:void(0)" data-target="#exit"
                           data-toggle="modal"><span
                                class="educate-icon educate-pages icon-wrap"></span> <span
                                class="mini-click-non">退出系统</span></a>
                    </li>
                </ul>
            </nav>
        </div>
    </nav>
</div>
<!-- 开始主页面 -->
<div class="all-content-wrapper">
    <!--缩小窗口后的顶部logo-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="logo-pro">
                    <a href="/index.jsp"><img class="main-logo" src="img/logo/logo.png" alt="主页"/></a>
                </div>
            </div>
        </div>
    </div>
    <!--总头部：登录信息、菜单栏、导航栏、搜索栏-->
    <div class="header-advance-area">
        <!--顶部登录信息：头像、信息-->
        <div class="header-top-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="header-top-wraper">
                            <div class="row">
                                <!--全屏时缩小-展开左侧菜单-->
                                <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                    <div class="menu-switcher-pro">
                                        <button type="button" id="sidebarCollapse"
                                                class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
                                            <i class="educate-icon educate-nav"></i>
                                        </button>
                                    </div>
                                </div>
                                <!--全屏时左上侧菜单-->
                                <div class="col-lg-6 col-md-7 col-sm-6 col-xs-12">
                                    <div class="header-top-menu tabl-d-n">
                                        <ul class="nav navbar-nav mai-top-nav">
                                            <li class="nav-item"><a href="index.jsp" class="nav-link">主页</a>
                                            </li>
                                            <li class="nav-item"><a href="#" class="nav-link">关于我们</a>
                                            </li>
                                            <li class="nav-item"><a href="#" class="nav-link">服务</a>
                                            </li>
                                            <li class="nav-item"><a href="#" class="nav-link">支持</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <!--头像等个人信息-->
                                <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                    <div class="header-right-info">
                                        <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                            <li class="nav-item">
                                                <a href="#" data-toggle="dropdown" role="button" aria-expanded="false"
                                                   class="nav-link dropdown-toggle">
                                                    <!--头像、姓名-->
                                                    <img src="img/product/pro4.jpg" alt=""/>
                                                    <span class="admin-name">${login.name}</span>
                                                    <i class="fa fa-angle-down edu-icon edu-down-arrow"></i>
                                                </a>
                                                <!--用户名下功能菜单-->
                                                <ul role="menu"
                                                    class="dropdown-header-top author-log dropdown-menu animated zoomIn">
                                                    <li><a href="javascript:void(0)" data-target="#modinfo"
                                                           data-toggle="modal"><span
                                                            class="edu-icon edu-home-admin author-log-ic"></span>修改信息</a>
                                                    </li>
                                                    <li><a href="javascript:void(0)" data-target="#modpwd"
                                                           data-toggle="modal"><span
                                                            class="edu-icon edu-user-rounded author-log-ic"></span>重置密码</a>
                                                    </li>
                                                    <li><a title="退出系统" href="javascript:void(0)" data-target="#exit"
                                                           data-toggle="modal"><span
                                                            class="edu-icon edu-locked author-log-ic"></span>退出登录</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 修改信息模态框（Modal） -->
        <div class="modal fade" id="modinfo" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h4 class="modal-title">修改信息</h4>
                    </div>
                    <form method="post" action="system">
                        <input type="hidden" name="method" value="modify">
                        <div class="container-fluid">
                            <c:if test="${level eq 0}">
                                <input type="hidden" name="said" value="${login.said}">
                                <div class="form-group-inner">
                                    <label>帐号</label>
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="sid" value="${login.uid}">
                                </div>
                                <div class="form-group-inner">
                                    <label>姓名</label>
                                    <input type="text" class="form-control"
                                           placeholder="10字以内中文字符" name="name" value="${login.name}">
                                </div>
                                <div class="form-group-inner">
                                    <label>性别</label>
                                    <select class="form-control custom-select-value" name="sex">
                                        <option value="1" <c:if test="${login.sex eq 1}">selected="selected"</c:if>>男
                                        </option>
                                        <option value="0" <c:if test="${login.sex eq 0}">selected="selected"</c:if>>女
                                        </option>
                                    </select>
                                </div>
                            </c:if>
                            <c:if test="${level eq 1}">
                                <input type="hidden" name="baid" value="${login.baid}">
                                <div class="form-group-inner">
                                    <label>帐号</label>
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="sid" value="${login.uid}">
                                </div>
                                <div class="form-group-inner">
                                    <label>姓名</label>
                                    <input type="text" class="form-control"
                                           placeholder="10字以内中文字符" name="name" value="${login.name}">
                                </div>
                                <div class="form-group-inner">
                                    <label>性别</label>
                                    <select class="form-control custom-select-value" name="sex">
                                        <option value="1" <c:if test="${login.sex eq 1}">selected="selected"</c:if>>男
                                        </option>
                                        <option value="0" <c:if test="${login.sex eq 0}">selected="selected"</c:if>>女
                                        </option>
                                    </select>
                                </div>
                                <div class="form-group-inner">
                                    <label>手机号</label>
                                    <input type="text" class="form-control"
                                           placeholder="11位手机号" name="phone" value="${login.phone}">
                                </div>
                            </c:if>
                            <c:if test="${level eq 2}">
                                <input type="hidden" name="state" value="${login.state}">
                                <div class="form-group-inner">
                                    <label>学号</label>
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="sid" value="${login.sid}">
                                </div>
                                <div class="form-group-inner">
                                    <label>姓名</label>
                                    <input type="text" class="form-control"
                                           placeholder="10字以内中文字符" name="name" value="${login.name}">
                                </div>
                                <div class="form-group-inner">
                                    <label>性别</label>
                                    <select class="form-control custom-select-value" name="sex">
                                        <option value="1" <c:if test="${login.sex eq 1}">selected="selected"</c:if>>男
                                        </option>
                                        <option value="0" <c:if test="${login.sex eq 0}">selected="selected"</c:if>>女
                                        </option>
                                    </select>
                                </div>
                                <div class="form-group-inner">
                                    <label>班级</label>
                                    <input type="text" class="form-control"
                                           placeholder="20位以内字符" name="cName" value="${login.cName}">
                                </div>
                            </c:if>
                        </div>
                        <br/>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 修改密码模态框（Modal） -->
        <div class="modal fade" id="modpwd" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h4 class="modal-title">修改密码</h4>
                    </div>
                    <form method="post" action="system">
                        <input type="hidden" name="method" value="modifyPwd">
                        <div class="container-fluid">
                            <div class="form-group-inner">
                                <c:if test="${level eq 0 or level eq 1}">
                                    <label>帐号</label>
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="sid" value="${login.uid}"></c:if>
                                <c:if test="${level eq 2}">
                                    <label>学号</label>
                                    <input type="text" class="form-control" readonly="readonly"
                                           name="sid" value="${login.sid}"></c:if>
                            </div>
                            <div class="form-group-inner">
                                <label>旧密码</label>
                                <input type="password" class="form-control"
                                       placeholder="请输入旧密码" name="pwd">
                            </div>
                            <div class="form-group-inner">
                                <label>新密码</label>
                                <input type="password" class="form-control"
                                       placeholder="20位以内字符" name="pwd2">
                            </div>
                            <div class="form-group-inner">
                                <label>确认密码</label>
                                <input type="password" class="form-control"
                                       placeholder="20位以内字符">
                            </div>
                        </div>
                        <br/>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default"
                                    data-dismiss="modal">关闭
                            </button>
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- 退出登录模态框（Modal） -->
        <div class="modal fade" id="exit" tabindex="-1"
             role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-hidden="true">×
                        </button>
                        <h4 class="modal-title">友情提示</h4>
                    </div>
                    <br/>
                    <div class="container-fluid">
                        <h4>您确定要退出登录吗？
                        </h4>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <a href="system?method=exit"
                           class="btn btn-danger"
                           style="color: white">要你管！</a>
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">算了吧..
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 手机版菜单 -->
        <div class="mobile-menu-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="mobile-menu">
                            <nav id="dropdown">
                                <ul class="mobile-menu-nav">
                                    <!--li标签与pc端一样-->
                                    <li>
                                        <a title="首页" href="index.jsp">
                                            <span class="educate-icon educate-home icon-wrap"></span>
                                            <span class="mini-click-non">首页</span>
                                        </a>
                                    </li>
                                    <c:if test="${level eq 0}">
                                        <li>
                                            <a title="楼宇管理员管理" href="/ba?method=selectBuildingAdmins"><span
                                                    class="educate-icon educate-professor icon-wrap"></span><span
                                                    class="mini-click-non">楼宇管理员管理</span></a>
                                        </li>
                                        <li>
                                            <a title="学生管理" href="/student?method=selectStudents"><span
                                                    class="educate-icon educate-student icon-wrap"></span><span
                                                    class="mini-click-non">&nbsp;学生管理</span></a>
                                        </li>
                                        <li>

                                            <a title="楼宇管理" href="/bd?method=selectBuildings"><span
                                                    class="educate-icon educate-course icon-wrap"></span> <span
                                                    class="mini-click-non">楼宇管理</span></a>
                                        </li>
                                        <li>
                                            <a title="宿舍管理" href="/room?method=selectRooms"><span
                                                    class="educate-icon educate-event icon-wrap sub-icon-mg"></span><span
                                                    class="mini-click-non">宿舍管理</span></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${level eq 1}">
                                        <li>
                                            <a title="学生管理" href="student?method=selectStudents"><span
                                                    class="educate-icon educate-student icon-wrap"></span><span
                                                    class="mini-click-non">&nbsp;学生管理</span></a>
                                        </li>
                                        <li>
                                            <a title="学生寝室调换" href="rc?method=selectRoomChanges"><span
                                                    class="educate-icon educate-department icon-wrap"></span> <span
                                                    class="mini-click-non">学生寝室调换</span></a>

                                        </li>

                                        <li>
                                            <a title="学生迁出管理" href="quit?method=selectQuits"><span
                                                    class="educate-icon educate-interface icon-wrap"></span> <span
                                                    class="mini-click-non">学生迁出管理</span></a>
                                        </li>

                                        <li>
                                            <a title="学生缺寝记录" href="late?method=selectLates"><span
                                                    class="educate-icon educate-data-table icon-wrap"></span> <span
                                                    class="mini-click-non">学生缺寝记录</span></a>
                                        </li>
                                    </c:if>
                                    <c:if test="${level eq 2}">
                                        <li>
                                            <a title="我的缺寝记录" href="late?method=selectLates"><span
                                                    class="educate-icon educate-data-table icon-wrap"></span> <span
                                                    class="mini-click-non">我的缺寝记录</span></a>
                                        </li>
                                    </c:if>
                                    <li id="removable">
                                        <a title="退出系统" href="javascript:void(0)" data-target="#exit"
                                           data-toggle="modal"><span
                                                class="educate-icon educate-pages icon-wrap"></span> <span
                                                class="mini-click-non">退出系统</span></a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 搜索框与面包屑导航 -->
        <div class="breadcome-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="breadcome-list">
                            <div class="row">
                                <!--搜索框-->
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <div class="breadcome-heading">
                                        <form role="search" class="sr-input-func">
                                            <input type="text" placeholder="搜索..." class="search-int form-control">
                                            <a href="#"><i class="fa fa-search"></i></a>
                                        </form>
                                    </div>
                                </div>
                                <!--面包屑导航-->
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <ul class="breadcome-menu">
                                        <li><a href="index.jsp">首页</a> <span class="bread-slash">/</span>
                                        </li>
                                        <li><span class="bread-blod">楼宇管理员管理</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 信息主体-->
    <div class="data-table-area mg-b-15">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="sparkline13-list">
                        <div class="sparkline13-hd">
                            <div class="main-sparkline13-hd">
                                <h1>楼宇管理员</h1>
                            </div>
                        </div>
                        <div class="sparkline13-graph">
                            <div class="datatable-dashv1-list custom-datatable-overright">
                                <!--左侧工具栏-->
                                <div id="toolbar">
                                    <select class="form-control dt-tb" style="display: inline;width: auto">
                                        <option value="">导出本页</option>
                                        <option value="all">导出所有</option>
                                        <option value="selected">导出已选择</option>
                                    </select>
                                    <button id="btn_add" type="button" class="btn btn-default" data-target="#addba"
                                            data-toggle="modal">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                                    </button>
                                    <!-- 新增模态框（Modal） -->
                                    <div class="modal fade" id="addba" tabindex="-1" role="dialog"
                                         aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-hidden="true">×
                                                    </button>
                                                    <h4 class="modal-title">新增</h4>
                                                </div>
                                                <form method="post" action="/ba?method=insertBuildingAdmin">
                                                    <div class="container-fluid">
                                                        <div class="form-group-inner">
                                                            <label>姓名</label>
                                                            <input type="text" class="form-control"
                                                                   placeholder="10字以内中文字符" name="name">
                                                        </div>
                                                        <div class="form-group-inner">
                                                            <label>性别</label>
                                                            <select class="form-control custom-select-value" name="sex">
                                                                <option value="1">男</option>
                                                                <option value="0">女</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group-inner">
                                                            <label>电话</label>
                                                            <input type="text" class="form-control"
                                                                   placeholder="11位电话号码" name="phone">
                                                        </div>
                                                        <div class="form-group-inner">
                                                            <label>用户名</label>
                                                            <input type="text" class="form-control"
                                                                   placeholder="20位以内字符" name="uid">
                                                        </div>
                                                        <label>密码</label>
                                                        <input type="password" class="form-control"
                                                               placeholder="20位以内字符" name="pwd">
                                                    </div>
                                                    <br/>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default"
                                                                data-dismiss="modal">关闭
                                                        </button>
                                                        <button type="submit" class="btn btn-primary">提交更改</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <table id="table" data-toggle="table" data-pagination="true" data-search-time-out="1000"
                                       data-search="true"
                                       data-show-columns="true" data-show-pagination-switch="true"
                                       data-show-refresh="true" data-key-events="true" data-show-toggle="true"
                                       data-resizable="true" data-cookie="true"
                                       data-cookie-id-table="saveId" data-show-export="true"
                                       data-toolbar="#toolbar" data-search-on-enter-key="true">
                                    <thead>
                                    <tr>
                                        <th data-checkbox="true"></th>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>电话</th>
                                        <th>用户名</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="td1">
                                    <c:forEach items="${buildingAdmins}" var="buildingAdmin">
                                        <tr>
                                            <td></td>
                                            <td>${buildingAdmin.baid}</td>
                                            <td>${buildingAdmin.name}</td>
                                            <td>
                                                <c:if test="${buildingAdmin.sex eq 0}">女</c:if>
                                                <c:if test="${buildingAdmin.sex eq 1}">男</c:if>
                                            </td>
                                            <td>${buildingAdmin.phone}</td>
                                            <td>${buildingAdmin.uid}</td>
                                            <td class="datatable-ct">
                                                <button id="btn_edit" type="button" class="btn btn-default"
                                                        data-toggle="modal" data-target="#upmodal${buildingAdmin.baid}">
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                                                </button>
                                                <button id="btn_delete" type="button" class="btn btn-default"
                                                        data-toggle="modal"
                                                        data-target="#delmodal${buildingAdmin.baid}">
                                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                                                </button>
                                            </td>
                                            <!-- 修改模态框（Modal） -->
                                            <div class="modal fade" id="upmodal${buildingAdmin.baid}" tabindex="-1"
                                                 role="dialog"
                                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-hidden="true">×
                                                            </button>
                                                            <h4 class="modal-title" id="myModalLabel">修改</h4>
                                                        </div>
                                                        <br/>
                                                        <form method="post" action="/ba?method=updateBuildingAdmin">
                                                            <div class="container-fluid">
                                                                <input type="hidden" value="${buildingAdmin.baid}"
                                                                       name="baid">
                                                                <div class="form-group-inner">
                                                                    <label>姓名</label>
                                                                    <input type="text" class="form-control"
                                                                           placeholder="10字以内中文字符" name="name"
                                                                           value="${buildingAdmin.name}">
                                                                </div>
                                                                <div class="form-group-inner">
                                                                    <label>性别</label>
                                                                    <select class="form-control custom-select-value"
                                                                            name="sex">
                                                                        <option value="0"
                                                                                <c:if test="${buildingAdmin.sex eq 0}">selected="selected"</c:if>>
                                                                            女
                                                                        </option>
                                                                        <option value="1"
                                                                                <c:if test="${buildingAdmin.sex eq 1}">selected="selected"</c:if>>
                                                                            男
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <div class="form-group-inner">
                                                                    <label>电话</label>
                                                                    <input type="text" class="form-control"
                                                                           placeholder="11位电话号码" name="phone"
                                                                           value="${buildingAdmin.phone}">
                                                                </div>
                                                                <div class="form-group-inner">
                                                                    <label>用户名</label>
                                                                    <input type="text" class="form-control"
                                                                           placeholder="20位以内字符" name="uid"
                                                                           value="${buildingAdmin.uid}">
                                                                </div>
                                                                <label>密码</label>
                                                                <input type="password" class="form-control"
                                                                       placeholder="20位以内字符" name="pwd"
                                                                       value="${buildingAdmin.pwd}">
                                                            </div>
                                                            <br/>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-default"
                                                                        data-dismiss="modal">关闭
                                                                </button>
                                                                <button type="submit" class="btn btn-primary">提交更改
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- 删除模态框（Modal） -->
                                            <div class="modal fade" id="delmodal${buildingAdmin.baid}" tabindex="-1"
                                                 role="dialog"
                                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal"
                                                                    aria-hidden="true">×
                                                            </button>
                                                            <h4 class="modal-title">友情提示</h4>
                                                        </div>
                                                        <br/>
                                                        <div class="container-fluid">
                                                            <h4>您确定要删除<span
                                                                    style="color: red">${buildingAdmin.name}</span>吗？删除后无法恢复！
                                                            </h4>
                                                            <br>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <a href="/ba?method=delBuildingAdminByBaid&baid=${buildingAdmin.baid}"
                                                               class="btn btn-danger"
                                                               style="color: white">要你管！</a>
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">算了吧..
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--底部版权-->
    <div class="footer-copyright-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="footer-copy-right">
                        <p>Copyright © 重案组</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jquery
    ============================================ -->
<script src="js/vendor/jquery-1.12.4.min.js"></script>
<!-- bootstrap JS
    ============================================ -->
<script src="js/bootstrap.min.js"></script>
<!-- wow JS
    ============================================ -->
<script src="js/wow.min.js"></script>
<!-- price-slider JS
    ============================================ -->
<script src="js/jquery-price-slider.js"></script>
<!-- meanmenu JS
    ============================================ -->
<script src="js/jquery.meanmenu.js"></script>
<!-- owl.carousel JS
    ============================================ -->
<script src="js/owl.carousel.min.js"></script>
<!-- sticky JS
    ============================================ -->
<script src="js/jquery.sticky.js"></script>
<!-- scrollUp JS
    ============================================ -->
<script src="js/jquery.scrollUp.min.js"></script>
<!-- mCustomScrollbar JS
    ============================================ -->
<script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/scrollbar/mCustomScrollbar-active.js"></script>
<!-- metisMenu JS
    ============================================ -->
<script src="js/metisMenu/metisMenu.min.js"></script>
<script src="js/metisMenu/metisMenu-active.js"></script>
<!-- data table JS
    ============================================ -->
<script src="js/data-table/bootstrap-table.js"></script><!--动态表格-->
<script src="js/data-table/tableExport.js"></script><!--控制导出-->
<script src="js/data-table/data-table-active.js"></script><!---->
<script src="js/data-table/bootstrap-table-editable.js"></script><!--允许编辑表格-->
<script src="js/data-table/bootstrap-editable.js"></script><!---->
<script src="js/data-table/bootstrap-table-resizable.js"></script><!---->
<script src="js/data-table/colResizable-1.5.source.js"></script><!---->
<script src="js/data-table/bootstrap-table-export.js"></script><!---->
<!--  editable JS
    ============================================ -->
<script src="js/editable/jquery.mockjax.js"></script>
<script src="js/editable/mock-active.js"></script>
<script src="js/editable/select2.js"></script>
<script src="js/editable/moment.min.js"></script>
<script src="js/editable/bootstrap-datetimepicker.js"></script>
<script src="js/editable/bootstrap-editable.js"></script>
<script src="js/editable/xediable-active.js"></script>
<!-- Chart JS
    ============================================ -->
<script src="js/chart/jquery.peity.min.js"></script>
<script src="js/peity/peity-active.js"></script>
<!-- tab JS
    ============================================ -->
<script src="js/tab.js"></script>
<!-- plugins JS
    ============================================ -->
<script src="js/plugins.js"></script>
<!-- main JS
    ============================================ -->
<script src="js/main.js"></script>


</body>
<!--错误信息-->
<c:if test="${not empty errorMsg}">
    <script type="text/javascript">
        alert("${errorMsg}")
    </script>
</c:if>
</html>