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

import com.wpc.admin.entity.AuthPermission;
import com.wpc.admin.service.AuthPermissionService;
import com.wpc.common.AjaxResult;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/authpermission")
public class AuthPermissionController {
	
	@Resource(name=AuthPermissionService.BEAN_ID)
	private AuthPermissionService authPermissionService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String authPermission(ModelMap model) {
		return "admin/authpermission/auth_permission";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, AuthPermission authPermission) {
		AjaxResult ajaxResult = new AjaxResult();
		if(authPermission.getId()!=null && authPermission.getId()!=0){
			authPermissionService.update(authPermission);
		}else{
			authPermissionService.save(authPermission);
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
		authPermissionService.delete(id);
		return ajaxResult;
	}
	
	

}
