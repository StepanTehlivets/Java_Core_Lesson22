package ua.academy.lgs2;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


public class Application {
public static void main(String[] args) {
	LinkedHashSet<Commodity> CommodityList = new LinkedHashSet<Commodity>();
	Scanner sc = new Scanner(System.in);
	while (true) {
		Menu.menu();
		switch (sc.nextInt()) {
		case 1: {
			Methods.add.manipulate(CommodityList);
			break;
		}
		case 2: {
			Methods.remove.manipulate(CommodityList);
			break;
		}
		case 3: {
			Methods.switchCommodity.manipulate(CommodityList);
			break;
		}
		case 4: {
			Methods.sortByName.manipulate(CommodityList);
			break;
		}
		case 5: {
			Methods.sortByLength.manipulate(CommodityList);
			break;
		}
		case 6: {
			Methods.sortByWidth.manipulate(CommodityList);
			break;
		}
		case 7: {
			Methods.sortByWeight.manipulate(CommodityList);
			break;
		}
		case 8: {
			Methods.showIElement.manipulate(CommodityList);
			break;
		}
		case 9: {
			System.exit(0);
			break;
		}

		}

	}
}




}
