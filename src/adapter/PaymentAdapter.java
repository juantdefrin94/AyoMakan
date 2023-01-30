package adapter;

import models.AyoPay;
import models.SophiPay;
import models.User;

public class PaymentAdapter implements IPaymentMethod {

	private AyoPay ayoPay = null;
	private SophiPay sophiPay = null;
	private String paymentName = "";
	
	public PaymentAdapter(String paymentName, User currUser) {
		this.paymentName = paymentName;
		if(paymentName.equals("AyoPay")) {
			ayoPay =  (AyoPay) currUser.getAyoPay();
		}else if(paymentName.equals("SophiPay")) {
			sophiPay = (SophiPay) currUser.getSophiPay();
		}
	}

	@Override
	public void payingBill(int bill) {
		double disc = 0;
		System.out.println("Total Bill : " + bill);
		if(ayoPay != null) {
			disc = ayoPay.getDisc();
		}else if(sophiPay != null) {
			disc = sophiPay.getDisc();
		}
		System.out.println("Discount : " + disc + "%");
		System.out.println("Payment Method : " + paymentName);
		System.out.println("Total Bill after Discount : " + ((double) bill - (double) bill * disc));
	}

}
