<%@ page language="java" import="edu.angy.entity.*,java.util.*" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>患者列表页面</title>
	</head>
	<body>
	<%
		PageModel pm = (PageModel)request.getAttribute("pm");
	 %>
	  
	<table align="center" border = "1" width="80%">
		<caption>患者信息</caption>
		<tr>
			<th>头像</th>
			<th>患者编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>办公电话</th>
			<th>手机号码</th>
			<th>电子邮件</th>
			<th>操作</th>
		</tr>
		<%
			List<Patient> patientList = pm.getPatientList();
			for(Patient patient : patientList){
				%>
					<tr>
						<td><img src="d:/photo.png" width="100" height="100"/></td>
						<td><%=patient.getPatientId() %></td>
						<td><%=patient.getName() %></td>
						<td><%=patient.getSex() %></td>
						<td><%=patient.getOfficePhoneNumber() %></td>
						<td><%=patient.getMobilePhoneNumber() %></td>
						<td><%=patient.getEmail() %></td>
						<td>
							<a href="${pageContext.request.contextPath}/deletePatientServlet?patientId=<%=patient.getPatientId()%>">删除</a>
							<a href="${pageContext.request.contextPath}/updatePatientServlet?patientId=<%=patient.getPatientId()%>">修改</a>
							<a href="${pageContext.request.contextPath}/selectPatientRecordServlet?patientId=<%=patient.getPatientId()%>">详细</a>
						</td>
					</tr>
				<%
			}
		%>
	</table> <br/><br/>
	<center>
	    <a href="${pageContext.request.contextPath}/addPatientServlet?">添加</a>
	
		共<%=pm.getTotalRecordAmount() %>条记录,共<%=pm.getTotalPageNumber() %>页,当前第<%=pm.getPageNumber() %>页
		&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/selectPatientServlet?pageNumber=<%=pm.getPreviousPageNumber() %>&pageSize=5">上一页</a>&nbsp;&nbsp;
		<%
			Integer[] pageNumberBar = pm.getPageNumberBar();
			for(int i = 0 ; i < pageNumberBar.length ; i++){
				%>
					<a href="${pageContext.request.contextPath}/selectPatientServlet?pageNumber=<%=pageNumberBar[i] %>&pageSize=5"><%=pageNumberBar[i] %>&nbsp;</a>
				<%
			}
		%>
		<a href="${pageContext.request.contextPath}/selectPatientServlet?pageNumber=<%=pm.getNextPageNumber() %>&pageSize=5">下一页</a>&nbsp;&nbsp;
	</center>
	</body>
</html>