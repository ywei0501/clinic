package edu.angy.dao.impl;

import edu.angy.dao.PatientDao;
import edu.angy.entity.Patient;
import edu.angy.entity.QueryResult;

public class PatientDao4SQLServer implements PatientDao {

	@Override
	public QueryResult obtainCurrentPageData(Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePatientById(Integer patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientById(Integer patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addPatientInfo(Patient patient) {
		// TODO Auto-generated method stub
				return false;
	}

}
