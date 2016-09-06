package com.wpc.admin.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpc.admin.entity.User;
import com.wpc.admin.service.UserService;
import com.wpc.common.AjaxResult;
import com.wpc.common.DataTableResult;


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
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	@ResponseBody
	public DataTableResult<User> search(ModelMap model, Integer draw, Integer start, Integer length) {
		DataTableResult<User> dtr = new DataTableResult<User>();
		dtr.setDraw(draw);
		dtr.setRecordsTotal(57);
		dtr.setRecordsFiltered(57);
		List<User> list = new ArrayList<User>();
		User u = null;
		for (int i = 0; i < length; i++) {
			u = new User();
			u.setId(i);
			u.setUsername("admin"+i);
			u.setAccount("admin"+i);
			u.setPassword("123456");
			u.setAge((int)(Math.random()*50) + 1);
			u.setUpdateTime(new Date());
			list.add(u);
		}
		dtr.setData(list);
		return dtr;
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
