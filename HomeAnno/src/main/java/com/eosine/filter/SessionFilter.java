package com.eosine.filter;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.druid.support.logging.NoLoggingImpl;
import com.eosine.util.base.ConfigUtil;

/**
 * session 过滤的filter
 * 验证哪些资源需要session来访问 哪些资源不需要session来访问
 * 
 * @author Administrator
 *
 * @version 1.0
 */
public class SessionFilter implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SessionFilter.class);

	//需要过滤的目录
	private List<String> filterList = new ArrayList<String>();
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		//获得需要过滤的目录
		String filter = arg0.getInitParameter("filter");
		if(StringUtils.isNotEmpty(filter)){
			String[] strs = StringUtils.split(filter, ",");
			filterList.clear();
			for(String s: strs){
				filterList.add(s);
			}
		}
		
	}
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String servletPath = request.getServletPath();	//获得当前请求地址
		System.out.println("session");
		System.out.println(request.getSession().getAttribute("ConfigUtil.getSessionInfoName()"));
		System.out.println("session");
		for(String url : filterList){
			if(servletPath.indexOf(url) > -1){		//需要过滤
				logger.info("进入session过滤器->访问路径为:["+servletPath+"]");
				
				if(request.getSession().getAttribute("ConfigUtil.getSessionInfoName()") == null){
					
					request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
					request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
					return;
				}
				break;
			}
		}
		
		arg2.doFilter(request, response);
	}


}
