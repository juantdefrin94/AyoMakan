package models;

public class SophiPay implements Payment{
	
	private String paymentName;
	private Integer balance;
	private Boolean haveCard;
	
	public SophiPay(Integer balance, Boolean haveCard) {
		this.paymentName = "SophiPay";
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
