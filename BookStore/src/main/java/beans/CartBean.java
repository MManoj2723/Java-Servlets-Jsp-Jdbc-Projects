package beans;

import java.io.Serializable;

public class CartBean implements Serializable{
	private String cid;
	private String bid;
	private int qty;
	
	
	public CartBean() {}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getBid() {
		return bid;
	}


	public void setBid(String bid) {
		this.bid = bid;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	@Override
	public String toString() {
		return "CartBean [cid=" + cid + ", bid=" + bid + ", qty=" + qty + "]";
	}
	
	

}
