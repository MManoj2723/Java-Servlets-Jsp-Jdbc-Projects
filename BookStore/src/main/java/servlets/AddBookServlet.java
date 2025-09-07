package servlets;

import java.io.IOException;

import beans.BookBean;
import daos.AddBookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String btitle = req.getParameter("btitle");
			String bauthor = req.getParameter("bauthor");
			String bpublisher = req.getParameter("bpublisher");
			String bpyear = req.getParameter("bpyear");
			String bprice = req.getParameter("bprice");
			String bqty = req.getParameter("bqty");
			
			BookBean b  = new BookBean();
			b.setbTitle(btitle);
			b.setbAuthor(bauthor);
			b.setbPublisher(bpublisher);
			b.setbPubYear(bpyear);
			b.setbPrice(Integer.parseInt(bprice));
			b.setBqty(Integer.parseInt(bqty));
			int k = new AddBookDAO().addBook(b);
			
			switch(k) {
			    
				case 1:
						 req.setAttribute("msg","BookAddedSuccessFully!!!!");
						 req.getRequestDispatcher("BookAddedSuccess.jsp").forward(req, res);
						 break;
				case 0:
					      req.setAttribute("msg", "BookAdd Failed!!!!!");
					      req.getRequestDispatcher("Msg.jsp").forward(req, res);
					      break;
			}
			
		}
		
		
	}

}
