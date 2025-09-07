package servlets;


import java.util.ArrayList;
import java.io.*;
import beans.BookBean;
import daos.AddTOCartDAO;
import daos.ShowBooksServletDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet{
	
	protected  void doGet(HttpServletRequest req,HttpServletResponse res)throws
	ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExperied!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
				String bid = req.getParameter("bid");
				String cid  = (String)hs.getAttribute("cid");
				
				
				
				
//			Get The Books In Order to add to cart
			ArrayList<BookBean> al= new ShowBooksServletDAO().showBooks();
						
			
			BookBean b = null;
			
			for(BookBean bb:al) {
				if(bid.equals(bb.getbId())) {
					b=bb;
					break;
				}
				
			}   //break from the loop
			
			if(b==null){
				req.setAttribute("invid","No BookisPresent WithThat ID!!!!" );
				req.getRequestDispatcher("AddToCart.jsp").forward(req, res);
				return;
			}
			
				if(b.getBqty()==0) {
					req.setAttribute("msg","No Quantity is available!!!!!");
					req.setAttribute("bid", b.getbId());
					req.getRequestDispatcher("AddToCart.jsp").forward(req, res);
					return;
				}
		
			
				
				
/*First  check for that particular customer 
 
 the product is already added in the cart or not
 
 if it is added take user to show cart page
 
 if not insert new product into cart
*/
		
		
				
			ArrayList<String> chckProduct = new AddTOCartDAO().checkProductExist(cid);
			if(chckProduct.isEmpty()) {
				cartOperation(req, res, cid, bid);
			}
			else {
				
				if(chckProduct.contains(bid)) {
					req.setAttribute("bookalreadyincart", "BookAlready Added in the Cart");
					req.getRequestDispatcher("AddToCart.jsp").forward(req, res);
				}
				else {
					cartOperation(req, res, cid, bid);
				}
			}
			
		}
	}
	
	
	
	private void cartOperation(HttpServletRequest req, HttpServletResponse res,
            String cid, String bid) throws ServletException, IOException {

		
		int k = new AddTOCartDAO().addcart(cid, bid);
		
		if(k>0) {
			req.setAttribute("baddeds", "Book AddedTo the Cart");
			req.getRequestDispatcher("AddToCart.jsp").forward(req, res);
		}
		else {
			req.setAttribute("baddedf", "Book AddTo the Cart Failed");
			req.getRequestDispatcher("AddToCart.jsp").forward(req, res);
		}
		
	}

}









