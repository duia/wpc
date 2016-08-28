package com.wpc.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wpc.admin.entity.User;

@Controller  
@RequestMapping(value = "/login")
public class LoginController {

	/*****************测试shiro************************************/  
    
    @RequestMapping
    public String login() {
    	System.out.println("=========");
        return "login";  
    }  
  
    @RequestMapping(value = "/submit", method = RequestMethod.POST)  
    public String submitcs(String username, String password) {  
        User user = new User("shiro", "123456");  
        try {  
            // 如果登陆成功  
            if (user.getUsername().equals(username)  
                    && user.getPassword().equals(password)) {
            	System.out.println("验证通过");
                UsernamePasswordToken token = new UsernamePasswordToken(  
                        user.getUsername(), user.getPassword().toString());  
                Subject subject = SecurityUtils.getSubject();  
                subject.login(token);  
                return "redirect:/";  
            } else {
            	System.out.println("验证不通过");
                return "login";  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            return "login";  
        }  
  
    }
    
}
