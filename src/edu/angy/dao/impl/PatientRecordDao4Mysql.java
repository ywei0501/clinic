package edu.angy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.angy.dao.JDBCUtils;
import edu.angy.dao.PatientRecordDao;
import edu.angy.entity.Patient;
import edu.angy.entity.PatientRecord;
import edu.angy.entity.PatientRecordQueryResult;

public class PatientRecordDao4Mysql implements PatientRecordDao{
	private String Get_Patient_By_Id_SQL = 
			" SELECT * FROM Patient WHERE PatientId = ? ";
	
	private String Get_PatientReord_By_Id_SQL = 
			" SELECT * FROM PatientRecord WHERE patientId.? IN(SELECT patientId FROM Patient WHERE Patient.patientId=PatientRecord.patientId) ";

//	private String Test =
//			"SELECT * FROM PatientRecord WHERE RecordId=?"; 
	
	private String Test1 ="SELECT * FROM PatientRecord WHERE patientId=?";
	
	private String Test = 
			" SELECT * FROM PatientRecord WHERE PatientRecord.patientId=? IN(SELECT Patient.patientId FROM Patient WHERE Patient.patientId=PatientRecord.patientId) ";
	
	private Connection connection;
	private PreparedStatement pst;//执行sql语句
	private ResultSet rs;//获得结果集
	
	@Override
	public PatientRecordQueryResult obtainCurrentPatientRecordData(Integer patientId) {
		PatientRecordQueryResult prqr=new PatientRecordQueryResult();
		List<PatientRecord> patientRecordList = new ArrayList<>();
		
		connection = JDBCUtils.getConnection();
		if(connection != null) {
			try {
				//执行sql语句
				//pst = connection.prepareStatement(Get_PatientReord_By_Id_SQL);
				pst = connection.prepareStatement(Test1);
				pst.setInt(1, patientId);
				rs = pst.executeQuery();
				while(rs.next()) {
					PatientRecord patientRecord=new PatientRecord();
					patientRecord.setPatientId(rs.getInt("patientId"));
					patientRecord.setRecordId(rs.getInt("RecordId"));
					patientRecord.setName(rs.getString("Name"));
					patientRecord.setDiseaseType(rs.getString("DiseaseType"));
					patientRecord.setDf(rs.getDate("df"));
					
					
					patientRecordList.add(patientRecord);
				}
				
				prqr.setPatientRecordList(patientRecordList);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.close(connection, pst, rs);
			}
			
		}
		return prqr;
	}
}
