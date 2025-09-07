package beans;

import java.io.Serializable;

public class RegistrationBean implements Serializable{
	private String cid;
	private String name;
	private String dob;
	private String gender;
	private String address;
	private String phn;
	private String mail;
	
	public RegistrationBean() {}

	public String getCId() {
		return cid;
	}

	public void setCId(String id) {
		this.cid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhn() {
		return phn;
	}

	public void setPhn(String phn) {
		this.phn = phn;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

}

