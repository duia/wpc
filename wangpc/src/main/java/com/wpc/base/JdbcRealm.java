package com.wpc.base;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 获取数据库的链接并指定数据库的schema
 * 
 * @author zhaolin
 * @version 1.0 2014/7/1
 */
public class JdbcRealm extends DriverManagerDataSource {

	@Override
	protected Connection getConnectionFromDriver(Properties props)
			throws SQLException {
		String url = getUrl();
		if (logger.isDebugEnabled()) {
			logger.debug("Creating new JDBC DriverManager Connection to ["+ url + "]");
		}
		Connection conn = getConnectionFromDriverManager(url, props);
		Statement stmt = conn.createStatement();

		try {
			props.load(JdbcRealm.class.getClassLoader().getResourceAsStream("config/cascade.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("JdbcRealm类配置DM连接模式时加载cascade.properties配置文件失败");
		}
		String schema = props.getProperty("dbSchema");
		stmt.execute(schema);
		stmt.close();

		return conn;
	}

}
