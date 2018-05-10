/**
 * 
 */
package com.huashukang.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;

import com.huashukang.db.Oracle;
import com.huashukang.db.OracleConnection;

/**
 * @author liubin
 *
 */
public class InitializeListener extends HskBaseListener {

	private OracleConnection oc;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		super.contextInitialized(sce);
//		oc = springContainer.getBean(OracleConnection.class);
//
//		if (oc == null) {
//			System.out.println("oc is null OK");
//		} else {
//			System.out.println("oc is not null");
//			oc.dbConnection();
//		};
//		
		Oracle o= springContainer.getBean(Oracle.class);
		try {
			o.testDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(this.getClass().getResource("/"));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
