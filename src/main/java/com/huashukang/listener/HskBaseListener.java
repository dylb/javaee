/**
 * 
 */
package com.huashukang.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <p>
 * 华数康 Listener 基类，为后续子类提供 springContainer 容器实例  
 * </p>
 * 
 * @author liubin
 *
 */
public class HskBaseListener implements ServletContextListener {
	
	

	protected WebApplicationContext springContainer;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		springContainer = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
