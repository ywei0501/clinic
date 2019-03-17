<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
	
	<form action="addPatientServlet" method ="post">
	<table align="center">
		
		<tr>
			<td >姓名:</td>
			<td >
				<input type="text" name="name" value=""/>
			</td>		
		</tr>
		<tr>
			<td >性别:</td>
			<td >
				<input type="text" name="sex" value=""/>
			</td>		
		</tr>
		<tr>
			<td>办公电话:</td>
			<td >
				<input type="text" name="officePhoneNumber" value=""/>
			</td>		
		</tr>
		<tr>
			<td >手机号码:</td>
			<td >
				<input type="text" name="mobilePhoneNumber" value=""/>
			</td>		
		</tr>
		<tr>
			<td > 电子邮件:</td>
			<td>
				<input type="text" name="email" value=""/>
			</td>		
		</tr>	 
	</table>
	<br/><br/>
	<center>
			<input type="hidden" name="oper" value="add"/>
		 	<input type="submit" value="添加"/>
	</center>
					 
	</form>
</body>
</html>
