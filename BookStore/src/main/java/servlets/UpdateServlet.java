package servlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.BookBean;
import daos.UpdateServletDAO;
import daos.ViewAllBooksDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateb")
public class UpdateServlet extends HttpServlet{
	
	protected  void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String bid = req.getParameter("bid");
			
//			Get The Books
			ArrayList<BookBean> al=new ViewAllBooksDAO().getBooks();
			
			
			
			for(BookBean b:al) {
				
				if(bid.equals(b.getbId())) {
					b.setbTitle(req.getParameter("btitle"));
					b.setbAuthor(req.getParameter("bauthor"));
					b.setbPublisher(req.getParameter("bpublisher"));
					b.setbPubYear(req.getParameter("bpyear"));
					b.setbPrice(Integer.parseInt(req.getParameter("bprice")));
					b.setBqty(Integer.parseInt(req.getParameter("bqty")));
					int k = new UpdateServletDAO().updateBook(b);
					
					switch(k) {
						case 1:
								req.setAttribute("msg", "BookUpdatedSuccessFullyy!!!");
								req.getRequestDispatcher("BookUpdateSuccess.jsp").forward(req, res);
								break;
						case 0:
							req.setAttribute("msg", "BookUpdationFailed!!!!");
							req.getRequestDispatcher("Msg.jsp").forward(req, res);
							break;
						
					}
					
					
					
					break;
				}
				
				
			}
		
		
		
		
		}
		
	}

}
