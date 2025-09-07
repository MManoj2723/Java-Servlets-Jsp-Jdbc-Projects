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

@WebServlet("/editb")
public class EditBookServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String bid = req.getParameter("bid");
			
			
			ArrayList<BookBean> al=new ViewAllBooksDAO().getBooks();
			
			for(BookBean b:al) {
				if(bid.equals(b.getbId())) {
					req.setAttribute("b", b);
					req.getRequestDispatcher("EditBook.jsp").forward(req, res);
					break;
				}
			}
			
			
			
		}
	}

}






