<%@ page pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Hello Docent!</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/paper-kit.css?v=2.2.1"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="${pageContext.request.contextPath}/resources/assets/demo/demo.css"
	rel="stylesheet" />
</head>
<body class="landing-page sidebar-collapse">

	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="content" />

</body>

<!--   Core JS Files   -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/core/jquery.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/core/popper.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/core/bootstrap.min.js"
	type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/nouislider.min.js"
	type="text/javascript"></script>
<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/moment.min.js"></script>
<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/bootstrap-tagsinput.js"></script>
<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/bootstrap-selectpicker.js"
	type="text/javascript"></script>
<!--	Plugin for Datetimepicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/bootstrap-datetimepicker.js"
	type="text/javascript"></script>
<!--  Vertical nav - dots -->
<!--  Photoswipe files -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/photo_swipe/photoswipe.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/photo_swipe/photoswipe-ui-default.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/photo_swipe/init-gallery.js"></script>
<!--  for Jasny fileupload -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/jasny-bootstrap.min.js"></script>
<!-- Control Center for Paper Kit: parallax effects, scripts for the example pages etc -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/paper-kit.js?v=2.2.1"
	type="text/javascript"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Plugin for presentation page - isometric cards  -->
<script
	src="${pageContext.request.contextPath}/resources/assets/js/plugins/presentation-page/main.js"></script>
</html>