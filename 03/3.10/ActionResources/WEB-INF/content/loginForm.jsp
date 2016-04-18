<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2016, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!-- 加载baseName为viewResources包下的baseName为loginForm的国际化资源文件 -->
<s:i18n name="viewResources.loginForm">
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<!-- 使用text标签来输出国际化消息 -->
	<title><s:text name="loginPage"/></title>
</head>
<body>
	<s:form action="login">
		<!-- 表单标签中使用key属性来输出国际化消息 -->
		<s:textfield name="username" key="user"/>
		<s:textfield name="password" key="pass"/>
		<s:submit key="login"/>
	</s:form>
</body>
</html>
</s:i18n>
