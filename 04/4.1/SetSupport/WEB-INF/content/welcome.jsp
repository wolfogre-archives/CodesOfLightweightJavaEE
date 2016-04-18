<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>转换结果</title>
</head>
<body>
	<s:actionmessage/>
	<s:property value="users"/>
<!-- 访问users集合属性里索引属性值为crazyit.org的元素的name属性-->
用户crazyit.org的用户名为：<s:property value="users('crazyit.org').name"/><br/>
<!-- 访问users集合属性里索引属性值为crazyit.org的元素的pass属性-->
用户crazyit.org的密码为：<s:property value="users('crazyit.org').pass"/><br/>
<!-- 访问users集合属性里索引属性值为fkit的元素的name属性-->
用户fkit的用户名为：<s:property value="users('fkit').name"/><br/>
<!-- 访问users集合属性里索引属性值为fkit的元素的pass属性-->
用户fkit的密码为：<s:property value="users('fkit').pass"/><br/>
生日为：<s:property value="birth"/><br/>
</body>
</html>
