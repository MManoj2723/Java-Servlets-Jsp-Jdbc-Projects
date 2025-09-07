package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import beans.RecentOrdersBean;
import daos.ShowRecentOrdersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showRecentOrders")
public class ShowRecentOrdersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		
		PrintWriter pw = res.getWriter();
		
		res.setContentType("text/html");
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String id=(String)hs.getAttribute("cid");
//			pw.println(id);
			
			List<RecentOrdersBean> recentOrds = 
					new ShowRecentOrdersDAO().showRecentOrders(id);
			
			if(!recentOrds.isEmpty()) {
				req.setAttribute("Orders", recentOrds);
				req.getRequestDispatcher("RecentOrders.jsp").forward(req, res);
			}
			else {
				req.setAttribute("noOrders", "No Orders Placed Yet");
				req.getRequestDispatcher("RecentOrders.jsp").forward(req, res);
			}
			
		}
		
		
		
	}
	
	
	
	
}














