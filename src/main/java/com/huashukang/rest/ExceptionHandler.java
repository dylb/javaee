/**
 * 
 */
package com.huashukang.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.NotFoundException;

/**
 * @author liubin
 * @param <Exception>
 *
 */
@Provider
public class ExceptionHandler<E> implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		// 捕获无效的 url
		if (e instanceof NotFoundException) {
			Response.ResponseBuilder responseBuilder = Response.status(Response.Status.UNAUTHORIZED).type("text/plain;charset=utf-8")
					.encoding("utf-8").entity("未找到 RESTful 对应的资源定位，请确认您提交的 url 是否正确？");
			return (responseBuilder.build());
		}

      // 打印未捕获到的异常信息
		e.printStackTrace();
		return null;
	}

}
