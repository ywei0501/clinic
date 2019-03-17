package edu.angy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.angy.entity.PageModel;
import edu.angy.entity.PageModel2;
import edu.angy.entity.Patient;
import edu.angy.entity.PatientRecordQueryResult;
import edu.angy.entity.QueryInformation;
import edu.angy.service.PatientRecordService;
import edu.angy.service.PatientService;
import edu.angy.service.impl.PatientRecordServiceImpl;
import edu.angy.service.impl.PatientServiceImpl;

public class SelectPatientRecordServlet extends HttpServlet {
	private PatientRecordService patientRecordService=new PatientRecordServiceImpl();
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1:获取患者ID
		String patientId = request.getParameter("patientId");
		
		//PatientRecordQueryResult prqr=patientRecordService.getPatientRecordById(Integer.parseInt(patientId));
		
		//PageModel pm = patientService
		//.getPatientByQueryInformation(queryInfo);
		PageModel2 pm2=patientRecordService.getPatientRecordById2(Integer.parseInt(patientId));
		
		request.setAttribute("pm2",pm2);
		
		RequestDispatcher rd =
				this.getServletContext()
				.getRequestDispatcher
				("/WEB-INF/views/jsp/patientRecord.jsp");
		// 4: 请求转发
		rd.forward(request, response);		
		
	}
}