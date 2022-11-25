package top.abr.fwsample.ch2_5.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test_interceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle方法在控制器的处理请求方法前执行");
		return true; // 返回true表示继续向下执行，返回false表示中断后续操作
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model_and_view) throws Exception {
		System.out.println("postHandle方法在控制器的处理请求方法调用之后，解析视图之前执行");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
		System.out.println("postHandle方法在控制器的处理请求方法执行完成后执行，即视图渲染结束后执行");
	}
}
