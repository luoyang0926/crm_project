package com.yang.interceptor;

import com.yang.commons.contants.Contants;
import com.yang.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 如果用户没有登录成功，跳转到登录页面
        HttpSession session = httpServletRequest.getSession();
        User user =(User) session.getAttribute(Contants.SESSION_USER);
        if (user == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());//重定向时，url必须加项目名称
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
