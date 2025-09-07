package servlets;

import java.io.IOException;

import daos.CustomerLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/custlogin")
public class CustomerLoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		String cid = req.getParameter("cid");
		
		String name = new CustomerLoginDAO().custLogin(cid);
		if(name==null) {
			req.setAttribute("msg", "CustomertLoginFailed!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("name", name);
			hs.setAttribute("cid", cid);
			req.getRequestDispatcher("CustomerLoginSuccess.jsp").forward(req, res);
		}
	}

}
