<%@ page language="java" import="edu.angy.entity.*,java.util.*" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>更新</title>
	</head>
	<body>
	<%
		Patient patient = 
		(Patient)request.getAttribute("patient");
	%>
	<form action="updatePatientServlet" method ="post">
	<table align="center">
		<tr>
			<td >患者编号:</td>
			<td >
				<input readonly="readonly" type="text" name="patientId" value="<%=patient.getPatientId() %>"/>
			</td>		
		</tr>
		<tr>
			<td >姓名:</td>
			<td >
				<input readonly="readonly" type="text" name="name" value="<%=patient.getName() %>"/>
			</td>		
		</tr>
		<tr>
			<td >性别:</td>
			<td >
				<input readonly="readonly" type="text" name="sex" value="<%=patient.getSex() %>"/>
			</td>		
		</tr>
		<tr>
			<td>办公电话:</td>
			<td >
				<input type="text" name="officePhoneNumber" value="<%=patient.getOfficePhoneNumber() %>"/>
			</td>		
		</tr>
		<tr>
			<td >手机号码:</td>
			<td >
				<input type="text" name="mobilePhoneNumber" value="<%=patient.getMobilePhoneNumber() %>"/>
			</td>		
		</tr>
		<tr>
			<td > 电子邮件:</td>
			<td>
				<input type="text" name="email" value="<%=patient.getEmail() %>"/>
			</td>		
		</tr>
			 
	</table>
	<br/><br/>
	<center>
			<input type="hidden" name="oper" value="update"/>
		 	<input type="submit" value="更新"/>
	</center>
					 
	</form>
				
	</body>
</html>