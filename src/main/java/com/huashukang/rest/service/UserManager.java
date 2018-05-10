package com.huashukang.rest.service;

import javax.ws.rs.container.ContainerRequestContext;
import org.springframework.stereotype.Component;

//import com.sun.jersey.spi.container.ContainerRequest;

/**
 * @author liubin
 * 
 *
 */
@Component
public class UserManager { 

	public boolean check(ContainerRequestContext requestContext) {
		if (requestContext == null)
			return false;
		
		String userCode = requestContext.getHeaderString("UserCode");
		String userGUID = requestContext.getHeaderString("UserGUID");

		if ((userCode == null) || (userGUID == null))
			return false;

		if ((userCode.equals("hsk001")) && (userGUID.equals("ABC"))) {
			return true;
		} else {
			return false;
		}
	}
}
