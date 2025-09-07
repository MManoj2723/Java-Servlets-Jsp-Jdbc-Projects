package daos;
import java.sql.*;
import java.util.ArrayList;

import connection.DBConnection;
public class CheckIdDAO {
	
	public ArrayList<String> al = new ArrayList<String>();
	
	public ArrayList<String> checkId() {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
										("select cid from cregistration");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				al.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
