package edu.angy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.angy.dao.JDBCUtils;
import edu.angy.dao.PatientDao;
import edu.angy.entity.Patient;
import edu.angy.entity.QueryResult;

public class PatientDao4MySQL implements PatientDao {
	
	private String Obtain_Current_Page_Data_SQL =
						" SELECT * FROM Patient LIMIT ? , ? ";
	
	private String Obtain_Total_Record_Amount = 
			" SELECT COUNT(*) AS Amount FROM Patient ";//Amount：总量
	
	private String Delete_Patient_By_Id_SQL = 
			" DELETE FROM Patient WHERE PatientId = ? ";
	
	
	private String Get_Patient_By_Id_SQL = 
			" SELECT * FROM Patient WHERE PatientId = ? ";
	
	private Connection connection;
	private PreparedStatement pst;//执行sql语句
	private ResultSet rs;//获得结果集
	@Override
	//实现接口
	public QueryResult obtainCurrentPageData(Integer startIndex, Integer pageSize) {
		QueryResult qr = new QueryResult();//new出QueryResult类的对象qr
		List<Patient> patientList = new ArrayList<>();//将一个patient的所有信息封装成一个数组成员
		connection = JDBCUtils.getConnection();//静态方法访问可以用：类名.方法名  
		if(connection != null) {
			try {
				//执行sql语句
				pst = connection.prepareStatement(Obtain_Current_Page_Data_SQL);
				
				//设置sql语句中的两个"?",即第一页到第二页之间的数据
				pst.setInt(1, startIndex);
				pst.setInt(2, pageSize);
				
				//结果集=执行完sql语句之后，使用方法executeQuery获得
				rs = pst.executeQuery();
				while(rs.next()) {
					Patient patient = new Patient();
					
					//调用Patient中的set方法
					patient.setPatientId(rs.getInt("PatientId"));
					patient.setName(rs.getString("Name"));
					patient.setSex(rs.getString("Sex").charAt(0));
					patient.setOfficePhoneNumber(rs.getString("OfficePhoneNumber"));
					patient.setMobilePhoneNumber(rs.getString("MobilePhoneNumber"));
					patient.setEmail(rs.getString("Email"));
					
					//将一个patient的所有信息添加成一个数组成员
					patientList.add(patient);
				}
				
				//将查询结果封装到QueryResult类
				qr.setPatientList(patientList);
				
				//查询总记录条数
				pst = connection.prepareStatement(Obtain_Total_Record_Amount);
				rs = pst.executeQuery();//获得查询结果
				if(rs.next()) {
					int amount = rs.getInt("Amount");
					qr.setTotalRecordAmount(amount);//将结果当参数传递到QueryResult
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(connection, pst, rs);
			}
			
		}
		return qr;
	}
	@Override
	public boolean deletePatientById(Integer patientId) {
		boolean isDelete = false;
		connection = JDBCUtils.getConnection();
		if(connection != null) {
			try {
				pst = connection.prepareStatement(Delete_Patient_By_Id_SQL);
				pst.setInt(1, patientId); 
				isDelete = pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(connection, pst, rs);
			}
		}
		return isDelete;
	}
	@Override
	public Patient getPatientById(Integer patientId) {
		Patient patient = null;
		connection = JDBCUtils.getConnection();
		if(connection != null) {
			try {
				pst = connection.prepareStatement(Get_Patient_By_Id_SQL);
				pst.setInt(1, patientId);
				
				rs = pst.executeQuery();
				
				if(rs.next()) {
					patient = new Patient();
					
					patient.setPatientId(rs.getInt("PatientId"));
					patient.setName(rs.getString("Name"));
					patient.setSex(rs.getString("Sex").charAt(0));
					patient.setOfficePhoneNumber(rs.getString("OfficePhoneNumber"));
					patient.setMobilePhoneNumber(rs.getString("MobilePhoneNumber"));
					patient.setEmail(rs.getString("Email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(connection, pst, rs);
			}
		}
		return patient;
	}
	@Override
	public boolean updatePatientInfo(Patient patient) {
		boolean isUpdate = false;
		
		String sql = " UPDATE Patient SET OfficePhoneNumber= ?,MobilePhoneNumber = ?,Email = ? WHERE PatientId = ? ";  
		connection = JDBCUtils.getConnection();
		if(connection != null) {
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, patient.getOfficePhoneNumber());
				pst.setString(2, patient.getMobilePhoneNumber());
				pst.setString(3, patient.getEmail());
				pst.setInt(4, patient.getPatientId());
				
				int count = pst.executeUpdate();
				if(count > 0) {
					isUpdate = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(connection, pst, rs);
			}
		}
		return isUpdate;
	}
	
	public boolean addPatientInfo(Patient patient) {
		boolean isAdd = false;
		String sql = "INSERT INTO Patient (Name , Sex , OfficePhoneNumber , MobilePhoneNumber, Email ) VALUES (?,?,?,?,?) ";
		connection = JDBCUtils.getConnection();
		if(connection!=null) {
			try {
				pst=connection.prepareStatement(sql);
				pst.setString(1, patient.getName());
				pst.setString(2, String.valueOf(patient.getSex()));
				pst.setString(3, patient.getOfficePhoneNumber());
				pst.setString(4, patient.getMobilePhoneNumber());
				pst.setString(5, patient.getEmail());
				
				pst.execute();
				//int count = pst.executeUpdate();
			//	if(count > 0) {
				//	isAdd = true;
				//}
			}catch(SQLException e){
				e.printStackTrace();
			}finally {
				
			}
		}
		return isAdd;
		
	}


}
