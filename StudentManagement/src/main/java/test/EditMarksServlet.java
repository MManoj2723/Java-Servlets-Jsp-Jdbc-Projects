package test;
import java.util.*;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/editmrks")

public class EditMarksServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws 
	ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExpired!!!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			String rollno = req.getParameter("rollno");
			
			ArrayList<Student> al=
					(ArrayList<Student>)hs.getAttribute("ArrayList");
			
			Iterator<Student> itr = al.iterator();
			while(itr.hasNext()) {
				Student st = itr.next();
				if(rollno.equals(st.getRollno())) {
					req.setAttribute("st", st);
					req.getRequestDispatcher("EditMarks.jsp").forward(req, res);
					break;
				}
			}
			
		}
	}

}












