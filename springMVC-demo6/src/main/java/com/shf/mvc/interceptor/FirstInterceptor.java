package com.shf.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FirstInterceptor implements HandlerInterceptor {
//    preHandle：控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，
//    返回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor  preHandle");
        return true;
    }

//    postHandle：控制器方法执行之后执行postHandle()
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor  postHandle");
    }

//    afterComplation：处理完视图和模型数据，渲染视图完毕之后执行afterComplation()
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor  afterCompletion");
    }
}
