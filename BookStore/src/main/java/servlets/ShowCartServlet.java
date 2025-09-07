package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import beans.ShowCartBean;
import daos.ShowCartDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/showcart")
public class ShowCartServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String cid = (String)hs.getAttribute("cid");
			LinkedList<ShowCartBean> showcart =
					new ShowCartDAO().showCartItems(cid);
			if(showcart.isEmpty()) {
				req.setAttribute("cartEmpty","Cart IS Empty!!");
				req.getRequestDispatcher("Showcart.jsp").forward(req, res);
			}
			else{
				hs.setAttribute("showcart", showcart);
				req.getRequestDispatcher("Showcart.jsp").forward(req, res);
			}
			
			
		}

	}

}
