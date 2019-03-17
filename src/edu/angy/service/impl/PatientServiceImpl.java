package edu.angy.service.impl;

import edu.angy.dao.PatientDao;
import edu.angy.dao.impl.PatientDao4MySQL;
import edu.angy.entity.PageModel;
import edu.angy.entity.Patient;
import edu.angy.entity.QueryInformation;
import edu.angy.entity.QueryResult;
import edu.angy.service.PatientService;

public class PatientServiceImpl implements PatientService {
	/**
	 * 持有一个数据访问对象
	 */
	//接口与接口的实现类，类似于子类继承父类
	private PatientDao patientDao = new PatientDao4MySQL();//多态：父类的引用指向子类对象
	@Override
	public PageModel getPatientByQueryInformation(QueryInformation queryInfo) {
		
		//将查询信息QueryInformation类中的get方法作为dao接口实现类中的参数
		//获得当前页码的查询结果作为QueryResult类的对象
		QueryResult qr = patientDao.obtainCurrentPageData(queryInfo.getStartIndex(), queryInfo.getPageSize());
		
		//getStartIndex();参数
		//getPageSize();参数
		
		//getPageNumber();
		//getPageSize();
		//getPatientList();
		//getTotalRecordAmount();
		PageModel pm = new PageModel();
		pm.setPageNumber(queryInfo.getPageNumber());
		pm.setPageSize(queryInfo.getPageSize());
		pm.setPatientList(qr.getPatientList());
		pm.setTotalRecordAmount(qr.getTotalRecordAmount());
		
		return pm;
	}
	@Override
	public boolean deletePatientById(Integer patientId) {
		return patientDao.deletePatientById(patientId);
	}
	@Override
	public Patient getPatientById(Integer patientId) {
		return patientDao.getPatientById(patientId);
	}
	@Override
	public boolean updatePatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatientInfo(patient);
	}

	@Override
	public boolean addPatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.addPatientInfo(patient);
	}

}
