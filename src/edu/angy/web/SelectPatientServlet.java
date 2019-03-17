package edu.angy.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.angy.entity.PageModel;
import edu.angy.entity.QueryInformation;
import edu.angy.service.PatientService;
import edu.angy.service.impl.PatientServiceImpl;

public class SelectPatientServlet extends HttpServlet {

	@Override
	//继承HttpServlet，重写service方法
	protected void service(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
		// 1:做一些基础工作
		
			// 1.1 获取客户端传递的信息
		
			String pageNumberStr = 
				request.getParameter("pageNumber");
			String pageSizeStr = 
				request.getParameter("pageSize");
			
			QueryInformation queryInfo = null;
			
			/*
			 * string.Trim()切掉字符串两边的空白
               string.Trim().Equal()判断去除空白后是否和equal括号中的内容相等
               string.Trim().Equal("")判断去除空白后是否和equal括号中的空字符串相等
            */
			if(pageNumberStr == null || pageNumberStr.trim().equals("") || pageSizeStr == null || pageSizeStr.trim().equals("") ) {
				//若为空则传递给无参构造器
				queryInfo = new QueryInformation();
			}else {
				//若不为空则传递给有参构造器
				queryInfo = new QueryInformation(Integer.parseInt(pageNumberStr) , Integer.parseInt(pageSizeStr));
			}
			
		// 2:调用服务层(业务逻辑层)
		PatientService patientService 
			= new PatientServiceImpl();//多态，父类引动指向子类对象
		PageModel pm = patientService
				.getPatientByQueryInformation(queryInfo);
		
		// 3:将携带页面数据的pm对象转送给视图技术-JSP
		request.setAttribute("pm", pm);
			
		RequestDispatcher rd =
				this.getServletContext()
				.getRequestDispatcher
				("/WEB-INF/views/jsp/patientList.jsp");
		// 4: 请求转发
		rd.forward(request, response);
	}
	

}
