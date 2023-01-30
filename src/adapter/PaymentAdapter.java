package adapter;

import models.AyoPay;
import models.CashPay;
import models.SophiPay;
import models.User;

public class PaymentAdapter implements IPaymentMethod {

	private AyoPay ayoPay = null;
	private SophiPay sophiPay = null;
	private CashPay cashPay = null;
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
	public double payingBill(int bill) {
		double disc = 0;
		System.out.println("Total Bill : " + bill);
		if(ayoPay != null) {
			disc = ayoPay.getDisc();
		}else if(sophiPay != null) {
			disc = sophiPay.getDisc();
		}else {
			disc = 0;
		}
		System.out.println("Payment Method : " + paymentName);
		System.out.println("Discount : " + disc + "%");
		double totalAfterDisc = ((double) bill - (double) bill * disc / 100.0);
		System.out.println("Total Bill after Discount : " + totalAfterDisc);
		return totalAfterDisc;
	}

}
