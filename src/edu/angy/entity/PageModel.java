package edu.angy.entity;

import java.util.List;

/**
 * 封装JSP页面所需要的全部数据
 * @author 湖南工业大学 
 */
public class PageModel {
	/**
	 * 当前显示页码
	 */
	private Integer pageNumber;
	/**
	 * 每页记录条数(大小)
	 */
	private Integer pageSize;
	/**
	 * 患者结果集
	 */
	private List<Patient> patientList;
	/**
	 * 总患者记录条数
	 */
	private Integer totalRecordAmount;
	/**
	 * 上一页页码 
	 */
	private Integer previousPageNumber;
	/**
	 * 下一页页码 
	 */
	private Integer nextPageNumber;
	/**
	 * 页码条 
	 */
	private Integer[] pageNumberBar;
	/**
	 * 总页码数
	 */
	private Integer totalPageNumber;
	// ----------setter/getter---------------
	
	        //getStartIndex();参数，不在该类中
			//getPageSize();参数
			
			//getPageNumber();
			//getPageSize();
			//getPatientList();
			//getTotalRecordAmount();
	
	public Integer getPageNumber() {//已获得
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {//已获得
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<Patient> getPatientList() {//已获得
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	public Integer getTotalRecordAmount() {//已获得
		return totalRecordAmount;
	}
	public void setTotalRecordAmount(Integer totalRecordAmount) {
		this.totalRecordAmount = totalRecordAmount;
	}
	
	//--------------------
	public Integer getPreviousPageNumber() {
		if(getPageNumber() - 1 >= 1) {
			previousPageNumber = getPageNumber() - 1;
		}else {
			previousPageNumber = getPageNumber();
		}
		return previousPageNumber;
	}
	
	public Integer getNextPageNumber() {
		if(getPageNumber() +1 > getTotalPageNumber()) {
			nextPageNumber = getTotalPageNumber();
		}else {
			nextPageNumber = getPageNumber() +1;
		}
		return nextPageNumber;
	}
	
	
	public Integer[] getPageNumberBar() {
		pageNumberBar = new Integer[ getTotalPageNumber()];
		for(int i = 0 ; i < getTotalPageNumber() ; i++) {
			pageNumberBar[i] = i + 1;
		}
		return pageNumberBar;
	}
	public Integer getTotalPageNumber() {
		
		totalPageNumber = 
				totalRecordAmount % pageSize == 0 
				? totalRecordAmount / pageSize : 
					(totalRecordAmount / pageSize) + 1;
		
		return totalPageNumber;
	}
	
	
	
	
}
