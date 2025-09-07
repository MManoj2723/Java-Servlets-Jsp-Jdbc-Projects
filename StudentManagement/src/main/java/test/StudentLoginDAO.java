package test;
import java.sql.*;

public class StudentLoginDAO {
	
	public Student getData(String rollno) {
		 
		Student st =null;
		 
		try {
			
		  Connection con = DBConnection.getCon();
		  
		  PreparedStatement ps = 
				  con.prepareStatement("select * from students71 where rollno=?");
		  
		  PreparedStatement ps1 = 
				  con.prepareStatement("select * from marks71 where rollno=?");
		  
		  ps.setString(1, rollno);
		  ps1.setString(1, rollno);
		  
		  
		  ResultSet rs = ps.executeQuery();
		  ResultSet rs1 = ps1.executeQuery();
		  
		  if(rs.next() && rs1.next()) {
			  st = new Student();
			  st.setRollno(rs.getString(1));
			  st.setName(rs.getString(2));
			  st.setCourse(rs.getString(3));
			  st.setTotmrks(rs.getInt(4));
			  st.setPer(rs.getFloat(5));
			  st.setResult(rs.getString(6));
			  st.getMk().setCJava(rs1.getInt(2));
			  st.getMk().setAdJava(rs1.getInt(3));
			  st.getMk().setUi(rs1.getInt(4));
			  st.getMk().setDb(rs1.getInt(5));
			  st.getMk().setTools(rs1.getInt(6));
			  return st;
			  
			  
		  }
		  
  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return null;
	}
}
