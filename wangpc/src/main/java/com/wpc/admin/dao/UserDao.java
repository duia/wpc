package com.wpc.admin.dao;

import com.wpc.admin.entity.User;
import com.wpc.common.BaseDao;
/**
 * 操作相关
 * author wpc
 */
public interface UserDao extends BaseDao<User, Integer> {
	
	public final static String BEAN_ID="userDao";
	
	public User getUserByAccount(String account);
	
}
