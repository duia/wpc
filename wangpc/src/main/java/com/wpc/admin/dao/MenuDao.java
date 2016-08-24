package com.wpc.admin.dao;

import com.wpc.admin.entity.Menu;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface MenuDao extends BaseDao<Menu, Integer> {
	
	public final static String BEAN_ID="menuDao";
	
}
