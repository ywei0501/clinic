package edu.angy.entity;

import java.util.List;

/**
 * 封装查询结果
 * @author 湖南工业大学 
 */
public class QueryResult {
	/**
	 * 患者结果集
	 */
	private List<Patient> patientList;
	/**
	 * 总患者记录条数
	 */
	private Integer totalRecordAmount;
		
	// ----------setter/getter---------------
	public List<Patient> getPatientList() {
		return patientList;
	}
	public Integer getTotalRecordAmount() {
		return totalRecordAmount;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	public void setTotalRecordAmount(Integer totalRecordAmount) {
		this.totalRecordAmount = totalRecordAmount;
	}
	
	
	
}
