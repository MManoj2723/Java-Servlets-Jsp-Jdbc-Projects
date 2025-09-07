package daos;
import java.sql.*;
import java.util.ArrayList;

import beans.BookBean;
import connection.DBConnection;

public class ShowBooksServletDAO {
	public ArrayList<BookBean> al = new  ArrayList<BookBean>();
	
	public ArrayList<BookBean> showBooks(){
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from bookstore order by bid asc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookBean b = new BookBean();
				b.setbId(rs.getString("BID"));
				b.setbTitle(rs.getString("BTITLE"));
				b.setbAuthor(rs.getString("BAUTHOR"));
				b.setbPublisher(rs.getString("PUBLISHER"));
				b.setbPubYear(rs.getString("PUBYEAR"));
				b.setbPrice(rs.getInt("BPRICE"));
				b.setBqty(rs.getInt("CPAVAILABLE"));
				al.add(b);
			}
		
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	
}
