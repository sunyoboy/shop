<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path%>/dwr/engine.js"> </script>
<script type="text/javascript" src="<%=path%>/dwr/interface/FileUtil.js"> </script>
<title>Insert title here</title>
</head>
<body>
</body>
<script type="text/javascript">
FileUtil.getData('HelloWorld', {
	  callback:function(str) { alert(str); },
	  timeout:5000,
	  errorHandler:function(message) { alert("Oops: " + message); }
	});
</script>
</html>