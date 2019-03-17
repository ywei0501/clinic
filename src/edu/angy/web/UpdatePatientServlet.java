package edu.angy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.angy.entity.Patient;
import edu.angy.service.PatientService;
import edu.angy.service.impl.PatientServiceImpl;

 
public class UpdatePatientServlet extends HttpServlet {
	private PatientService patientService = new PatientServiceImpl();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oper = request.getParameter("oper");
		if(oper == null) {
			// 1:获取患者ID
			String patientId = request.getParameter("patientId");
			// 2:调用业务组件
			Patient patient = patientService.getPatientById(Integer.parseInt(patientId));
			// 3:请求转发
			request.setAttribute("patient", patient);
			RequestDispatcher rd =
					this.getServletContext()
					.getRequestDispatcher
					("/WEB-INF/views/jsp/updatePatient.jsp");
			// 4: 请求转发
			rd.forward(request, response);
		}else {
			 String patientId = request.getParameter("patientId");
			 String name= request.getParameter("name");
			 String sex= request.getParameter("sex");
			 String officePhoneNumber= request.getParameter("officePhoneNumber");
			 String mobilePhoneNumber= request.getParameter("mobilePhoneNumber");
			 String email= request.getParameter("email");
			
			 Patient patient =new Patient();
			 
			 patient.setPatientId(Integer.parseInt(patientId));
			 patient.setName(name);
			 patient.setEmail(email);
			 patient.setOfficePhoneNumber(officePhoneNumber);
			 patient.setMobilePhoneNumber(mobilePhoneNumber);
			 patient.setSex(sex.charAt(0));
			 // 完成更新
			 
			 patientService.updatePatientInfo(patient);
			 						 
			 RequestDispatcher rd =
						this.getServletContext()
						.getRequestDispatcher
						("/selectPatientServlet");
			 // 4: 请求转发
			 rd.forward(request, response);
		}
		
		
	}
}
