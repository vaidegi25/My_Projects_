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

@WebServlet("/edit")
public class EditProduct extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		
		try {
			Dao dao = new Dao();
			Admin sessionadmin = (Admin)req.getSession().getAttribute("admin");
			if(sessionadmin!=null) {
			Product p = dao.findProductById(id);
			req.setAttribute("products", p);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("message", "Login Is Required.... Forbidden");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
