<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>license</title>
  	<!-- add -->
  	
	<!-- bootstrap -->
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap-toggle.min.css"/>

    <!-- datepicker -->
    <link rel="stylesheet" href="/resources/assets/css/bootstrap-datepicker.min.css"/>
    <link rel="stylesheet" href="/resources/assets/css/bootstrap-datetimepicker.min.css"/>

    <!-- tootip -->
    <link rel="stylesheet" href="/resources/assets/css/hint.min.css"/>

    <!-- Scroll -->
    <link rel="stylesheet" href="/resources/assets/css/jquery.mCustomScrollbar.min.css"/>

    <!-- i-PMS -->
    <link rel="stylesheet" href="/resources/assets/css/reset.css"/>
    <link rel="stylesheet" href="/resources/assets/css/style.css"/>
    
    <!-- jquery -->
    <script type="text/javascript" src="/resources/assets/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/jquery.validate.min.js"></script>
    <!-- <script type="text/javascript" src="/resources/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/bootstrap-toggle.min.js"></script> -->
    
    <script type="text/javascript" src="/resources/assets/js/moment.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/locales/bootstrap-datepicker.kr.min.js"></script>
  
	<link rel="stylesheet" type="text/css" href="/resources/vendor/fontawesome-free/css/all.min.css" />
	<link rel="stylesheet" type="text/css" href="/resources/vendor/datatables/dataTables.bootstrap4.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/sb-admin.css" />
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
    <link rel="shortcut icon" type="image/x-icon" href="/resources/image/favicon.ico">
	
</head>
<body>
    <div style="width:100%; height:100%;">
	    <div id="header"><tiles:insertAttribute name="header" /></div>
	    <div id="left" style="width: 230px;"><tiles:insertAttribute name="left" /></div>
	    <div id="main"><tiles:insertAttribute name="body" /></div>    
	    <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </div>
 
    <script type="text/javascript">
    $( document ).ready(function() {

	});

    </script>    
</body>
</html>