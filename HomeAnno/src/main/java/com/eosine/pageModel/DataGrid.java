package com.eosine.pageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * DataGrid 模型
 * 
 * @author Administrator
 *
 */
public class DataGrid {

	/**
	 * 记录总数
	 */
	private Long total = 0L;
	
	/**
	 * 数据列
	 */
	private List rows = new ArrayList<>();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
