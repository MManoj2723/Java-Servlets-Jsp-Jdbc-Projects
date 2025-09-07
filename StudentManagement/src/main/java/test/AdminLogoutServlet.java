package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/logout")

public class AdminLogoutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExpired!!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			hs.setAttribute("userType", "admin");
			req.getRequestDispatcher("AdminLogout.jsp").forward(req, res);
		}
		
	}
}
