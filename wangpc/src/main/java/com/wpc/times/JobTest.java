/**
 * 文件名：JobTest.java
 *
 * 描述：此处填写文件的描述信息
 * 
 * 日期：2016年5月3日
 * 
 * 本系统是商用软件，未经授权擅自复制或传播本程序的部分或全部将是非法的
 *
 * Copyright(C) WEAVER Corporation 2016 
 *
 */
package com.wpc.times;

import java.util.List;

import org.quartz.Scheduler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <dl>  Class Description
 *  <dd> 项目名称：springmvc
 *  <dd> 类名称：JobTest
 *  <dd> 类描述：概述类的作用
 *  <dd> 创建人：王鹏程
 *  <dd> 创建时间：2016年5月3日 上午10:09:58
 *  <dd> 修改人：无
 *  <dd> 修改时间：无
 *  <dd> 修改备注：无
 * </dl>
 * @author weaver
 * @see
 * @version 1.0
 * 
 */
//@Component
public class JobTest implements InitializingBean {

  @Autowired
  private Scheduler scheduler;
  
  public Scheduler getScheduler() {
    return scheduler;
  }

  public void setScheduler(Scheduler scheduler) {
    this.scheduler = scheduler;
  }

  /**
   * <b>Overriding Method afterPropertiesSet</b>
   * <dd>方法作用：(这里用一句话描述这个方法的作用)
   * @throws Exception 
   * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
   * @since Met 1.0
   */
  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub

    //这里获取任务信息数据
    List<ScheduleJob> jobList = DataWorkContext.getAllJob();
    for (ScheduleJob job : jobList) {
      SchedulerUtil.addJob(scheduler, job);
    }
//    ScheduleJob scheduleJob = DataWorkContext.getJob("dataWork_data_import3");
//    SchedulerUtil.pauseJob(scheduler, scheduleJob);
    
  }
  
}
