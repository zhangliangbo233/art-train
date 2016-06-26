package com.suning.arttrain.common.util;

import java.util.List;

public class PageData<T> {

	/**
	 * 数据从条数
	 */
	private int total;
	
	/**
	 * 当前页显示的数据
	 */
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
