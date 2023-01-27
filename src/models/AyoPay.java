package models;

public class AyoPay extends Card{
	
	private Integer balance;
	private Boolean haveCard;
	
	public AyoPay(Integer balance, Boolean haveCard) {
		super();
		this.cardName = "AyoPay";
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
}
