package dto;

public class Admin {
	
	int adminId;
	String adminName;
	long adminContact;
	String adminEmail;
	String adminPassword;
	
	
	public Admin(int adminId, String adminName, long adminContact, String adminEmail, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	

}
