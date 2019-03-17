<%@ page language="java" import="edu.angy.entity.*,java.util.*" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>患者记录</title>
</head>
<body>
	<%
	PageModel2 pm2 = (PageModel2)request.getAttribute("pm2");
	 %>
<table align = "center" border = "1" width = "80%" >
		<caption>详细患者信息</caption>
		<tr>
			<th>患者编号</th>
			<th>记录编号</th>
			<th>姓名</th>
			<th>日期</th>
			<th>患病类型</th>
		</tr>
		<%
			List<PatientRecord> patientRecordList = pm2.getPatientRecordList();
			for(PatientRecord patientRecord : patientRecordList){
				%>
		<tr>
						
					    <td><%=patientRecord.getPatientId() %></td>
						<td><%=patientRecord.getRecordId() %></td>
						<td><%=patientRecord.getName() %></td>
						<td><%=patientRecord.getDf() %></td>
						<td><%=patientRecord.getDiseaseType() %></td>
						
						
					</tr>
		<%
			}
		%>
	</table>

	<center>
		<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
	</center>


</body>
</html>
