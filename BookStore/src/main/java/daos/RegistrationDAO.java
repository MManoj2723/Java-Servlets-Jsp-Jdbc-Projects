package daos;

import java.io.Serializable;
import java.sql.*;
import beans.RegistrationBean;
import connection.DBConnection;

public class RegistrationDAO implements Serializable{

	public int register(RegistrationBean rb) {
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement
					("insert into cregistration values(?,?,?,?,?,?,?)");
			
			
			ps.setString(1, rb.getCId());
			ps.setString(2, rb.getName());
			ps.setString(3, rb.getDob());
			ps.setString(4, rb.getGender());
			ps.setString(5, rb.getAddress());
			ps.setString(6, rb.getPhn());
			ps.setString(7, rb.getMail());
			
			int k = ps.executeUpdate();
			if(k>0) {
				return 1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
		
	}
	
	

}
