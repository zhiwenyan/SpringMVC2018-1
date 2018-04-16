<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVC</title>
</head>
<body>
	<a href="helloworld">Hello World</a>
	<br />

	<a href="springmvc/testRequestMapping">testRequestMapping</a>
	<br/>


	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="submit" />
	</form>
	<br/>

	<a href="springmvc/testParamsAndHeaders?username=steven&age=10">
		testParamsAndHeaders</a>
	<br/>

	<a href="springmvc/testAntPath/xyz/aa">testAntPath</a>
	<br>
	<a href="springmvc/testPathVariable/1">testPathVariable</a>
	<br/>
	
	
	
	<a href="springmvc/testRest/1">test Rest Get</a>
	<br/>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="post请求" />
	</form>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="submit" value="DELETE请求" />
	</form>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="PUT请求" />
	</form>
	<br/>
	
	<a href="springmvc/testRequestParam?username=steven&age=11">testRequestParam</a><br/>
	<a href="springmvc/testRequestHeader">testRequestHeader</a><br/>
	<a href="springmvc/testCookieValue">testCookieValue</a><br/>
	
	
	<form action="springmvc/testPojo" method="post">
		username:<input type="text" name="username" /><br/>
		password:<input type="password" name="password" /><br/>
		email:<input type="text" name="email" /><br/>
		age:<input type="text" name="age" /><br/>
		provice:<input type="text" name="address.provice" /><br/>
		city:<input type="text" name="address.city" /><br/>
				<input type="submit" value="submit" />
		
	</form>
	
		<a href="springmvc/testSevletAPI">testSevletAPI</a><br/>
		<a href="springmvc/testModelAndView">testModelAndView</a><br/>
		<a href="springmvc/testMap">testMap</a><br/>
		<a href="springmvc/testSesionAttribute">testSesionAttribute</a><br/>
	<!-- modelAttribute
	模拟修改操作：
	1、原始数据为：1   Tom  123456  tom@qq.com
	2、密码不能修改  
	3、表单回显，模拟操作直接在表单填写对应的属性值
	 -->

	<form action="springmvc/testModelAttribute" method="post">
	<input type="hidden" name="id" value="1"/><br/>
		username:<input type="text" name="username" value="Tom"/><br/>
<!-- 		password:<input type="password" name="password" value="123456"/><br/>
 -->		
 email:<input type="text" name="email" value="tom@qq.com"/><br/>
		age:<input type="text" name="age" value="12" /><br/>
				<input type="submit" value="submit" />
	</form>
	<br/>
	<a href="springmvc/testViewAndViewResolver">testViewAndViewResolver</a>
	<br/>
	<fmt:message key="i18n.username"></fmt:message>
	<fmt:message key="i18n.password"></fmt:message>
	<br/>
	<a href="springmvc/testView">testView</a><br/>
	<a href="springmvc/testRedirect">testRedirect</a>
	
</body>
</html>