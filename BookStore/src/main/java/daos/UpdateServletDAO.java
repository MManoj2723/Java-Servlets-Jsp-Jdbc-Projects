package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.BookBean;
import connection.DBConnection;

public class UpdateServletDAO {
	
	
	public int updateBook(BookBean b) {
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
									("update bookstore set btitle=?,bauthor=?,"
										+ "publisher=?,pubyear=?,bprice=?,cpavailable=? where bid=?");
			
			
			ps.setString(1, b.getbTitle());
			ps.setString(2, b.getbAuthor());
			ps.setString(3, b.getbPublisher());
			ps.setString(4, b.getbPubYear());
			ps.setInt(5, b.getbPrice());
			ps.setInt(6, b.getBqty());
			ps.setInt(7,Integer.parseInt(b.getbId()));
			
			
			
			
			
			
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
