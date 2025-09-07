package test;
import java.sql.*;
public class AddStudentDAO {
	
	public int insert(StudentBean sb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps1 = con.prepareStatement
				("insert into students71 values(?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement
					("insert into marks71 values(?,?,?,?,?,?)");
			
			ps1.setString(1, sb.getRollno());
			ps1.setString(2, sb.getName());
			ps1.setString(3, sb.getCourse());
			int s1 = sb.getMk().getcJava();
			int s2 = sb.getMk().getAdJava();
			int s3 = sb.getMk().getUi();
			int s4 = sb.getMk().getDb();
			int s5 = sb.getMk().getTools();
			int totmrks = s1+s2+s3+s4+s5;
			float per =( (float)totmrks/500)*100;
			String result=null;
			
			
			if (per >= 90) {
				result = "A+";
			} else if (per >= 80) {
				result = "A";
			} else if (per >= 70) {
				result = "B";
			} else if (per >= 60) {
				result = "C";
			} else if (per >= 50) {
				result = "D";
			} else {
				result = "F";
			}
			
			ps1.setInt(4, totmrks);
			ps1.setFloat(5, per);
			ps1.setString(6, result);
			
			
			int k = ps1.executeUpdate();
			if(k>0) {
				ps2.setString(1, sb.getRollno());
				ps2.setInt(2,sb.getMk().getcJava());
				ps2.setInt(3,sb.getMk().getAdJava());
				ps2.setInt(4,sb.getMk().getUi());
				ps2.setInt(5,sb.getMk().getDb());
				ps2.setInt(6,sb.getMk().getTools());
				int k1 = ps2.executeUpdate();
				if(k1>0) {
					return 1;
				}
				
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
