package com.wpc.shiro;

import java.util.ArrayList;
import java.util.List;

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

import com.wpc.admin.entity.User;

public class ShiroRealm extends AuthorizingRealm {

	/* 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(  
            PrincipalCollection principals) {  
        // 根据用户配置用户与权限  
        if (principals == null) {  
            throw new AuthorizationException(  
                    "PrincipalCollection method argument cannot be null.");  
        }  
        String name = (String) getAvailablePrincipal(principals);  
        List<String> roles = new ArrayList<String>();  
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);  
        // 根据用户名查询出用户 判断用户信息的有效性 然获取用户的角色权限 授权  
        User user = new User("shiro", "123456");  
        if (user.getUsername().equals(name)) {  
            // 模拟三个角色  
            for (int x = 0; x < 3; x++) {  
                roles.add("user" + x);  
            }  
        } else {  
            throw new AuthorizationException();  
        }  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 增加角色  
        // 取出所有角色授权  
        info.addRoles(roles);  
        // 取出所有权限授权  
        // info.addStringPermissions(permissions);  
        // 模拟拥有的权限  
        info.addStringPermission("cp:updatecs,updatecs1");  
        return info;  
    }  
  
    /* 
     * 认证登录 
     */  
    @SuppressWarnings("unused")  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken authcToken) throws AuthenticationException {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        // 简单默认一个用户,实际项目应User user =  
        // userService.getByAccount(token.getUsername());  
        User user = new User("shiro", "123456");  
        if (user == null) {  
            throw new AuthorizationException();  
        }  
        SimpleAuthenticationInfo info = null;  
        if (user.getUsername().equals(token.getUsername())) {  
            info = new SimpleAuthenticationInfo(user.getUsername(),  
                    user.getPassword(), getName());  
        }  
        return info;  
    }

}
