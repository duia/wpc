package com.wpc.admin.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpc.admin.entity.User;
import com.wpc.admin.service.UserService;
import com.wpc.common.AjaxResult;


/**
 * 
 * author wpc
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name=UserService.BEAN_ID)
	private UserService userService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String user(ModelMap model) {
		return "admin/user/user";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, User user) {
		AjaxResult responseJsonModel = new AjaxResult();
		if(user.getId()!=null && user.getId()!=0){
			userService.update(user);
		}else{
			userService.save(user);
		}
		return responseJsonModel;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(ModelMap model, Integer id) {
		AjaxResult responseJsonModel = new AjaxResult();
		userService.delete(id);
		return responseJsonModel;
	}
	
	

}
