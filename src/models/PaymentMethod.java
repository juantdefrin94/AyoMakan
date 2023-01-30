package models;

public class PaymentMethod {

	private double balance;
	private double disc;
	
	public PaymentMethod(double balance, double disc) {
		this.balance = balance;
		this.disc = disc;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDisc() {
		return disc;
	}
	public void setDisc(double disc) {
		this.disc = disc;
	}
	
	
	

}
