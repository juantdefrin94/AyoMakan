package models;

public class PaymentMethod {

	private int balance;
	private double disc;
	
	public PaymentMethod(int balance, double disc) {
		this.balance = balance;
		this.disc = disc;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getDisc() {
		return disc;
	}
	public void setDisc(double disc) {
		this.disc = disc;
	}
	
	
	

}
