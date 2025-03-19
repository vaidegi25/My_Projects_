package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.Admin;
import dto.Product;

@WebServlet("/saveproduct")
public class SaveProduct extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Product product = new Product(id, name, category, brand, price);
		try {
			Dao dao = new Dao();
			
			HttpSession session = req.getSession();
			Admin sessionadmin = (Admin)session.getAttribute("admin");
			if(sessionadmin!=null) {
			dao.saveProduct(product);
			req.setAttribute("products", dao.getAllProducts());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("message", "Login is Required..");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
