package beans;

import java.io.Serializable;

public class AdminBean implements Serializable{
	
	private String fname;
	
	public AdminBean() {}

	

	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public String getFname() {
		return fname;
	}
	
	
}
