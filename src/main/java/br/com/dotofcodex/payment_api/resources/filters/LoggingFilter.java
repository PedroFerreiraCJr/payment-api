package br.com.dotofcodex.payment_api.resources.filters;

import java.io.IOException;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
@Priority(Integer.MIN_VALUE)
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private final static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Context
	private HttpServletRequest servletRequest;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		logger.info("new response");
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.info("new request");
		String ip = servletRequest.getRemoteAddr();
		logger.info(ip);
		/*
		 * if (!"".equals(ip)) {
		 * requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build(
		 * )); }
		 */
	}

}
