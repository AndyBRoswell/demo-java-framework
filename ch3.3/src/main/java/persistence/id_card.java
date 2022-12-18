package persistence;

public class id_card {
	Long id;
	String code;
	public Long getId() {return id;}
	public void setId(final Long id) {this.id = id;}
	public String getCode() {return code;}
	public void setCode(final String code) {this.code = code;}
	public String toString() {return "id_card [id = " + id + ", code = " + code + "]";}
}
