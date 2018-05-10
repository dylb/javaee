/**
 * 
 */
package com.huashukang.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

/**
 * @author liubin
 *
 */
@Component
public class Oracle extends OracleConnection {

	public void testDB() throws SQLException {
		Connection con = dbConnection();
		if (con == null) {
			System.out.println("数据库开启失败");
			return;
		}
		Statement sql = con.createStatement();
		ResultSet rs = sql.executeQuery("Select * from T_sys_user where rownum < 10 ");
        while (rs.next()) {
        	String un=rs.getString("USER_NAME");
        	System.out.println(un);
        }
	}
}
