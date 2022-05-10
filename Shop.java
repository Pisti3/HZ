package full;

import java.util.Scanner;

public class Shop {
	private String[] items = { "Small Potion", "Medium Potion", "Big Potion" };

	Scanner bolt = new Scanner(System.in);

	public Shop() {
	}

	// A bolti italok kiiratasa és vasarlas eseten a jatekos tulajdonaba helyezese
	// ha van eleg penze
	public void playerBuy(Player a) {
		for (int i = 0; i < items.length; i++) {
			System.out.println((i + 1) + ". " + items[i] + " $" + (i + 1) * 1500);
		}

		System.out.print("What do you want to buy?");
		int number = bolt.nextInt();

		if (a.getInventory().getMoney() >= 1500 * number && number <= 3 && number >= 1) {
			a.getInventory().addItem(items[number - 1]);
			System.out.println("You bought a " + items[number - 1]);
		} else {
			if (number > 3 || number < 1) {
				System.out.println("That was not an option!");
			} else {
				System.out.println("You don't have any money!");
			}
		}
	}

	// A tulajdonban levo italok kiiratasa es eladas eseten a a jatekos kifizetese
	public void playerSell(Player a) {
		System.out.println("I buy everything from you but only for a 1000$");
		System.out.println("What do you want to sell?");

		for (int i = 0; i < a.getInventory().getItem().size(); i++) {
			System.out.println((i + 1) + ". " + a.getInventory().getItem().get(i));
		}

		int number = bolt.nextInt();

		if (number < a.getInventory().getItem().size()) {
			a.getInventory().removeItem(number);
			System.out.println("You sold a " + a.getInventory().getItem().get(number - 1));
			a.getInventory().changeMoney(1000);
		}
	}
}
