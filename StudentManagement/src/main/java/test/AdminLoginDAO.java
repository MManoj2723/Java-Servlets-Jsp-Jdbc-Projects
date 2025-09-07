package test;
import java.sql.*;
public class AdminLoginDAO {
	public AdminBean ab=null;
	
	public AdminBean login(String uname,String pswd) {
		try {
			Connection con =DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement
						("select * from admin71 where uname=? and pswd=?");
			ps.setString(1, uname);
			ps.setString(2, pswd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ab=new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPswd(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setCity(rs.getString(5));
				ab.setMid(rs.getString(6));
				ab.setPhno(rs.getLong(7));
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ab;
	}
}
