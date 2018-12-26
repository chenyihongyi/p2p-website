package com.xmg.p2p.base.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * @Author Elvis Chen
 * @Date 2018/12/26 22:40
 * @Version 1.0
 **/
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		//判断登陆逻辑
        if(handler instanceof HandlerMethod){
            HandlerMethod hm =(HandlerMethod) handler;
            RequireLogin rl = hm.getMethodAnnotation(RequireLogin.class);
            if(rl!=null && UserContext.getCurrent()==null){
                response.sendRedirect("/login.html");
                return false;
            }
        }
		return super.preHandle(request, response, handler);
	}
	
}
