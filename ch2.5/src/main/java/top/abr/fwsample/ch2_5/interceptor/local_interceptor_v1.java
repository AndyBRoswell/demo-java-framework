package top.abr.fwsample.ch2_5.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class local_interceptor_v1 implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("local_interceptor_v1.preHandle方法执行中");
		return true; // 返回true表示继续向下执行，返回false表示中断后续操作
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model_and_view) throws Exception {
		System.out.println("local_interceptor_v1.postHandle方法执行中");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
		System.out.println("local_interceptor_v1.afterCompletion方法执行中");
	}
}
