package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws 
	ServletException,IOException{
		
		String un = req.getParameter("uname");
		String ps = req.getParameter("pswd");
		
		AdminBean ab = new AdminLoginDAO().login(un, ps);
		
		if(ab==null) {
			req.setAttribute("msg", "InvalidLoginProcess..<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
			rd.forward(req, res);
			
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, res);
		}
	}
}
