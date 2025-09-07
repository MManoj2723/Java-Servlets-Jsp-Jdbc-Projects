package test;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/view")
public class ViewAllStudentsServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		
		
		
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<Student> al = new ViewAllStudentsDAO().getList();
			
			if(al.isEmpty()) {
			req.setAttribute("msg", "No Students are Added!!!!!!!!");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else {
				hs.setAttribute("ArrayList", al);
				req.getRequestDispatcher("ViewStudents.jsp").forward(req, res);
				
			}
		}
		
		
		
		

	}

}
