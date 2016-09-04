package com.wpc.admin.entity;

import java.io.Serializable;

/**
*  实体类
* author wpc
*/
public class AuthElement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String elementName;
	/**
	 * 
	 */
	private String elementCode;
	
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	
	public void setElementName(String elementName){
		this.elementName=elementName;
	}
	public String getElementName(){
		return this.elementName;
	}
	
	public void setElementCode(String elementCode){
		this.elementCode=elementCode;
	}
	public String getElementCode(){
		return this.elementCode;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("AuthElement[");
		sb.append("id=");
		sb.append(id);
		sb.append(",elementName=");
		sb.append(elementName);
		sb.append(",elementCode=");
		sb.append(elementCode);
		sb.append("]");
		return sb.toString();
	}
}
