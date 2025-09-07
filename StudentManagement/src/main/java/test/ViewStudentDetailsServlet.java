package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/viewd")
public class ViewStudentDetailsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			Student st=(Student)hs.getAttribute("st");
			req.setAttribute("st", st);
			req.getRequestDispatcher("ViewStudentDetails.jsp").forward(req, res);
		}
		
		
		
		
	}
}
