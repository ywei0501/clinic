package edu.angy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.angy.entity.Patient;
import edu.angy.service.PatientRecordService;
import edu.angy.service.PatientService;
import edu.angy.service.impl.PatientRecordServiceImpl;
import edu.angy.service.impl.PatientServiceImpl;

public class AddPatientServlet extends HttpServlet{
	private PatientService patientService = new PatientServiceImpl();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oper = request.getParameter("oper");
		if(oper == null) {
			RequestDispatcher rd =
					this.getServletContext()
					.getRequestDispatcher
					("/WEB-INF/views/jsp/addPatient.jsp");
			// 4: 请求转发
			rd.forward(request, response);
		}else {
			
		Patient patient =new Patient();
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String officePhoneNumber= request.getParameter("officePhoneNumber");
		String mobilePhoneNumber= request.getParameter("mobilePhoneNumber");
		String email= request.getParameter("email");
		
		
		patient.setName(name);
		patient.setSex(sex.charAt(0));
		patient.setOfficePhoneNumber(officePhoneNumber);
		patient.setMobilePhoneNumber(mobilePhoneNumber);
		patient.setEmail(email);
		//回调，将数据保存至数据库
		patientService.addPatientInfo(patient);
		RequestDispatcher rd =
				this.getServletContext()
				.getRequestDispatcher
				("/selectPatientServlet");
	 // 4: 请求转发
	 rd.forward(request, response);
		}
	}
		
}
