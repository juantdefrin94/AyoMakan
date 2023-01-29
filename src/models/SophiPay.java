package models;

public class SophiPay extends PaymentMethod implements Payment{
	
	private String paymentName;

	public SophiPay() {
		super(0, 25.0);
		this.paymentName = "ShopiPay";
	}

	public String getPaymentName() {
		return paymentName;
	}

	@Override
	public void pay() {
		
	}

}
