package models;

public class User {

	private String username;
	private String password;
	private PaymentMethod ayoPay = null;
	private PaymentMethod shopiPay = null;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PaymentMethod getAyoPay() {
		return ayoPay;
	}

	public void setAyoPay(PaymentMethod ayoPay) {
		this.ayoPay = ayoPay;
	}

	public PaymentMethod getShopiPay() {
		return shopiPay;
	}

	public void setShopiPay(PaymentMethod shopiPay) {
		this.shopiPay = shopiPay;
	}

}
