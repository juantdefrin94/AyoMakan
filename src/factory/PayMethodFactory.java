package factory;

import models.AyoPay;
import models.PaymentMethod;
import models.SophiPay;

public class PayMethodFactory {

	public PaymentMethod addPaymentMethod(String paymentName) {
		if(paymentName.equals("AyoPay")) {
			return new AyoPay();
		}else if(paymentName.equals("ShopiPay")) {
			return new SophiPay();
		}
		return null;
	}

}
