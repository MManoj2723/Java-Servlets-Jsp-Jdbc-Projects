package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/viewsm")

public class ViewStudentMarksServlet extends HttpServlet{
	
		protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
		ServletException,IOException{
			
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			req.getRequestDispatcher("ViewStudentMarks.jsp").forward(req, res);
		}
			
			
		}

}
