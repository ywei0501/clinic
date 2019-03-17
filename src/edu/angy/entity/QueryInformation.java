package edu.angy.entity;
/**
 * 封装客户查询信息
 * @author 湖南工业大学
 */
public class QueryInformation {
	/**
	 * 当前显示页码
	 */
	private Integer pageNumber;
	/**
	 * 每页记录条数(大小)
	 */
	private Integer pageSize;
	/**
	 * 记录起始索引位置
	 */
	private Integer startIndex;
	
	/**
	 * 构造器(构造方法、构造函数、构造子)
	 */
	public QueryInformation() {
		pageNumber = 1;
		pageSize = 5 ;
	}
	/**
	 * 带初始化参数的构造器(构造方法、构造函数、构造子)
	 * @param pageNumber 页码
	 * @param pageSize 每页可显示最大记录条数
	 */
	public QueryInformation(Integer pageNumber , Integer pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		
		
	}
	// ----------setter/getter---------------
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartIndex() {
		return (pageNumber - 1) * pageSize;
	}
}
