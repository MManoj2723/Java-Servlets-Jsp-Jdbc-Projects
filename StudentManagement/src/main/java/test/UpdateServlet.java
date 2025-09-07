package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/update")

public class UpdateServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<Student> al=
					(ArrayList<Student>)hs.getAttribute("ArrayList");
			
			String rollno = req.getParameter("rollno");
			
			for(Student st :al) {
				if(rollno.equals(st.getRollno())) {
					st.getMk().setCJava(Integer.parseInt(req.getParameter("cjava")));
					st.getMk().setAdJava(Integer.parseInt(req.getParameter("adjava")));
					st.getMk().setUi(Integer.parseInt(req.getParameter("ui")));
					st.getMk().setDb(Integer.parseInt(req.getParameter("db")));
					st.getMk().setTools(Integer.parseInt(req.getParameter("tools")));
					
					int k = new UpdateServletDAO().updateMrks(st);
					
					switch(k) {
						
					case 1:
							req.setAttribute("rollno", rollno);
							req.setAttribute("msg", "MarksUpdatedSuccessfully!!!!");
							req.getRequestDispatcher("UpdateMarks.jsp").forward(req, res);
							break;
					case 0:
							req.setAttribute("msg", "MarksUpdationFailed!!!!");
							req.getRequestDispatcher("Msg.jsp").forward(req, res);
							break;
					
					}
					
					break;
				}
			}
			
		}
	}
}












