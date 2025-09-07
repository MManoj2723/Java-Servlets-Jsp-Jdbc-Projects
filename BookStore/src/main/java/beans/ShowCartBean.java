package beans;
import java.io.*;

public class ShowCartBean implements Serializable{
	
	private String bId;
	private String bTitle;
	private int qty;
	private int totalPrice;
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShowCartBean() {}

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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "ShowCartBean [bId=" + bId + ", bTitle=" + bTitle + ", qty=" + qty + ", totalPrice=" + totalPrice + "]";
	}
	
	

}