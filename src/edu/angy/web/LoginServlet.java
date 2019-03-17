package edu.angy.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.angy.dao.JDBCUtils;
import edu.angy.dao.impl.DbDao;

public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String errMsg = "";
	    String username = request.getParameter("username");//获取客户端数据
	    String pass = request.getParameter("pass");
	    RequestDispatcher rd;
	    
	    String test="admin";
	    
	    try {
	        DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql:///Clinic",
	                "root", "123456");
	        //dd.getConnection();
//	        Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection(
//					"jdbc:mysql:///Clinic", "root", "123456");
	        
	        // 查询结果集
	        //ResultSet rs = dd.query("select pass from user_table where username = ?", username);
	        ResultSet rs = dd.query2("select * from user_table ");
	        if(rs.next()){
	            //用户名和密码匹配
	        	System.out.println("已经有查询结果");
	                
	        	//此处admin查询不出来，但是wang可以查询出来
	        	//System.out.println("pass >> "+rs.getString("pass"));
	        	//System.out.println(pass);
	            if(rs.getString("pass").equals(pass)) {
	            	//rs.getString("pass").equals(pass)&&rs.getString("username").equals(username)
//		        	while(rs.next()) {
//	                //假如 User 表中 有个 name 列
//	                System.out.println("username >> "+rs.getString("username"));
//	                System.out.println("pass >> "+rs.getString("pass"));
//	            }
	            	
	                //获取session对象
                    HttpSession session = request.getSession(true);
	                session.setAttribute("name", username);
	                
	                //获取转发对象
	                
//	                rd   =  this.getServletContext()
//	        				.getRequestDispatcher
//	        				("/selectPatientServlet");
	                
	                rd = request.getRequestDispatcher("/WEB-INF/views/jsp/welcome.jsp");
	                  
	                // 转发请求
	                rd.forward(request, response);
	            } else {
	                errMsg += "您的用户名密码不匹配，请重新输入";
	            }
	        } else {
	            errMsg += "您的用户名不存在，请先注册";
	        }
	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	    // 如果出错，转发到重新登陆
	    if(errMsg != null && !errMsg.equals("")){
	    	System.out.println("重新登录");
	        rd = request.getRequestDispatcher("/WEB-INF/views/jsp/login.jsp");
	        
	        request.setAttribute("err", errMsg);
	        rd.forward(request, response);
	    }
	    }
}
