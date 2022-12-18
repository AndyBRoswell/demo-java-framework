package persistence;

public class user {
	Long id;
	String name;
	String sex;
	public Long getId() {return id;}
	public void setId(final Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(final String name) {this.name = name;}
	public String getSex() {return sex;}
	public void setSex(final String sex) {this.sex = sex;}
	public boolean equals(final user RHS) {
		return id.equals(RHS.id) && name.equals(RHS.name) && sex.equals(RHS.sex);
	}
	public String toString() {
		return "user[id = " + id + ", name = " + name + ", sex = " + sex + "]";
	}
}
