package com.wpc.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@RequestMapping(value = "/cp")
public class CompanyController {

	/** 
     * updatecs 
     */  
    @RequiresPermissions("cp:updatecs")  
    @RequestMapping(value="/updatecs",method=RequestMethod.GET)  
    public String updatecs(){  
        System.err.println("成功1");  
        return "index";  
    }  
    /** 
     * updatecs 
     */  
    @RequiresPermissions("cp:updatecs1")  
    @RequestMapping(value="/updatecs1",method=RequestMethod.GET)  
    public String updatecs1(){  
        System.err.println("成功2");  
        return "index";  
    }  
      
    /** 
     * updatecs   这个我没用给当前用户添加权限  是会提示无权限的 
     */  
    @RequiresPermissions("cp:updatecs2")  
    @RequestMapping(value="/updatecs2",method=RequestMethod.GET)  
    public String updatecs2(){  
//      System.err.println("失败");  
        return "index";  
    }
    
}
