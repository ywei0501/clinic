package edu.angy.service.impl;

import edu.angy.dao.PatientDao;
import edu.angy.dao.PatientRecordDao;
import edu.angy.dao.impl.PatientDao4MySQL;
import edu.angy.dao.impl.PatientRecordDao4Mysql;
import edu.angy.entity.PageModel;
import edu.angy.entity.PageModel2;
import edu.angy.entity.PatientRecord;
import edu.angy.entity.PatientRecordQueryResult;
import edu.angy.entity.QueryResult;
import edu.angy.service.PatientRecordService;
import edu.angy.service.PatientService;

public class PatientRecordServiceImpl implements PatientRecordService{
	//private PatientDao patientDao = new PatientDao4MySQL();
	private PatientRecordDao patientRecordDao=new PatientRecordDao4Mysql();
	public PatientRecordQueryResult getPatientRecordById(Integer patientId) {
		return patientRecordDao.obtainCurrentPatientRecordData(patientId);
	}

	public PageModel2 getPatientRecordById2(Integer patientId) {
		//QueryResult qr = patientDao.obtainCurrentPageData
		//(queryInfo.getStartIndex(), queryInfo.getPageSize());
		PatientRecordQueryResult prqr=patientRecordDao.obtainCurrentPatientRecordData(patientId);
		
		PageModel2 pm2 = new PageModel2();
		pm2.setPatientRecordList(prqr.getPatientRecordList());
		
		return pm2;
	}
}
