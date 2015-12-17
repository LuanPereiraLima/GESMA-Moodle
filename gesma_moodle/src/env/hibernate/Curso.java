package hibernate;

public class Curso {
	private int id;
	private String idNumber;
	private String fullName;
	private long timeCreated;
	
	public Curso() {}
	
	public Curso(int id, String idNumber, String fullName, long timeCreated) {
		super();
		this.id = id;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.timeCreated = timeCreated;
	}

	public String getFullName() {
		return fullName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	
	public long getTimeCreated() {
		return timeCreated;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

}
