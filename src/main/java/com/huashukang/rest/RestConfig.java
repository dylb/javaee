/**
 * 
 */
package com.huashukang.rest;

import org.glassfish.jersey.server.ResourceConfig;

import com.huashukang.rest.filter.AuthFilter;
import com.huashukang.rest.filter.CORSFilter;
import com.huashukang.rest.service.Service;

/**
 * @author liubin
 *
 */
public class RestConfig extends ResourceConfig {

	public RestConfig() {
		// 注册顺序
		
		// 1: 异常拦截器
		register(ExceptionHandler.class, 100);
		// 2: 用户认证拦截器
		register(AuthFilter.class, 200);
		// 3: 跨域过滤器
		register(CORSFilter.class, 300);
		// 4: REST服务
		register(Service.class, 1000);
		
		
	}

}
