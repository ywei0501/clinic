<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<!-- 输出错误提示信息 -->
	<span style="color:black; font-weight:bold">
	<%
    if(request.getAttribute("err")!=null){
        out.println(request.getAttribute("err") + "<br/>");
    }
	%>
	</span>
	<center>请输入用户名和密码：</center><br/>
	
	<form id="login" method="post" action="loginServlet">
	<table align="center">
		<tr>
			<td>用户名：</td>
			<td>
				<input type="text" name="username" /><br/>
			</td>
		</tr>
		<tr>
			<td>密    码：</td>
			<td>
				<input type="password" name="pass" /><br/>
			</td>
		</tr>
	</table><br/>
         
    <center>
    	<input type="hidden" name="oper" value="update"/>
    	<input type="submit" value="登陆"/><br/>
    </center><br/>     
    
	</form>
	<center>
	<a href="${pageContext.request.contextPath}/registerServlet?">注册用户</a>
	
	</center>
</body>
</html>