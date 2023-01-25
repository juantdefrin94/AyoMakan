package utils;

import java.util.Scanner;

public class Scan {

	public static Scan instance = null;
	private Scanner sc;
	
	private Scan() {
		sc = new Scanner(System.in);
	}
	
	public static Scan getInstance() {
		if(instance == null) {
			instance = new Scan();
		}
		return instance;
	}

	public int getNum() {
		int x = sc.nextInt();
		sc.nextLine();
		return x;
	}
	
	public String getText() {
		String x = sc.nextLine();
		return x;
	}
	
	public void getEnter() {
		sc.nextLine();
	}

}
