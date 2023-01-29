package models;

public class CashPay extends PaymentMethod implements Payment{

	private String paymentName;
	
	public CashPay() {
		super(0, 0);
		this.paymentName = "Cash";
	}

	public String getPaymentName() {
		return paymentName;
	}

	@Override
	public void pay() {
		
	}
	
}
