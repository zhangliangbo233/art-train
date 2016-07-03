package com.suning.arttrain.common.util;

/**
 * 分页查询对象
 * @author zhanglb
 *
 */
public class Page {

	/**
	 * 每页条数
	 */
	private int pageSize;
	
	/**
	 * 查询开始条数
	 */
	private int pageIndex;

    public Page(){}
	
	public Page(int rows,int page){
		this.pageSize = rows;
		this.pageIndex = (page-1)*rows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}
	
}
