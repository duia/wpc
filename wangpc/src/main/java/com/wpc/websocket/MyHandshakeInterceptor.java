/**
 * 文件名：HandshakeInterceptor.java
 *
 * 描述：此处填写文件的描述信息
 * 
 * 日期：2016年6月8日
 * 
 * 本系统是商用软件，未经授权擅自复制或传播本程序的部分或全部将是非法的
 *
 * Copyright(C) WEAVER Corporation 2016 
 *
 */
package com.wpc.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;

/**
 * <dl>  Class Description
 *  <dd> 项目名称：springmvc
 *  <dd> 类名称：HandshakeInterceptor
 *  <dd> 类描述：概述类的作用
 *  <dd> 创建人：王鹏程
 *  <dd> 创建时间：2016年6月8日 下午2:53:00
 *  <dd> 修改人：无
 *  <dd> 修改时间：无
 *  <dd> 修改备注：无
 * </dl>
 * @author weaver
 * @see
 * @version 1.0
 * 
 */
public class MyHandshakeInterceptor implements org.springframework.web.socket.server.HandshakeInterceptor {

  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Exception exception) {
    // TODO Auto-generated method stub
    
  }

  //进入hander之前的拦截
  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler,
      Map<String, Object> map) throws Exception {
    if (request instanceof ServletServerHttpRequest) {
      ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
      HttpSession session = servletRequest.getServletRequest().getSession(false);
      String userName = "xq";
      if (session != null) {
          //使用userName区分WebSocketHandler，以便定向发送消息
//          String userName = (String) session.getAttribute("WEBSOCKET_USERNAME");
          map.put("WEBSOCKET_USERNAME",userName);
      }
    }
    return true;
  }

}
