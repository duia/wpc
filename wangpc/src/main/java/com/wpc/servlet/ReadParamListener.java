package com.wpc.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.wpc.util.ParameterUtil;
import com.wpc.util.entity.Parameter;

@WebListener(value="ReadParamListener")
public class ReadParamListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ParameterUtil parameterUtil = new ParameterUtil();
		parameterUtil.autoEvalVal();
	}

}
