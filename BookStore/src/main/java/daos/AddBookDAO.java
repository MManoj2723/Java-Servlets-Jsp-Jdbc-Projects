package daos;
import java.sql.*;
import beans.*;
import connection.*;

public class AddBookDAO {
	
	public int addBook(BookBean b) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
									("insert into bookstore values(?,?,?,?,?,?,bookId.nextval)");
			
			ps.setString(1, b.getbTitle());
			ps.setString(2, b.getbAuthor());
			ps.setString(3, b.getbPublisher());
			ps.setString(4, b.getbPubYear());
			ps.setInt(5, b.getbPrice());
			ps.setInt(6, b.getBqty());
			
			int k = ps.executeUpdate();
			
			if(k>0) {
				return 1;
			}
			
		}
		catch(Exception e) {
			
		}
		return 0;
	}
}
