package edu.angy.dao.impl;

import java.util.List;

import edu.angy.dao.PatientDao;
import edu.angy.entity.Patient;
import edu.angy.entity.QueryResult;

public class PatientDao4MySQLTest {

	public static void testObtainCurrentPageData() {
		PatientDao patientDao = new PatientDao4MySQL();
		QueryResult rs = patientDao.obtainCurrentPageData(0, 5);
		System.out.println("总记录条数:"+rs.getTotalRecordAmount());
		
		List<Patient> patientList = rs.getPatientList();
		for(Patient p : patientList) {
			System.out.println(p.getName());
		}
	}
	public static void main(String[] args) {
		testObtainCurrentPageData();
	}

}
