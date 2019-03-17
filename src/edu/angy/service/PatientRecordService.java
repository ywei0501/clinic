package edu.angy.service;

import edu.angy.entity.PageModel;
import edu.angy.entity.PageModel2;
import edu.angy.entity.PatientRecord;
import edu.angy.entity.PatientRecordQueryResult;
import edu.angy.entity.QueryInformation;

public interface PatientRecordService {
	//PatientRecordQueryResult
	PatientRecordQueryResult getPatientRecordById(Integer patientId);
	//PageModel getPatientByQueryInformation(QueryInformation queryInfo);
	PageModel2 getPatientRecordById2(Integer patientId);
}
