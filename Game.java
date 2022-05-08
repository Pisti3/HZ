package full;

import java.io.*;
import java.util.*;

public class Game {
	private Player player;
	private Pokemon pokemon;
	private int time = 12;

	// A fõtérrõl elérhetõ opciók
	private String[] places = { "Poke Center", "Shop", "Forest", "Inventory", "Work", "Pass Time", "Save and Exit" };

	Scanner help = new Scanner(System.in);
	Random rand = new Random();
	Database data = new Database();
	Shop sh = new Shop();

	// visszaadja a játékos pokemonját
	public Pokemon getPokemon() {
		return pokemon;
	}

	// Visszaadja a játékost
	public Player getPlayer() {
		return player;
	}

	// A játék classja ahol a játékos neve és pokemonja el van tárolva
	public Game(Player pl, Pokemon po) {
		player = pl;
		pokemon = po;
	}

	// Ebben a kódban fut le a játék fõ kódja, ez meghív minden más class-ból
	// metódusokat ami neki szükséges
	public void fullGame() {
		while (true) {
			data.ReadFile();
			data.ReadFile2();
			// data.StoreMoves();

			// Köszönés és a helyek kiíratása
			if (time >= 24) {
				time -= 24;
			}
			System.out.println("Hi " + this.player.getName() + " where do you want to go? (" + time + ":00)");
			for (int i = 1; i < places.length + 1; i++) {
				if (i == 1) {
					System.out.println(i + ". " + places[i - 1] + " (2000$)");
				} else {
					System.out.println(i + ". " + places[i - 1]);
				}
			}

			int choice = help.nextInt();

			// Poke Center, 2000$-ért cserébe teljesen felgyógyítja a pokemont
			if (choice == 1) // Poke center or Healing
			{
				if (time >= 22 || time < 6) {
					System.out.println("Sorry, but we're closed.");
				} else {
					if (player.getInventory().getMoney() > 2000) {
						this.pokemon.bigHeal();
						System.out.println("Your Pokemon has been healed!");
						player.getInventory().changeMoney(-2000);
						time += 1;
					} else {
						System.out.println("You don't have enough money!");
					}
				}
			}

			// Bolt, itt van esélye a játékosnak venni vagy eladni a nála lévõ italokat
			else if (choice == 2) // Shop
			{
				if (time >= 22 || time < 6) {
					System.out.println("Sorry, but we're closed.");
				} else {
					System.out.println("1. Buy");
					System.out.println("2. Sell");
					int bolti = help.nextInt();
					if (bolti == 1) {
						sh.playerBuy(this.getPlayer());
						time += 1;
					} else if (bolti == 2) {
						sh.playerSell(this.getPlayer());
						time += 1;
					}
				}

			}

			// Erdõ, itt próbálhat a játékos elmenni csatázni az erdõben
			else if (choice == 3) // Forest or Fight
			{
				if (this.pokemon.getHealth() > 0) {
					this.pokemon.Fight(data.randomPoke());
					time += 1;
				} else {
					System.out.println("Sorry but your Pokemon can't fight.");
				}
			}

			// Tulajdonod, kiiratja a pénzed, a pokemonod xp-ét és a tulajdonodban lévõ
			// tárgyakat
			else if (choice == 4) // Inventory
			{
				System.out.println("Money: " + this.getPlayer().getInventory().getMoney());
				System.out.println("Xp: " + this.getPokemon().getXp());
				System.out.println("Item(s): ");
				if (this.getPlayer().getInventory().getItem().size() > 0) {

					for (int i = 0; i < this.getPlayer().getInventory().getItem().size(); i++) {
						System.out.println("- " + this.getPlayer().getInventory().getItem().get(i));
					}
					System.out.println();
				} else {
					System.out.println("Your inventory is Empty!");
				}
			}

			// A játékosnak van lehetõsége pénzért dolgozni
			else if (choice == 5) {// Work
				if (time >= 20 || time < 8) {
					System.out.println("You knocked, but no one answered.");
				} else {
					System.out.println("You went to work for 4 hours!");
					this.player.getInventory().changeMoney(1000);
					time += 4;
				}
			}

			// A játékosnak van lehetõsége pihenni pár óráig (Mivel este nem biztos hogy tud
			// bármit is csinálni)
			else if (choice == 6) {// Pass Time
				time += 2;
			}

			// Kilépés, ezt az opciót választva a játék kilép és lementi a játékos adatait
			else if (choice == 7) { // Exit
				System.out.println("Goodbye!");
				File f = new File("Playerdata.txt");

				try {
					if (f.exists()) {
						BufferedWriter writer = new BufferedWriter(new FileWriter("Playerdata.txt", true));
						writer.append(String.valueOf(player.getInventory().getMoney()));
						for(int i=0;i<player.getInventory().getItem().size(); i++) {
							writer.append(", " + player.getInventory().getItem().get(i));
						}
						writer.newLine();
						writer.append(pokemon.getName() + ", " + pokemon.getRank() + pokemon.getXp() + ", "
								+ pokemon.getHealth() + ", " + pokemon.getAttack() + ", " + pokemon.getDefense());
						writer.newLine();
						writer.close();
					} else if (!f.exists()) {
						f.createNewFile();
						BufferedWriter writer = new BufferedWriter(new FileWriter("Playerdata.txt", true));
						writer.append(String.valueOf(player.getInventory().getMoney()));
						for(int i=0;i<player.getInventory().getItem().size(); i++) {
							writer.append(", " + player.getInventory().getItem().get(i));
						}
						writer.newLine();
						writer.append(pokemon.getName() + ", " + pokemon.getRank() + pokemon.getXp() + ", "
								+ pokemon.getHealth() + ", " + pokemon.getAttack() + ", " + pokemon.getDefense());
						writer.newLine();
						writer.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				return;
			} else {
				fullGame();
			}
			System.out.println();
		}
	}
}
