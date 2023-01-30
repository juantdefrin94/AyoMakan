package state;

import java.util.ArrayList;

import adapter.IPaymentMethod;
import adapter.Pay;
import adapter.PaymentAdapter;
import models.FoodCart;
import models.User;
import utils.Scan;

public class PayState implements IState{

	Scan sc = Scan.getInstance();
	
	@Override
	public boolean doState(FoodCart cart, User currUser) {
		int size = 1;
		int method = 0;
		System.out.println("Choose Your Payment Method");
		if(currUser.getAyoPay() != null && currUser.getSophiPay() != null) {
			System.out.println("1. AyoPay - Rp. " + currUser.getAyoPay().getBalance());
			System.out.println("2. SophiPay - Rp. " + currUser.getSophiPay().getBalance());
			System.out.println("3. Cash");
			size = 3;
		}else if(currUser.getAyoPay() != null) {
			System.out.println("1. AyoPay - Rp. " + currUser.getAyoPay().getBalance());
			System.out.println("2. Cash");
			method = 1;
		}else if(currUser.getSophiPay() != null) {
			System.out.println("1. SophiPay - Rp. " + currUser.getSophiPay().getBalance());
			System.out.println("2. Cash");
			method = 2;
		}else {
			System.out.println("1. Cash");
			method = 3;
		}
		System.out.println("0. Cancel Order");
		
		boolean finish = false;
		int pil = 0;
		double price = 0;
		String paymentName = "";
		while(!finish) {
			System.out.print(">> ");
			pil = sc.getNum();
			switch(pil) {
			 	case 1:
			 		if(method == 1 || size == 3) {
			 			//AyoPay
			 			paymentName = "AyoPay";
			 			price = pay("AyoPay", currUser, cart);
			 			 
			 		}else {
			 			if(method == 3) {
			 				paymentName = "Cash";
				 			price = pay("Cash", currUser, cart);
			 			}else {
			 				//SophiPay
			 				paymentName = "SophiPay";
			 				price = pay("SophiPay", currUser, cart);
			 			}
			 		}
			 		break;
			 	case 2:
			 		if(size == 3) {
			 			//SophiPay
			 			paymentName = "SophiPay";
			 			price = pay("SophiPay", currUser, cart);
			 		}else if(method == 1 || method == 2){
			 			paymentName = "Cash";
			 			price = pay("Cash", currUser, cart);
			 		}else {
			 			sc.showAlert("Please Enter Between [ 0 - 3 ]!");
			 		}
			 		break;
			 	case 3:
			 		if(size == 3) {
			 			paymentName = "Cash";
			 			price = pay("Cash", currUser, cart);
			 		}else {
			 			sc.showAlert("Please Enter Between [ 0 - 3 ]!");
			 		}
			 	case 0:
			 		return false;
			 	default:
			 		sc.showAlert("Please Enter Between [ 0 - 3 ]!");
			 		break;
			}
			
			boolean payNow = false;
			payNow = isPayed(price, currUser, paymentName);
		
			if(!payNow) break;
			else {
				sc.showAlert("Successfully Pay!");
				return true;
			}
			
		}
		
		return false;
	}
	
	private boolean isPayed(double price, User currUser, String paymentName) {
		double balance = 0;
		if(paymentName.equals("AyoPay")) balance = currUser.getAyoPay().getBalance();
		else if(paymentName.equals("SophiPay")) balance = currUser.getSophiPay().getBalance();
		else balance = currUser.getCashPay().getBalance();
		
		String pil = "";
		while(true) {
			System.out.print("Do you want to pay this bill (Rp. " + price + ") (Y/N)? ");
			pil = sc.getText();
			if(pil.equalsIgnoreCase("Y")){
				if(balance - price < 0) return false;
				else {
					if(paymentName.equals("AyoPay")) {
						double temp = currUser.getAyoPay().getBalance();
						currUser.getAyoPay().setBalance(temp - price);
						return true;
					}else if(paymentName.equals("SophiPay")) {
						double temp = currUser.getSophiPay().getBalance();
						currUser.getSophiPay().setBalance(temp - price);
						return true;
					}
					//no need to minus the balance if cash pay
					return true;
				}
			}else if(pil.equalsIgnoreCase("N")) {
				return false;
			}
			
		}
	}

	private double pay(String paymentName, User currUser, FoodCart cart) {
		IPaymentMethod paymentMethod = new PaymentAdapter(paymentName, currUser);
		Pay pay = new Pay();
		pay.setPaymentMethod(paymentMethod);
		
		return pay.payBill(cart.getFinalPrice());
	}

}
