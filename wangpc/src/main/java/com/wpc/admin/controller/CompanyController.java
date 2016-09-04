package com.wpc.admin.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping(value = "/cp")
public class CompanyController {

	// 登录成功的页面
    @RequestMapping(value = "/admin/home")
    @ResponseBody
    public String adminHomePage(){
        return "admin/home";
    }

    // 只有角色为admin的才能访问
    @RequiresRoles("admin")
    @RequestMapping(value = "/admin/role")
    @ResponseBody
    public String adminWithRole(){
        return "admin/withrole";
    }

    // 只用同时具有user:view和user:create权限才能访问
    @RequiresPermissions(value={"user:view","user:create"}, logical= Logical.AND)
    @RequestMapping(value = "/admin/auth")
    @ResponseBody
    public String adminWithAuth(){
        return "admin/withauth";
    }
    
}
