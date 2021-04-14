
public class Student {

	private String studentId;
	private String studentName;
	private String birthday;
	private String address;
	private double score;

	public Student() {
	}

	public Student(String studentId, String studentName, String birthday, String address, double score) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.birthday = birthday;
		this.address = address;
		this.score = score;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName()  {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	
	
}
