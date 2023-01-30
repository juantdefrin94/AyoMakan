package models;

public class User {

	private String username;
	private String password;
	private PaymentMethod ayoPay = null;
	private PaymentMethod sophiPay = null;
	private PaymentMethod cashPay = null;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		cashPay = new CashPay();
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

	public PaymentMethod getSophiPay() {
		return sophiPay;
	}

	public void setSophiPay(PaymentMethod sophiPay) {
		this.sophiPay = sophiPay;
	}

	public PaymentMethod getCashPay() {
		return cashPay;
	}

	public void setCashPay(PaymentMethod cashPay) {
		this.cashPay = cashPay;
	}
}
