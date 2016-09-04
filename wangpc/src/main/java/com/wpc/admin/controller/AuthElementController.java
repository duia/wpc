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

import com.wpc.admin.entity.AuthElement;
import com.wpc.admin.service.AuthElementService;
import com.wpc.common.AjaxResult;


/**
 *  控制层
 * author wpc
 */
@Controller
@RequestMapping("/authelement")
public class AuthElementController {
	
	@Resource(name=AuthElementService.BEAN_ID)
	private AuthElementService authElementService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping
	public String authElement(ModelMap model) {
		return "admin/authelement/auth_element";
	}
	
	/**
	 * 保存或更新
	 */
	@RequestMapping(value="/addOrUpdate", method=RequestMethod.POST)
	@ResponseBody
	public AjaxResult addOrUpdate(ModelMap model, AuthElement authElement) {
		AjaxResult ajaxResult = new AjaxResult();
		if(authElement.getId()!=null && authElement.getId()!=0){
			authElementService.update(authElement);
		}else{
			authElementService.save(authElement);
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
		authElementService.delete(id);
		return ajaxResult;
	}
	
	

}
