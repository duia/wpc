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

import com.wpc.admin.entity.AuthRole;
import com.wpc.admin.service.AuthRoleService;
import com.wpc.common.AjaxResult;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/authrole")
public class AuthRoleController {
	
	@Resource(name=AuthRoleService.BEAN_ID)
	private AuthRoleService authRoleService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String authRole(ModelMap model) {
		return "admin/authrole/auth_role";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, AuthRole authRole) {
		AjaxResult ajaxResult = new AjaxResult();
		if(authRole.getId()!=null && authRole.getId()!=0){
			authRoleService.update(authRole);
		}else{
			authRoleService.save(authRole);
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
		authRoleService.delete(id);
		return ajaxResult;
	}
	
	

}
