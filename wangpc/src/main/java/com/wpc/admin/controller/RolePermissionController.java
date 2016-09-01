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

import com.wpc.admin.entity.RolePermission;
import com.wpc.admin.service.RolePermissionService;
import com.wpc.common.AjaxResult;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/rolepermission")
public class RolePermissionController {
	
	@Resource(name=RolePermissionService.BEAN_ID)
	private RolePermissionService rolePermissionService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String rolePermission(ModelMap model) {
		return "admin/rolepermission/role_permission";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, RolePermission rolePermission) {
		AjaxResult ajaxResult = new AjaxResult();
		if(rolePermission.getId()!=null && rolePermission.getId()!=0){
			rolePermissionService.update(rolePermission);
		}else{
			rolePermissionService.save(rolePermission);
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
		rolePermissionService.delete(id);
		return ajaxResult;
	}
	
	

}
