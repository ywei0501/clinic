package edu.angy.dao;

import edu.angy.entity.Patient;
import edu.angy.entity.QueryResult;

/**
 * 封装Patient数据访问操作
 * @author 湖南工业大学 
 */
public interface PatientDao {
	
	/**
	 * 获取指定页码数据
	 * @param startIndex 开始索引
	 * @param pageSize 当前页记录条数
	 * @return 查询结果
	 */
	//obtain:获得； current:现在的； page:页码； data:数据
	QueryResult obtainCurrentPageData(Integer startIndex , Integer pageSize);//使用类名定义接口
	
	
	/**
	 * 删除指定编号的患者记录
	 * @param patientId 患者编号
	 * @return true 成功  false 失败
	 */
	boolean deletePatientById(Integer patientId);
	
	
	/**
	 * 根据指定编号加载患者信息
	 * @param patientId 患者编号
	 * @return 患者
	 */
	Patient getPatientById(Integer patientId);
	
	
	/**
	 * 更新患者信息
	 * @param patient 患者
	 * @return true 成功  false 失败
	 */
	boolean updatePatientInfo(Patient patient);
	
	/**
	 * 添加患者信息
	 * @param patient 患者
	 * @return true 成功 false 失败
	 */
	boolean addPatientInfo(Patient patient);

}


