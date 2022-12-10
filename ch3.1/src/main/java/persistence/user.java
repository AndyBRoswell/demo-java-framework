package persistence;

public class user {
	Long id;
	String name;
	String sex;
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}
	public String toString() {
		return "user[id = " + id + ", name = " + name + ", sex = " + sex + "]";
	}
}
