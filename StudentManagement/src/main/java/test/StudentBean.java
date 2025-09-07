package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBean implements Serializable{
	
	private String rollno,name,course;
	
	private MarksBean mk = new MarksBean();
	
	public StudentBean() {}
	
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public MarksBean getMk() {
		return mk;
	}
	public void setMk(MarksBean mk) {
		this.mk = mk;
	}
	
	
	
	
	
}
