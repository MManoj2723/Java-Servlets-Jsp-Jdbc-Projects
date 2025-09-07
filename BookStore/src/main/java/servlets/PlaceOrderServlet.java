package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import beans.ShowCartBean;
import daos.CustomerLoginDAO;
import daos.PlaceOrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeorder")
public class PlaceOrderServlet extends HttpServlet{
	
	protected  synchronized void  doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String bid[] = req.getParameterValues("bid[]");
			String[] bqty = req.getParameterValues("bqty[]");
			
			//Data Collected TO insert in orders table
			LinkedList<ShowCartBean> scb=	(LinkedList<ShowCartBean>)hs.getAttribute("showcart");
			String id=(String)hs.getAttribute("cid");
			
			
//			HAshMap for cart items
			HashMap<Integer, Integer> wa = new HashMap<>();
			
			
			for(int i =0;i<bid.length;i++) {
				wa.put(  Integer.parseInt(bid[i]) , Integer.parseInt(bqty[i])  );							
			}
			
			
//          HashMap for Original Data
			Map<Integer, Integer> og = new PlaceOrderDAO().chkBqty(bid);
			
//			HashMap to update The Quantity
			Map<Integer,Integer> upq = new HashMap<>(og);
	
// --------------------------------------------------------------------------------------------
// Check for The Available Quantity			
				
			boolean flag=false;
			int bookId=0;
			for(int i=0;i<bid.length;i++) {
			
				int waid=Integer.parseInt(bid[i]);
				
				if( og.get(waid)<wa.get(waid) ) {
					
//					pw.println("Sorry Available qty is not there for bid:"+wa.get(waid)+"\n");
					bookId=waid;
					flag=true;
					break;
				}
				else {
					upq.put(waid, og.get(waid)-wa.get(waid));
				}
				
				
			}
			
//			pw.println("updated Quantity:"+upq);	
//			--------------------------------------------------------------------------------------------
			
			if(flag==false) {
				
				//Update Quantity
				int[] updateQty = new PlaceOrderDAO().updateQty(upq);
				
//				pw.println(Arrays.toString(updateQty));
				
				
				if(updateQty!=null && ! Arrays.stream(updateQty).anyMatch(val->val==0) ) {
					
//					"Quantity SuccessFully Updated" ;
						
						int[] executeBatch = new PlaceOrderDAO().makeTheEntryInOrdersTable(id,scb);
						
						// clear the cart
						int k = new PlaceOrderDAO().clearTheCart(id);
						
						if(!Arrays.stream(executeBatch ).anyMatch(val->val==0) && k>=1) {		
							res.sendRedirect("showb");
							
						}
						else{
							failedToPlaceTheOrder(req, res);
						}	
				}
				else {
					failedToPlaceTheOrder(req, res);
				}	
			}
			else {
				req.setAttribute("noEnoughQuantity",bookId);
				req.getRequestDispatcher("OrderPlaced.jsp").forward(req, res);
			}
			
			
			
		
			
		}
		
		
}
	
	

	
	public void failedToPlaceTheOrder(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("OrderPlacedFailed", "Failed To Place The Order");
		req.getRequestDispatcher("OrderPlaced.jsp").forward(req, res);
	}
	



}















