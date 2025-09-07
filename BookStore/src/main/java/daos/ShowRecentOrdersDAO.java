package daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.RecentOrdersBean;
import connection.DBConnection;
import oracle.jdbc.internal.OracleTypes;

public class ShowRecentOrdersDAO {
	
	
	public List<RecentOrdersBean> showRecentOrders(String cid){
		
		Connection con = DBConnection.getCon();
		
		List<RecentOrdersBean> recentOrders=new ArrayList<RecentOrdersBean>();
		
		try {
			
			String query="{? = call recentOrders(?)}";
			
			CallableStatement cs = con.prepareCall(query);
			cs.setString(2, cid);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs=(ResultSet)cs.getObject(1);
			
			while(rs.next()) {
				RecentOrdersBean rb = new RecentOrdersBean();
				rb.setProdName(rs.getString(1));
				rb.setProdQty(rs.getInt(2));
				rb.setTotalPrice(rs.getDouble(3));
				rb.setOrdrDate(rs.getTimestamp(4));
				recentOrders.add(rb);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return recentOrders;
	}
}
























