package com.wpc.common;

import java.io.Serializable;
import java.util.List;

/**
 * 搭配jquery.datatable.js使用的返回前端的数据对象封装类
 * @author 鹏程
 *
 */
public class DataTableResult<T extends Serializable> {

	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private List<T> data;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
