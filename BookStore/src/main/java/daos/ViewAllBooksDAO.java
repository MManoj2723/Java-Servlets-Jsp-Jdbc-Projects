package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.BookBean;
import connection.DBConnection;

public class ViewAllBooksDAO {
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	
	public ArrayList<BookBean> getBooks(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
									("select * from bookstore order by bid asc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookBean b = new BookBean();
				b.setbId(rs.getString(7));
				b.setbTitle(rs.getString(1));
				b.setbAuthor(rs.getString(2));
				b.setbPublisher(rs.getString(3));
				b.setbPubYear(rs.getString(4));
				b.setbPrice(rs.getInt(5));
				b.setBqty(rs.getInt(6));
				al.add(b);
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}
}
