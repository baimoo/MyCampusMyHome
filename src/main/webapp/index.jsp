<%--
  Created by IntelliJ IDEA.
  User: BaiMo
  Date: 2020/4/7 0007
  Time: 10:44:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>我的校园我的家-首页</title>
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
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    <link rel="stylesheet" href="css/a_index.css">
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
                                        <li><a href="index.jsp">首页</a>
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
    <!--信息主体-->
    <div class="single-pro-review-area mt-t-30 mg-b-15">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st">
                        <div class="row">
                            <div class="col-lg-5 col-md-6 col-sm-6 col-xs-12">
                            </div>
                            <div class="col-lg-7 col-md-6 col-sm-6 col-xs-12"><span id="hy">欢迎登录:<span
                                    id="hy2">${login.name}</span></span>
                            </div>
                        </div>
                    </div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                    <div class="product-payment-inner-st"></div>
                </div>
            </div>
        </div>
    </div>
    <!--底部版权-->
    <div class="footer-copyright-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
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
<!-- counterup JS
    ============================================ -->
<script src="js/counterup/jquery.counterup.min.js"></script>
<script src="js/counterup/waypoints.min.js"></script>
<script src="js/counterup/counterup-active.js"></script>
<!-- mCustomScrollbar JS
    ============================================ -->
<script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/scrollbar/mCustomScrollbar-active.js"></script>
<!-- metisMenu JS
    ============================================ -->
<script src="js/metisMenu/metisMenu.min.js"></script>
<script src="js/metisMenu/metisMenu-active.js"></script>
<!-- morrisjs JS
    ============================================ -->
<script src="js/morrisjs/raphael-min.js"></script>
<script src="js/morrisjs/morris.js"></script>
<script src="js/morrisjs/morris-active.js"></script>
<!-- morrisjs JS
    ============================================ -->
<script src="js/sparkline/jquery.sparkline.min.js"></script>
<script src="js/sparkline/jquery.charts-sparkline.js"></script>
<script src="js/sparkline/sparkline-active.js"></script>
<!-- calendar JS
    ============================================ -->
<script src="js/calendar/moment.min.js"></script>
<script src="js/calendar/fullcalendar.min.js"></script>
<script src="js/calendar/fullcalendar-active.js"></script>
<!-- plugins JS
    ============================================ -->
<script src="js/plugins.js"></script>
<!-- main JS
    ============================================ -->
<script src="js/main.js"></script>
</body>

<script>
    $(function () {
        //提示信息
        <c:if test="${not empty errorMsg}">
        alert("${errorMsg}");
        </c:if>
    });
</script>
</html>
