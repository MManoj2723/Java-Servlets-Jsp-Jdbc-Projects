package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/slogout")
public class StudentLogoutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
	
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExpired!!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			hs.setAttribute("userType", "student");
			req.getRequestDispatcher("StudentLogout.jsp").forward(req, res);
		}
		
	}

}
