package models;

public class CashPay extends PaymentMethod implements Payment{

	private String paymentName;
	
	public CashPay() {
		super(1000000000, 0);
		this.paymentName = "Cash";
	}

	public String getPaymentName() {
		return paymentName;
	}

	@Override
	public void pay() {
		
	}
	
}
