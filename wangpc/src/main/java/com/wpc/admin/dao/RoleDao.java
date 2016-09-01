package com.wpc.admin.dao;

import com.wpc.admin.entity.Role;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface RoleDao extends BaseDao<Role, Integer> {
	
	public final static String BEAN_ID="roleDao";
	
}
