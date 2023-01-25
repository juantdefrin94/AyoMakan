package main;

import menu.Menu;

public class Main {

	Menu menu = new Menu();
	
	public Main() {
		int pil = 0;
		while(true) {
			pil = menu.showDefaultMenu();
			switch (pil) {
			case 1:
				menu.loginMenu();
				break;
			case 2:
				menu.registerMenu();
				break;
			default:
				System.out.println("Please Enter 0 - 2!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
