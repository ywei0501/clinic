package edu.angy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.angy.service.PatientService;
import edu.angy.service.impl.PatientServiceImpl;

 
public class DeletePatientServlet extends HttpServlet {
	private PatientService patientService = new PatientServiceImpl();
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1:获取待删除患者ID
		String patientId = request.getParameter("patientId");
		// 2:调用业务组件
		patientService.deletePatientById(Integer.parseInt(patientId));
		// 3:请求转发
		RequestDispatcher rd =
				this.getServletContext()
				.getRequestDispatcher
				("/selectPatientServlet");
		// 4: 请求转发
		rd.forward(request, response);
	}
}
