package instance;

public class bean_class {
	public String message;
	public bean_class() {
		message = "Instantiate bean with constructor";
	}
	public bean_class(String s) {
		message = s;
	}
}
