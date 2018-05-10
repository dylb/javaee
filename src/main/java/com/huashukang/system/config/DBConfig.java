/**
 * 
 */
package com.huashukang.system.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

/**
 * @author liubin
 *
 */
@Component
public class DBConfig {
	
	private String ip;
	private String port;
	private String sid;
	private String username;
	private String password;

	public DBConfig() {
		Properties pro = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config/DBConfig.properties");
		try {
			pro.load(inputStream);
			ip = pro.getProperty("ip");
			port=pro.getProperty("port","1599");
			sid=pro.getProperty("SID","orcl");
			username=pro.getProperty("Username");
			password=pro.getProperty("Password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getConnectionStr() {
		return "jdbc:oracle:thin:@"+ip+":"+port+":"+sid;		
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

}
