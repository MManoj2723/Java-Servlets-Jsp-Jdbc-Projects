package test;

import java.io.Serializable;

public class Student implements Serializable{
	private String rollno,name,course;
	private int totmrks;
	private float per;
	private String result;
	private MarksBean mk = new MarksBean();
	
	
	public Student() {}


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


	public int getTotmrks() {
		return totmrks;
	}


	public void setTotmrks(int totmrks) {
		this.totmrks = totmrks;
	}


	public float getPer() {
		return per;
	}


	public void setPer(float per) {
		this.per = per;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public MarksBean getMk() {
		return mk;
	}


	public void setMk(MarksBean mk) {
		this.mk = mk;
	}
	
	

	
	
}
