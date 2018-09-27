<%@ page pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/assets-dash/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/assets-dash/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Hello Docent Management System</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/resources/assets-dash/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${pageContext.request.contextPath}/resources/assets-dash/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${pageContext.request.contextPath}/resources/assets-dash/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.request.contextPath}/resources/assets-dash/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/assets-dash/css/themify-icons.css" rel="stylesheet">


    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/assets-dash/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/assets-dash/js/bootstrap.min.js" type="text/javascript"></script>
	<!--  Charts Plugin -->
	<script src="${pageContext.request.contextPath}/resources/assets-dash/js/chartist.min.js"></script>
</head>
<body>


<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                   <stroke>Hello Docent!</stroke> <br/> <small>Management System</small> 
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="#">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-user"></i>
                        <p>유저 목록</p>
                    </a>
                </li>
                
                 <li>
                    <a href="/manage/reqDocentInfo">
                        <i class="ti-user"></i>
                        <p>도슨트 활동 요청</p>
                    </a>
                </li>
                
                
                <li>
                    <a href="#">
                        <i class="ti-view-list-alt"></i>
                        <p>Table List</p>
                    </a>
                </li>
                
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Stats</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>Notifications</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">warning!</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>Settings</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>


	<tiles:insertAttribute name="content" />


</div>
</div>
</body>

<!--   Core JS Files   -->



	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="${pageContext.request.contextPath}/resources/assets-dash/js/bootstrap-checkbox-radio.js"></script>



    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath}/resources/assets-dash/js/bootstrap-notify.js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="${pageContext.request.contextPath}/resources/assets-dash/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath}/resources/assets-dash/js/demo.js"></script>

</html>