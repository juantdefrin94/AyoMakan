package adapter;

public class Pay {

	private IPaymentMethod paymentMethod;
	
	public IPaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(IPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	//passing tagihan yang harus di bayar (mungkin invoice) -> passing invoice (str)
	public double payBill(int bill) {
		return paymentMethod.payingBill(bill);
	}

}
