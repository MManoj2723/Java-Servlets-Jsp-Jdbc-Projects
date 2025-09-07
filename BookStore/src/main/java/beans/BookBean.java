package beans;

import java.io.Serializable;

public class BookBean implements Serializable{
	
	private String bId;
	private String bTitle;
	private String bAuthor;
	private String bPublisher;
	private String bPubYear;
	private int bPrice;
	private int bqty;
	
		
	public BookBean() {
	
	}


	public String getbId() {
		return bId;
	}


	public void setbId(String bId) {
		this.bId = bId;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getbAuthor() {
		return bAuthor;
	}


	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}


	public String getbPublisher() {
		return bPublisher;
	}


	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}


	public String getbPubYear() {
		return bPubYear;
	}


	public void setbPubYear(String bPubYear) {
		this.bPubYear = bPubYear;
	}


	public int getbPrice() {
		return bPrice;
	}


	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}


	public int getBqty() {
		return bqty;
	}


	public void setBqty(int bqty) {
		this.bqty = bqty;
	}
	
	

}
