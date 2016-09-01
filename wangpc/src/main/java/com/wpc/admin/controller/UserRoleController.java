package com.wpc.admin.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wpc.admin.entity.UserRole;
import com.wpc.admin.service.UserRoleService;
import com.wpc.common.AjaxResult;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/userrole")
public class UserRoleController {
	
	@Resource(name=UserRoleService.BEAN_ID)
	private UserRoleService userRoleService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String userRole(ModelMap model) {
		return "admin/userrole/user_role";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, UserRole userRole) {
		AjaxResult ajaxResult = new AjaxResult();
		if(userRole.getId()!=null && userRole.getId()!=0){
			userRoleService.update(userRole);
		}else{
			userRoleService.save(userRole);
		}
		return ajaxResult;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(ModelMap model, Integer id) {
		AjaxResult ajaxResult = new AjaxResult();
		userRoleService.delete(id);
		return ajaxResult;
	}
	
	

}
