package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import beans.ShowCartBean;
import connection.DBConnection;

public class PlaceOrderDAO {
	
	
	public Map<Integer,Integer> chkBqty(String[] bid) {
		
		Connection con = DBConnection.getCon();
		
		StringBuilder query = new StringBuilder("select BID,CPAVAILABLE from bookstore where BID in(");
		
		for(int i=0;i<bid.length;i++) {
			query.append("?");
			
			if(i<bid.length-1) {
				query.append(",");
			}
		}
		query.append(")");
		
		// HashMap 
		HashMap<Integer, Integer> hm=null;
		
		try {
			PreparedStatement ps = 
					con.prepareStatement(query.toString());
			for(int i=0;i<bid.length;i++) {
				ps.setString(i+1, bid[i]);
			}
			ResultSet rs = ps.executeQuery();
			
		// HashMap 
			
			 hm = new HashMap<>();
			
			
			while(rs.next()) {
				hm.put(rs.getInt("BID"), rs.getInt("CPAVAILABLE"));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hm;
	}
	
	
// Update Quantity
//------------------
	
	public int[] updateQty(Map<Integer,Integer> upq)  {

		Connection con = DBConnection.getCon();
			
		PreparedStatement ps;
		
		int[] executeBatch=null;
		try {
			ps = con.prepareStatement("update bookstore set CPAVAILABLE=? where bid=?");
			
			
			
			for(Map.Entry<Integer, Integer> e:upq.entrySet()) {
				
				ps.setInt(1,e.getValue());
				ps.setInt(2, e.getKey());
				
				ps.addBatch();
			}
			
		executeBatch = ps.executeBatch();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return executeBatch;
		
		
	}
	
	

//------------------
//	makeTheEntryInOrdersTable
	
	
	public int[] makeTheEntryInOrdersTable(String cid,LinkedList<ShowCartBean> scb) {

		Connection con = DBConnection.getCon();
		

		String url="insert into orders values(ORDERID.nextval,?,?,?,?,?)";
		PreparedStatement ps;
		int[] executeBatch=null;
		try {
			 ps = con.prepareStatement(url);
			
			for(ShowCartBean sb:scb) {
				ps.setString(1, cid);
				ps.setInt(2, Integer.parseInt(sb.getbId()));
				ps.setInt(3, sb.getQty());
				ps.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
				ps.setInt(5, sb.getTotalPrice());
				ps.addBatch();
			}
			
		executeBatch = ps.executeBatch();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	return executeBatch;	
	
	}
	
	

public int clearTheCart(String id) {
	
	Connection con = DBConnection.getCon();
	int k=0;
	try {
		PreparedStatement ps = con.prepareStatement("delete from cart where cid=?");
		ps.setString(1, id);  
		k = ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return k;
}
	
	
	
	
	
	
	
	
	
}


















