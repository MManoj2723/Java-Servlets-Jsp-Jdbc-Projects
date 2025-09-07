package servlets;

import java.io.IOException;

import daos.CartUpdateDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dec")
public class DecrementServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String cid=(String)hs.getAttribute("cid");
			String bid = req.getParameter("bid");
			   int bqty = Integer.parseInt(req.getParameter("bqty"));
			   
			   if(bqty>1) {
				   int k = new CartUpdateDAO().decrementQty(cid,bid);
				   dispatchMsg(req, res, k);
			   }
			   else {
				   req.setAttribute("invalid", "Cannot Decreement lessthan 1");
				   req.getRequestDispatcher("CartUpdate.jsp").forward(req, res);
			   }
		}
}
	
	
	private void dispatchMsg(HttpServletRequest req,HttpServletResponse res,int k) throws ServletException, IOException {
		
		if(k>0) {
			   req.setAttribute("decsuccess","QuantityDecrementSuccessFull!!");
			   req.getRequestDispatcher("CartUpdate.jsp").forward(req, res);
		   }
		   else {
			   req.setAttribute("decfailed","QuantityDecrementFail!!");
			   req.getRequestDispatcher("CartUpdate.jsp").forward(req, res);
		   }
		
	}
	

}
