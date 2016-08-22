package com.wpc.admin.dao;

import com.wpc.admin.entity.User;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 */
public interface UserDao extends BaseDao<User, Integer> {
	
	public final static String BEAN_ID="userDao";
	
}
