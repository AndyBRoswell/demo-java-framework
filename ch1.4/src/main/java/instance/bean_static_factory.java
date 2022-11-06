package instance;

public class bean_static_factory {
	private static final bean_class instance = new bean_class("Instantiate bean with static factory method");
	public static bean_class get_instance() {
		return instance;
	}
}
