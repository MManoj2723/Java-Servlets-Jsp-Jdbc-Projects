package daos;
import java.sql.*;

import connection.DBConnection;

public class CustomerLoginDAO {
	
	public String custLogin(String cid) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select name from cregistration where cid=?");
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
