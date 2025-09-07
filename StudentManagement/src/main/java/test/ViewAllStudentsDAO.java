package test;
import java.util.*;
import java.sql.*;

public class ViewAllStudentsDAO {
	ArrayList<Student> al = new ArrayList<Student>();
	
	
	public ArrayList<Student> getList(){
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps =con.prepareStatement
					("select * from students71");
			PreparedStatement ps1 = con.prepareStatement
					("select * from marks71");
			
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs.next() && rs1.next()) {
				Student sb = new Student();
				sb.setRollno(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setCourse(rs.getString(3));
				sb.setTotmrks(rs.getInt(4));
				sb.setPer(rs.getFloat(5));
				sb.setResult(rs.getString(6));
				sb.getMk().setCJava(rs1.getInt(2));
				sb.getMk().setAdJava(rs1.getInt(3));
				sb.getMk().setUi(rs1.getInt(4));
				sb.getMk().setDb(rs1.getInt(5));
				sb.getMk().setTools(rs1.getInt(6));
				al.add(sb);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	
}
