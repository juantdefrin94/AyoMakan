package models;

public class AyoPay extends PaymentMethod implements Payment{
	
	private String paymentName;
	
	public AyoPay() {
		super(0, 50.0);
		this.paymentName = "AyoPay";
	}
	
	public String getPaymentName() {
		return paymentName;
	}

	@Override
	public void pay() {
		
	}
	
}
