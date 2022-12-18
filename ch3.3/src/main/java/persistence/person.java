package persistence;

public class person {
	Long id;
	String name;
	Short age;
	id_card id_card;
	public Long getId() {return id;}
	public void setId(final Long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(final String name) {this.name = name;}
	public Short getAge() {return age;}
	public void setAge(final Short age) {this.age = age;}
	public id_card getId_card() {return id_card;}
	public void setId_card(id_card id_card) {this.id_card = id_card;}
	public String toString() {return "Person [id = " + id + ", name = " + name + ", age = " + age + ", id_card = " + id_card + "]";}
}
