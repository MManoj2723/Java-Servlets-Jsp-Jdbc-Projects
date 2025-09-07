package daos;
import beans.*;
import connection.*;
import java.sql.*;

public class AdminLoginDAO {
	
	public AdminBean adminLogin(String uname,String pswd) {
		AdminBean ab = null;
		try {
			Connection con = DBConnection.getCon();
			
			 PreparedStatement ps = con.prepareStatement
					 ("select fname from admin71 where uname=? and pswd=?");
			 
			 ps.setString(1,uname);
			 ps.setString(2, pswd);
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 ab=new AdminBean();
				 ab.setFname(rs.getString(1));
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ab;
	}
}
