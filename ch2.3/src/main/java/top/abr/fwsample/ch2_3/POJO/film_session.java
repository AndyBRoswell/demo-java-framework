package top.abr.fwsample.ch2_3.POJO;

public class film_session {
	public enum error {
		no_error,

		blank_title,
		blank_hall,
	}

	private String Title;
	private String[] Hall;
	private String Level;
	private String Note;

	public String getTitle() {return Title;}
	public void setTitle(String Title) {this.Title = Title;}
	public String[] getHall() {return Hall;}
	public void setHall(String[] Hall) {this.Hall = Hall;}
	public String getLevel() {return Level;}
	public void setLevel(String Level) {this.Level = Level;}
	public String getNote() {return Note;}
	public void setNote(String Note) {this.Note = Note;}
}
