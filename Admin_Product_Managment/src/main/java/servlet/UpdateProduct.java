package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Product;

@WebServlet("/updateproduct")
public class UpdateProduct extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price")); 
		
		Product p = new Product(id, name, category, brand, price);
		
		Dao dao = new Dao();
		
		try {
			dao.updateProduct(p, id);
			req.setAttribute("products", dao.getAllProducts());
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
