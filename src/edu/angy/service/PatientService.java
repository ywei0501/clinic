package edu.angy.service;

import edu.angy.entity.PageModel;
import edu.angy.entity.Patient;
import edu.angy.entity.QueryInformation;

public interface PatientService {
	//需要给PageModel中的set方法传递参数，需要使用到QueryInformation和QueryResult中的get方法
	PageModel getPatientByQueryInformation(QueryInformation queryInfo);
	
	boolean deletePatientById(Integer patientId);
	
	Patient getPatientById(Integer patientId);
	
	boolean updatePatientInfo(Patient patient);
	
	boolean addPatientInfo(Patient patient);

}
