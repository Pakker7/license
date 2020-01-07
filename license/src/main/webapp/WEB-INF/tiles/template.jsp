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
  
	<link rel="stylesheet" type="text/css" href="./vendor/fontawesome-free/css/all.min.css" />
	<link rel="stylesheet" type="text/css" href="./vendor/datatables/dataTables.bootstrap4.css" />
	<link rel="stylesheet" type="text/css" href="./css/sb-admin.css" />
	<link rel="stylesheet" type="text/css" href="./css/sb-admin.min.css" />
    <link rel="shortcut icon" type="image/x-icon" href="./image/favicon.ico">
    
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="./js/sb-admin.js" type="text/javascript"></script>
	<script src="./js/sb-admin.min.js" type="text/javascript"></script>
	
</head>
<body>
    <div style="width:100%; height:100%;">
	    <div id="header"><tiles:insertAttribute name="header" /></div>
	    <div id="left"><tiles:insertAttribute name="left" /></div>
	    <div id="main"><tiles:insertAttribute name="body" /></div>    
	    <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </div>
 
    <script type="text/javascript">
        $(function() {
 
        });    
    </script>    
</body>
</html>