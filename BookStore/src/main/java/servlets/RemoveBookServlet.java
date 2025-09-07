package servlets;

import java.io.IOException;

import daos.CartUpdateDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/removebook")
public class RemoveBookServlet  extends HttpServlet{
	
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
			
			int k = new CartUpdateDAO().removeBook(cid, bid);

			if(k>0) {
				   req.setAttribute("rmvsuccess","BookRemoved From The Cart!!");
				   req.getRequestDispatcher("CartUpdate.jsp").forward(req, res);
			   }
			   else {
				   req.setAttribute("rmvfailed","BookRemoval failed!!");
				   req.getRequestDispatcher("CartUpdate.jsp").forward(req, res);
			   }
			
			
		}
		
}
	

}
