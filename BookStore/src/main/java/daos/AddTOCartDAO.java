package daos;
import java.util.*;
import java.sql.*;
import connection.DBConnection;

public class AddTOCartDAO {
	private Connection con =  DBConnection.getCon();
	private ArrayList<String> bookid = new ArrayList<String>(); 
	
	public ArrayList<String>  checkProductExist(String cid) {
		try {
			PreparedStatement ps =
					con.prepareStatement("select bid from cart where cid=?");
			
			ps.setString(1, cid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bookid.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bookid;
	}
	
	
	public int addcart(String cid,String bid) {
		
		try {
			PreparedStatement ps = 
					con.prepareStatement("insert into cart values(?,?,?)");
			
			ps.setString(1, cid);
			ps.setString(2, bid);
			ps.setInt(3, 1);
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
