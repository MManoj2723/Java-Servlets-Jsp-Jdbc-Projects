package test;

import java.io.Serializable;

public class MarksBean implements Serializable{
	
	private int cJava,adJava,ui,db,tools;
	
	public MarksBean() {}
	
	public int getcJava() {
		return cJava;
	}
	public void setCJava(int cJava) {
		this.cJava = cJava;
	}
	public int getAdJava() {
		return adJava;
	}
	public void setAdJava(int adJava) {
		this.adJava = adJava;
	}
	public int getUi() {
		return ui;
	}
	public void setUi(int ui) {
		this.ui = ui;
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	public int getTools() {
		return tools;
	}
	public void setTools(int tools) {
		this.tools = tools;
	}
	

}
