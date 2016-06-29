/**
 * 文件名：MyDemoServiceImpl.java
 *
 * 描述：此处填写文件的描述信息
 * 
 * 日期：2016年5月4日
 * 
 * 本系统是商用软件，未经授权擅自复制或传播本程序的部分或全部将是非法的
 *
 * Copyright(C) WEAVER Corporation 2016 
 *
 */
package com.wpc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpc.mapper.MyDemoMapper;
import com.wpc.service.MyDemoService;

/**
 * <dl>  Class Description
 *  <dd> 项目名称：springmvc
 *  <dd> 类名称：MyDemoServiceImpl
 *  <dd> 类描述：概述类的作用
 *  <dd> 创建人：王鹏程
 *  <dd> 创建时间：2016年5月4日 下午5:15:45
 *  <dd> 修改人：无
 *  <dd> 修改时间：无
 *  <dd> 修改备注：无
 * </dl>
 * @author weaver
 * @see
 * @version 1.0
 * 
 */
@Service("myDemoService")
public class MyDemoServiceImpl implements MyDemoService {

  @Autowired
  private MyDemoMapper myDemoMapper;

  @Override
  public int selectCount() {
    return myDemoMapper.selectCount();
  }
  
}
