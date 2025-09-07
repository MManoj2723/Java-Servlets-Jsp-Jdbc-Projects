package servlets;
import daos.*;
import java.io.IOException;
import java.util.ArrayList;

import beans.RegistrationBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class CustomerRegistrationServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		String cid = new GenerateId().generateId();
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String phn = req.getParameter("phn");
		String mail = req.getParameter("mail");
		
		RegistrationBean rb = new RegistrationBean();
		rb.setName(name);
		rb.setDob(dob);
		rb.setGender(gender);
		rb.setAddress(address);
		rb.setPhn(phn);
		rb.setMail(mail);
		
		//Check the Id if already exists or not
		ArrayList<String> chkid = new CheckIdDAO().checkId();
		
		while(chkid.contains(cid)) {
			cid = new GenerateId().generateId();
		}
		rb.setCId(cid);
		
		int k = new RegistrationDAO().register(rb);
		if(k>0) {
			req.setAttribute("rb", rb);
			req.setAttribute("msg", "RgistrationSuccessFull!!!!");
			req.getRequestDispatcher("RegistrationMsg.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg","RegistrationFailed!!!!");
			req.getRequestDispatcher("RegistrationFailed.jsp").forward(req, res);
		}
		
	}

}





































