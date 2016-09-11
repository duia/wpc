package com.wpc.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
*  实体类
* author wpc
*/
public class AuthMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private String icon;
	/**
	 * 
	 */
	private Integer pId;
	/**
	 * 
	 */
	private Integer isActive;
	private Integer sortNum;
	/**
	 * 
	 */
	private Date updateTime;
	
	private List<AuthMenu> children;
	
	private List<AuthElement> elements;
	
	public List<AuthMenu> getChildren() {
		return children;
	}
	public void setChildren(List<AuthMenu> children) {
		this.children = children;
	}
	public List<AuthElement> getElements() {
		return elements;
	}
	public void setElements(List<AuthElement> elements) {
		this.elements = elements;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setUrl(String url){
		this.url=url;
	}
	public String getUrl(){
		return this.url;
	}
	
	public void setIcon(String icon){
		this.icon=icon;
	}
	public String getIcon(){
		return this.icon;
	}
	
	public void setPId(Integer pId){
		this.pId=pId;
	}
	public Integer getPId(){
		return this.pId;
	}
	
	public void setIsActive(Integer isActive){
		this.isActive=isActive;
	}
	public Integer getIsActive(){
		return this.isActive;
	}
	
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return this.updateTime;
	}
	
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Menu[");
		sb.append("id=");
		sb.append(id);
		sb.append(",name=");
		sb.append(name);
		sb.append(",url=");
		sb.append(url);
		sb.append(",icon=");
		sb.append(icon);
		sb.append(",pId=");
		sb.append(pId);
		sb.append(",isActive=");
		sb.append(isActive);
		sb.append(",sortNum=");
		sb.append(sortNum);
		sb.append(",updateTime=");
		sb.append(updateTime);
		sb.append("]");
		return sb.toString();
	}
}
