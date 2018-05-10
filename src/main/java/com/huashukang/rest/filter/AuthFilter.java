/**
 * 
 */
package com.huashukang.rest.filter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huashukang.rest.service.UserManager;

/**
 * @author liubin
 */
public class AuthFilter implements ContainerRequestFilter { 

	@Context
	ServletContext servletContext;

	private UserManager userManager;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException { 

		if (userManager == null) {
			ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			userManager = applicationContext.getBean(UserManager.class);
		}
		if (userManager.check(requestContext)) {
			System.out.println("filter 检查 合法用户");
		} else {
			System.out.println("filter  检查 非法用户");
			Response.ResponseBuilder responseBuilder = Response.status(Response.Status.UNAUTHORIZED)
					.type("text/plain;charset=utf-8").entity("未授权用户，服务拒绝访问！");
			Response response = responseBuilder.build();
			requestContext.abortWith(response);
		}
	}

}
