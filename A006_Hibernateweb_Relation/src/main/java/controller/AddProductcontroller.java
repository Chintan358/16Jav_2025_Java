package controller;

import java.io.IOException;


import doa.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

@WebServlet("/addproduct")
public class AddProductcontroller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname = req.getParameter("pname");
		int cid = Integer.parseInt(req.getParameter("category"));
		
		
		ProductDao dao = new ProductDao();
		
		Product p = new Product();
		p.setPname(pname);
		p.setCategory(dao.getCategory(cid));
		
		
		int i = dao.addProduct(p);
		if(i>0)
		{
			req.getRequestDispatcher("home").forward(req, resp);
		}
		
	}
	
}
