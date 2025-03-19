package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Admin;
import dto.Product;

public class Dao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:///mydb" , "root" , "root");	
	}
	
	public int saveAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("insert into admin values(?,?,?,?,?)");
		pst.setInt(1, admin.getAdminId());
		pst.setString(2, admin.getAdminName());
		pst.setLong(3, admin.getAdminContact());
		pst.setString(4, admin.getAdminEmail());
		pst.setString(5, admin.getAdminPassword());
		
		return pst.executeUpdate();
	}
	
	public Admin findByAdminEmail(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("select * from admin where email=?");
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
		return new Admin(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5));
		}
		return null;
	}
	
	public void saveProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("insert into product values(?,?,?,?,?)");
		pst.setInt(1, product.getProductid());
		pst.setString(2, product.getProductName());
		pst.setString(3, product.getProductCategory());
		pst.setString(4, product.getProductBrand());
		pst.setDouble(5, product.getProductPrice());
		pst.execute();
	}
	
	public Product findProductById(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("select * from product where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		}
		return null;
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException{
		Connection connection = getConnection();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		List<Product> allproducts = new ArrayList<Product>();
		while(rs.next()) {
			Product products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
			allproducts.add(products);
		}
		return allproducts;
	}
	
	public void updateProduct (Product p ,int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("update product set name=? , category=? , brand=?, price=? where id=?");
		pst.setString(1, p.getProductName());
		pst.setString(2, p.getProductCategory());
		pst.setString(3, p.getProductBrand());
		pst.setDouble(4, p.getProductPrice());
		pst.setInt(5, p.getProductid());
		pst.execute();
	}
	
	public void deleteProductById(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement("delete from product where id=?");
		pst.setInt(1, id);
		pst.execute();
	}


}

