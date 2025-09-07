package test;
import java.util.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/viewm")

public class ViewMarksServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws 
		ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String rollno = req.getParameter("rollno");
			ArrayList<Student> al=
					(ArrayList<Student>)hs.getAttribute("ArrayList");
			
			Iterator<Student> itr = al.iterator();
			
			while(itr.hasNext()) {
				Student st=(Student)itr.next();
				if(rollno.equals(st.getRollno())) {
					req.setAttribute("st", st);
					req.getRequestDispatcher("ViewMarks.jsp").forward(req, res);
					break;
				}
			}
			
		}
		
	}

}
