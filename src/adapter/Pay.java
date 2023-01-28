package adapter;

public class Pay {

	private PaymentMethod paymentMethod;
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	//passing tagihan yang harus di bayar (mungkin invoice) -> passing invoice (str)
	public void payBill(int bill) {
		
	}

}
