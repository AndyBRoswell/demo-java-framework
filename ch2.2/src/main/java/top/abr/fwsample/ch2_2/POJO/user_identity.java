package top.abr.fwsample.ch2_2.POJO;

public class user_identity {
	public enum error {
		// common
		no_error,
		empty_user_name,
		empty_password,

		// register
		empty_confirm_password,
		existent_user,
		confirm_password_inconsistent,

		// login
		nonexistent_user,
		incorrect_password,
	}

	private String Name;
	private String Password;
	private String ConfirmPassword;

	public String getName() {return Name;}
	public void setName(String name) {this.Name = name;}
	public String getPassword() {return Password;}
	public void setPassword(String password) {this.Password = password;}
	public String getConfirmPassword() {return ConfirmPassword;}
	public void setConfirmPassword(String confirm_password) {this.ConfirmPassword = confirm_password;}
}
