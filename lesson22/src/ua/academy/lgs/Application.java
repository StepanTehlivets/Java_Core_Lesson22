package ua.academy.lgs;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		VerhovnaRada vr = VerhovnaRada.VerhovnaRada();
		Fraction fr = new Fraction();

		vr = VerhovnaRada.VerhovnaRada();
		while (true) {
			Menu.menu();
			Scanner sc = new Scanner(System.in);
			switch (sc.next()) {
			case "1": {
				vr.addFraction();
				break;
			}
			case "2": {
				vr.deleteFraction();
				break;
			}
			case "3": {
				vr.printFraction();
				break;
			}
			case "4": {
				vr.clearFraction();
				break;
			}
			case "5": {
				vr.showDeputies();
				break;
			}
			case "6": {
				vr.addDeputyToFraction();
				break;
			}
			case "7": {
				vr.deleteDeputyFromFraction();
				break;
			}
			case "8": {
				vr.showBribers();
				break;
			}
			case "9": {
				vr.showBiggestBriber();
				break;
			}
			default: {
				System.out.println("Whong input");
			}

			}
		}
	}
}
