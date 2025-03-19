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

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Dao dao = new Dao();
		
		try {
			Admin admin = dao.findByAdminEmail(email);
			if(admin != null) {
				if(admin.getAdminPassword().equals(password)) {
					HttpSession session = req.getSession();
					session.setAttribute("admin", admin);
					req.setAttribute("products", dao.getAllProducts());
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				}
				req.setAttribute("message", "incorrect password");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			req.setAttribute("message", "invalid email");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
