/**
 * 文件名：WebSocketHander.java
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

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * <dl>
 * Class Description
 * <dd>项目名称：springmvc
 * <dd>类名称：WebSocketHander
 * <dd>类描述：概述类的作用
 * <dd>创建人：王鹏程
 * <dd>创建时间：2016年6月8日 下午2:54:41
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
public class MyWebSocketHander implements WebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyWebSocketHander.class);

	private static final ArrayList<WebSocketSession> users = new ArrayList<>();

	// 初次链接成功执行
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("链接成功......");
		users.add(session);
		String userName = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
		if (userName != null) {
			// 查询未读消息
			int count = 5;
			session.sendMessage(new TextMessage(count + ""));
		}
	}

	// 接受消息处理消息
	@Override
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)
					throws Exception {
		logger.info("分发消息......{}", webSocketMessage);
		sendMessageToUsers(new TextMessage(webSocketMessage.getPayload() + ""));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		logger.info("链接关闭......{}", closeStatus.toString());
		users.remove(webSocketSession);
	}

	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		logger.info("链接出错，关闭链接......");
		users.remove(webSocketSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 */
	public static void sendMessageToUsers(TextMessage message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 给某个用户发送消息
	 *
	 * @param userName
	 * @param message
	 */
	public void sendMessageToUser(String userName, TextMessage message) {
		for (WebSocketSession user : users) {
			if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
				try {
					if (user.isOpen()) {
						user.sendMessage(message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
