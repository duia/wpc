package com.wpc.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.wpc.admin.dao.AuthPermissionDao;
import com.wpc.admin.dao.AuthRoleDao;
import com.wpc.admin.dao.UserDao;
import com.wpc.admin.entity.AuthPermission;
import com.wpc.admin.entity.AuthRole;
import com.wpc.admin.entity.User;

public class ShiroRealm extends AuthorizingRealm {

	@Resource(name=UserDao.BEAN_ID)
	private UserDao userDao;
	@Resource(name=AuthRoleDao.BEAN_ID)
	private AuthRoleDao authRoleDao;
	@Resource(name=AuthPermissionDao.BEAN_ID)
	private AuthPermissionDao authPermissionDao;
	
	/* 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
        // 根据用户配置用户与权限  
        if (principals == null) {  
            throw new AuthorizationException(  
                    "PrincipalCollection method argument cannot be null.");  
        }  
        String username = (String) getAvailablePrincipal(principals);  
        List<String> roles = new ArrayList<String>();
        List<String> permissions = new ArrayList<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        if ("admin".equals(username)) {  
        	for (AuthRole authRole : authRoleDao.queryAll()) {
        		roles.add(authRole.getRoleCode());
			}
        	for (AuthPermission authPermission : authPermissionDao.queryAll()) {
        		permissions.add(authPermission.getPermissionCode());
			}
        } else {
        	// 从数据库中获取用户
            User user = userDao.getUserByAccount(username);
            // 根据用户名查询出用户 判断用户信息的有效性 然获取用户的角色权限 授权 
//            for (AuthRole authRole : authRoleDao.queryRoleByUserId(user.getId())) {
//        		roles.add(authRole.getRoleCode());
//        		for (AuthPermission authPermission : authPermissionDao.queryPermissionByRoleId(authRole.getId())) {
//        			permissions.add(authPermission.getPermissionCode());
//				}
//			}
            permissions.add("data_dep1_user2");
        }
        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;  
    }  
  
    /* 
     * 认证回调函数,登录时调用. 获取认证信息
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        // 从数据库中获用户.......
        User user = userDao.getUserByAccount(token.getUsername());  
//        User user = new User("shiro", "123456");  
        if (user == null) {  
            return null;  
        }
        SimpleAuthenticationInfo info = null;  
        if (user.getUsername().equals(token.getUsername())) {  
            info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());  
        }  
        return info;  
    }

}
