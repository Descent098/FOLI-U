package application;

public class Student {
	
	private String studentFirstName, studentLastName, studentUsername, studentPassword, studentUni, studentDegree, studentYear, 
	studentDOB;
	
	public Student() {
		this(null, null);
	}
	
	public Student(String firstName, String lastName) {
		this.studentFirstName = new String(firstName);
		this.studentLastName = new String(lastName);
		
		this.studentUsername = new String("username");
		this.studentPassword = new String("password");
		this.studentUni = new String("university");
		this.studentDegree = new String("degree");
		this.studentYear = new String("year of study");
		this.studentDOB = new String("1999-01-02");
	}
	
	public String getFirstName() {
		return studentFirstName;
	}
	
	public void setFirstName(String firstName) {
		this.studentFirstName = firstName;
	}
	
	public String getLastName() {
		return studentLastName;
	}
	
	public void setLastName(String lastName) {
		this.studentLastName = lastName;
	}
	
	public String getUsername() {
		return studentUsername;
	}
	
	public void setUsername(String username) {
		this.studentUsername = username;
	}
	public String getPassword() {
		return studentPassword;
	}
	
	public void setPassword(String password) {
		this.studentPassword = password;
	}
	
	public String getUni() {
		return studentUni;
	}
	
	public void setUni(String uni) {
		this.studentUni = uni;
	}
	
	public String getDegree() {
		return studentDegree;
	}
	
	public void setDegree(String degree) {
		this.studentDegree = degree;
	}
	
	public String getYear() {
		return studentYear;
	}
	
	public void setYear(String year) {
		this.studentYear = year;
	}
	
	public String getDOB() {
		return studentDOB;
	}
	
	public void setDOB(String dob) {
		this.studentDOB = dob;
	}

}
