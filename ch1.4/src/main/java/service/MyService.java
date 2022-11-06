package service;

public class MyService {
	public MyService() {
		System.out.println("Execute MyService.MyService()");
	}
	public void init() {
		System.out.println("Init service");
	}
	public void destroy() {
		System.out.println("Destroy service");
	}
}
