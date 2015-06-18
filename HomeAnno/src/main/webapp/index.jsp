<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <!-- <form action="userController/reg.do" method="post">
    	手机号：<input type="text" name="mobilePhone"/><br>
    	车号：<input type="text" name="plates"/><br>
    	用户名:<input type="text" name="name"/><br>
    	<input type="submit" title="submit"/>
    
    </form> -->
    =============================
    <form action="entityOrderController/addt.do" method="post">
    	单据编号：<input type="text" name="orderId"/><br>
    	客户名称：<input type="text" name="customName"/><br>
    	车号:<input type="text" name="carNum"/><br>
    	物料：<input type="text" name="material"/><br>
    	实发净重：<input type="text" name="realRecive"/><br>
    	实收数量:<input type="text" name="realSend"/><br>
    	验收时间：<input type="text" name="reciveTime"/><br>
    	验收人：<input type="text" name="reciver"/><br>
    	备注:<input type="text" name="remarks"/><br>
    	<input type="submit" title="submit"/>
    
    </form>
    
  </body>
</html>
