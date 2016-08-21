package com.wpc.admin.model;

import java.util.Date;

/**
 * 菜单实体
 * @author 鹏程
 *
 */
public class Menu {

	private int id;
	private String name;
	private String url;
	private String icon;
	private int pId;
	private int isActive;
	private Date updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", icon="
				+ icon + ", pId=" + pId + ", isActive=" + isActive
				+ ", updateTime=" + updateTime + "]";
	}
	
}
