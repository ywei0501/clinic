package edu.angy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC数据访问工具类
 * @author 湖南工业大学 
 */
//JDBC数据访问工具类

//这里只执行了：加载数据库驱动，连接数据库，关闭数据库
//其余两个步骤：执行sql语句，查询结果放在实现类：PatientDao4Mysql
public class JDBCUtils {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql:///Clinic";
	private static String USER = "root";
	private static String PASSWORD = "123456";
	
	private static Connection connection;
	/**
	 * 获取数据库连接
	 * @return 数据库连接对象
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(
					URL, USER, PASSWORD);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
	/**
	 * 释放数据库资源
	 * @param connection 数据库连接
	 * @param statement SQL语句
	 * @param resultSet 结果集
	 */
	public static void close(Connection connection , Statement statement , ResultSet resultSet) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
