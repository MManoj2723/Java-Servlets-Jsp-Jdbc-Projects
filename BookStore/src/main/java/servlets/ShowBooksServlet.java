package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.BookBean;
import daos.ShowBooksServletDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showb")
public class ShowBooksServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<BookBean> al = new ShowBooksServletDAO().showBooks();
			if(al.isEmpty()) {
				req.setAttribute("nobook", "Sorry No Books are Available!!!");
				req.getRequestDispatcher("CustomerLoginSuccess.jsp").forward(req, res);
			}
			else {
				req.setAttribute("arraylist", al);
				req.getRequestDispatcher("ShowBooksServlet.jsp").forward(req, res);
			}
		}
		
	}
	
	


}
