/**
 * 文件名：IndexController.java
 *
 * 描述：此处填写文件的描述信息
 * 
 * 日期：2015年12月31日
 * 
 * 本系统是商用软件，未经授权擅自复制或传播本程序的部分或全部将是非法的
 *
 * Copyright(C) WEAVER Corporation 2015 
 *
 */
package com.wpc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpc.service.MyDemoService;
import com.wpc.times.DataWorkContext;
import com.wpc.times.ScheduleJob;
import com.wpc.times.SchedulerUtil;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：springmvc
 * <dd>类名称：IndexController
 * <dd>类描述：概述类的作用
 * <dd>创建人：王鹏程
 * <dd>创建时间：2015年12月31日 上午9:43:33
 * <dd>修改人：无
 * <dd>修改时间：无
 * <dd>修改备注：无
 * </dl>
 * 
 * @author weaver
 * @see
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/times")
public class TimesController {

	@Autowired
	private MyDemoService myDemoService;
	@Autowired
	private Scheduler scheduler;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) throws Exception {
		return "times/times";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		ScheduleJob job = new ScheduleJob();
		job.setJobId("10001" + 5);
		job.setJobName("data_import" + 5);
		job.setJobGroup("dataWork");
		job.setJobStatus("1");
		job.setCronExpression("0/4 * * * * ?");
		job.setDesc("数据导入任务");
		SchedulerUtil.addJob(scheduler, job);
	}

	@RequestMapping(value = "pause", method = RequestMethod.GET)
	public void pause(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		ScheduleJob scheduleJob = DataWorkContext.getJob("dataWork_data_import1");
		SchedulerUtil.pauseJob(scheduler, scheduleJob);
	}

	@RequestMapping(value = "resume", method = RequestMethod.GET)
	public void resume(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		ScheduleJob scheduleJob = DataWorkContext.getJob("dataWork_data_import1");
		SchedulerUtil.resumeJob(scheduler, scheduleJob);
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public void delete(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		ScheduleJob scheduleJob = DataWorkContext.getJob("dataWork_data_import2");
		SchedulerUtil.deleteJob(scheduler, scheduleJob);
	}

	@RequestMapping(value = "running", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleJob> running(HttpServletRequest request, HttpServletResponse response,
					ModelMap model) throws Exception {
		return SchedulerUtil.runningJob(scheduler);
	}

	@RequestMapping(value = "waiting", method = RequestMethod.GET)
	public @ResponseBody List<ScheduleJob> waiting(HttpServletRequest request, HttpServletResponse response,
					ModelMap model) throws Exception {
		return SchedulerUtil.waitingJob(scheduler);
	}

}
