package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Admin;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long contact = Long.parseLong(req.getParameter("contact"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin admin = new Admin(id, name, contact, email, password);
		
		Dao dao = new Dao();
		
		try {
			dao.saveAdmin(admin);
			resp.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		
	}
	
	

}
