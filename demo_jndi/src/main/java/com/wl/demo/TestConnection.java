package com.wl.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * tomcat:
 * 服务器需要添加对应jdni的配置
 * 在context.xml中添加如下配置:
 * <Resource name="jdbc/myoracle" auth="Container"
 *    type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
 *    url="jdbc:oracle:thin:@192.168.100.9:1521:design"
 *    username="mlp_corpus_v3" password="password" maxTotal="20" maxIdle="10"
 *    maxWaitMillis="-1"/>
 * @author wl
 *
 */
public class TestConnection extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 测试使用jndi拿到数据库连接,需要在服务器启动的情况下
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			System.out.println(conn);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
