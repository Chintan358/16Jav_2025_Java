package controller;

import java.io.IOException;

import doa.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/home")
public class Homecontroller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		req.setAttribute("categories", dao.getCategories());
		req.setAttribute("products", dao.getProductss());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
}
