package servlets;
import java.io.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import daos.*;
import beans.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		String uname = req.getParameter("uname");
		String pswd = req.getParameter("pswd");
		
		AdminBean ab = new AdminLoginDAO().adminLogin(uname, pswd);
		if(ab!=null) {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLoginSuccessFull.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg","AdminLoginFailed!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}

}
