package models;

public class CashPay implements Payment{

	private String paymentName;
	private Integer balance;
	private Boolean haveCard;
	
	public CashPay(Integer balance, Boolean haveCard) {
		super();
		this.paymentName = "Cash";
		this.balance = balance;
		this.haveCard = haveCard;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Boolean getHaveCard() {
		return haveCard;
	}

	public void setHaveCard(Boolean haveCard) {
		this.haveCard = haveCard;
	}

	public String getPaymentName() {
		return paymentName;
	}

	@Override
	public void pay() {
		
	}
	
}
