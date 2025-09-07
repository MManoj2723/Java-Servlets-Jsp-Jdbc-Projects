package test;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/addstudent")

public class AddStudentServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			StudentBean sb = new StudentBean();
			sb.setRollno(req.getParameter("rollno"));
			sb.setName(req.getParameter("name"));
			sb.setCourse(req.getParameter("course"));
			sb.getMk().setCJava(convert(req.getParameter("cjava")));
			sb.getMk().setAdJava(convert(req.getParameter("adjava")));
			sb.getMk().setUi(convert(req.getParameter("ui")));
			sb.getMk().setDb(convert(req.getParameter("db")));
			sb.getMk().setTools(convert(req.getParameter("tools")));
			
			int k = new AddStudentDAO().insert(sb);
			
			switch(k) {
			case 1:
					req.setAttribute("msg", "StudentAddedSuccessFully");
					req.getRequestDispatcher("StudentSuccess.jsp").forward(req, res);
					break;
			case 0:
					req.setAttribute("msg", "AddStudentFail..<br>");
					RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
					rd.forward(req, res);
					break;
					
			}
		}
		
	}
	
	public int convert(String str) {
		return Integer.parseInt(str);
	}
}
