/**
 * 
 */
package com.huashukang.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author liubin
 * @version 1.0.0
 *          <p>
 *          跨域过滤器，保证返回的 Response 可以被主流浏览器识别展示
 *          </p>
 * 
 *
 */
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		// 如果浏览器发送 OPTIONS 则将response 状态设置为 200 OK，对浏览器表示友好
		if (requestContext.getRequest().getMethod().equals("OPTIONS")) {
//			responseContext.setStatusInfo(Response.Status.OK);
			responseContext.setEntity("200 OK");
		}

		// 同意浏览器跨越访问
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//		headers.add("Access-Control-Allow-Headers", "UserCode,UserGUID,Content-Type,Access-Token,x-requested-with");
		headers.add("Access-Control-Allow-Headers", "*");
	}

}
