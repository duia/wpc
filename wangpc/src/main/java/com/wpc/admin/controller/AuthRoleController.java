package com.wpc.admin.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpc.admin.entity.AuthRole;
import com.wpc.admin.service.AuthRoleService;
import com.wpc.common.AjaxResult;
import com.wpc.common.datatables.DataTablesRequest;
import com.wpc.common.datatables.DataTablesResponse;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/role")
public class AuthRoleController {
	
	@Resource(name=AuthRoleService.BEAN_ID)
	private AuthRoleService authRoleService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String authRole(ModelMap model) {
		return "admin/auth/auth_role";
	}
	
	/**
	 *
	 * 分页查询列表
	 */
	@RequestMapping(value="/searchPage", method=RequestMethod.POST)
	@ResponseBody
	public DataTablesResponse<AuthRole> searchPage(ModelMap model, HttpServletRequest request, @RequestBody DataTablesRequest query) {
		return authRoleService.searchPage(query);
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
