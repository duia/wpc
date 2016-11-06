package com.wpc.admin.service;

import com.wpc.admin.entity.AuthPermission;
import com.wpc.common.BaseService;

/**
 * 操作相关
 * author wpc
 */
public interface AuthPermissionService extends BaseService<AuthPermission, Integer> {
	
	public final static String BEAN_ID="authPermissionService";
	
	public static String PER_TYPE_MENU = "menu";
	public static String PER_TYPE_ELEMENT = "element";
	public static String PER_TYPE_FILE = "file";
	
	public static int OPERATION_COUNT = 4;
	
	public static String[] OPERATION_NAMES = {"查看", "保存", "修改" ,"删除"};
	public static String[] OPERATION_CODES = {"view", "save", "update", "delete"};
	
	
	/**
	 * 根据传来的资源为该资源添加默认的四种权限
	 * @param perType （菜单，按钮，文件）
	 * @param resourceId
	 * @param parentId
	 */
	public void addDefaultPermission(String perType, int resourceId, int parentId);
	
}
