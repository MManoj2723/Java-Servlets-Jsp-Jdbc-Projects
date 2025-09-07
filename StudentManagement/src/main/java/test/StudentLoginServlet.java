package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/slogin")

public class StudentLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		String rollno = req.getParameter("rollno");
		
		
		Student st = new StudentLoginDAO().getData(rollno);
		
		if(st==null) {
			req.setAttribute("msg", "Data is null");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			HttpSession hs = req.getSession();
			hs.setAttribute("st", st);
			req.getRequestDispatcher("StudentAdmin.jsp").forward(req, res);
			
		}
		
	}
}
