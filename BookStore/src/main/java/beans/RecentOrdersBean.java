package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RecentOrdersBean implements Serializable{
	
	private String prodName;
	
	private Integer prodQty;
	
	private Timestamp ordrDate;
	
	private Double totalPrice;
	
	public Timestamp getOrdrDate() {
		return ordrDate;
	}


	public void setOrdrDate(Timestamp ordrDate) {
		this.ordrDate = ordrDate;
	}


	
	
	
	public RecentOrdersBean() {
	
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public Integer getProdQty() {
		return prodQty;
	}


	public void setProdQty(Integer prodQty) {
		this.prodQty = prodQty;
	}


	


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
}
