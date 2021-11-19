/**
 * SessionFilter
 * 
 * @author shaziyahasan
 *
 * Filter for redirection handling
 */

package com.nagarro.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class SessionFilter implements Filter {
	private ArrayList<String> urlList;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String url = httpRequest.getServletPath();
		boolean allowedRequest = false;

		if (urlList.contains(url)) {
			allowedRequest = true;
		}

		if (!allowedRequest) {
			HttpSession session = httpRequest.getSession(false);
			if (null == session) {
				httpResponse.sendRedirect("login");
			}
		}
		
		filterchain.doFilter(httpRequest, httpResponse);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");

		urlList = new ArrayList<String>();

		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());

		}
	}
}
