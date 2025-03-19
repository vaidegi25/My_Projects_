package dto;

public class Product {
	
	int productid;
	String productName;
	String productCategory;
	String productBrand;
	double productPrice;
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Product(int productid, String productName, String productCategory, String productBrand,
			double productPrice) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
	}

}
