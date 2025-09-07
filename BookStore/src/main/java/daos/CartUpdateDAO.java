package daos;
import java.sql.*;

import connection.DBConnection;

public class CartUpdateDAO {
	
	public int incrementQty(String cid,String bid) {
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement
					("update cart set qty=qty+1 where cid=? and bid=?");
			ps.setString(1, cid);
			ps.setString(2, bid);
			
			int k = ps.executeUpdate();
			if(k>0) {
				return 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int decrementQty(String cid,String bid) {
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement
					("update cart set qty=qty-1 where cid=? and bid=?");
			ps.setString(1, cid);
			ps.setString(2, bid);
			
			int k = ps.executeUpdate();
			if(k>0) {
				return 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int removeBook(String cid,String bid) {
		
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement
					("delete from cart where cid=? and bid=?");
			ps.setString(1, cid);
			ps.setString(2, bid);
			
			int k = ps.executeUpdate();
			if(k>0) {
				return 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
