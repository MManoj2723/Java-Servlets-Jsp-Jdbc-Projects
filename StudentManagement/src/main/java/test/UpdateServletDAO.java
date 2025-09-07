package test;
import java.sql.*;
public class UpdateServletDAO {
	
	public int updateMrks(Student st) {
		
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement
				("update marks71 set corejava=?,adjava=?,ui=?,"
						+ "db=?,tools=? where rollno=?");
			
			
			PreparedStatement ps1=con.prepareStatement
				("update students71 set TOTMARKS=?,PER=?,RESULT=? "
						+ "where rollno=?");
			
			int cjava = st.getMk().getcJava();
			int adJava = st.getMk().getAdJava();
			int ui = st.getMk().getUi();
			int db = st.getMk().getDb();
			int tools = st.getMk().getTools();
			int tmks = cjava+adJava+ui+db+tools;
			float per = ((float) tmks / 500) * 100;
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
			
			ps.setInt(1, cjava);
			ps.setInt(2, adJava);
			ps.setInt(3, ui);
			ps.setInt(4, db);
			ps.setInt(5, tools);
			ps.setString(6, st.getRollno());
			
			ps1.setInt(1, tmks);
			ps1.setFloat(2, per);
			ps1.setString(3, result);
			ps1.setString(4, st.getRollno());
			
			int k = ps.executeUpdate();
			int k1 = ps1.executeUpdate();
			
			if(k>0 && k1>0) {
				
				return 1;
			}
			
			
			
			
		}
		catch(Exception e) {
			
		}
		
		
		return 0;
	}

}
