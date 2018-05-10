/**
 * 
 */
package com.huashukang.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huashukang.system.config.DBConfig;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author liubin
 *
 */
@Component
public class OracleConnection {

	@Autowired
	DBConfig dbConfig;

	private Connection conn = null;	

	public Connection dbConnection() {

		if (conn == null) {
			OracleDriver.getCompileTime();
			try {
				conn = DriverManager.getConnection(dbConfig.getConnectionStr(), dbConfig.getUsername(),
						dbConfig.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return conn;
	}
}
