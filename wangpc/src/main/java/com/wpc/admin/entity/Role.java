package com.wpc.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
*  实体类
* author wpc
*/
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String roleName;
	/**
	 * 
	 */
	private Date updateTime;
	
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	
	public void setRoleName(String roleName){
		this.roleName=roleName;
	}
	public String getRoleName(){
		return this.roleName;
	}
	
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return this.updateTime;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Role[");
		sb.append("id=");
		sb.append(id);
		sb.append(",roleName=");
		sb.append(roleName);
		sb.append(",updateTime=");
		sb.append(updateTime);
		sb.append("]");
		return sb.toString();
	}
}
