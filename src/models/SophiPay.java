package models;

public class SophiPay {
	
	private String cardName; 
	private Integer balance;
	private Boolean haveCard;
	
	public SophiPay(String cardName, Integer balance, Boolean haveCard) {
		super();
		this.cardName = cardName;
		this.balance = balance;
		this.haveCard = haveCard;
	}
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
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
