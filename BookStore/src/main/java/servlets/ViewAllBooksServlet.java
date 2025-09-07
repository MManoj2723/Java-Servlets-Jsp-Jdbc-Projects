package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.BookBean;
import daos.ViewAllBooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewb")
public class ViewAllBooksServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<BookBean> al = new ViewAllBooksDAO().getBooks();
			if(al.isEmpty()) {
				req.setAttribute("msg", "No Books Are Added!!!!!!");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else {
				req.setAttribute("arraylist", al);
				req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
			}
		}
	}

}
