package daos;
import java.sql.*;
import java.util.*;
import beans.ShowCartBean;
import connection.DBConnection;
public class ShowCartDAO {
	
	
	private Connection con = DBConnection.getCon();
	
	

	public LinkedList<ShowCartBean> showCartItems(String cid){
		
		LinkedList<ShowCartBean> showcart = new LinkedList<ShowCartBean>();
		
		String query="select ca.bid,b.btitle,ca.qty,(ca.qty*b.bprice) as totalPrice from cart ca inner join bookstore b on ca.bid = b.bid inner join cregistration c on ca.cid = c.cid where ca.cid=?";
		
		
		try {
			PreparedStatement ps = 
					con.prepareStatement(query);
			ps.setString(1, cid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ShowCartBean cb = new ShowCartBean();
				cb.setbId(rs.getString("BID"));
				cb.setbTitle(rs.getString("BTITLE"));
				cb.setQty(rs.getInt("QTY"));
				cb.setTotalPrice(rs.getInt("totalPrice"));
				showcart.add(cb);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return showcart;
	}
}





