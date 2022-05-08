package full;

import java.io.*;
import java.util.*;

public class Game {
	private Player player;
	private Pokemon pokemon;
	private int time = 12;

	// A f�t�rr�l el�rhet� opci�k
	private String[] places = { "Poke Center", "Shop", "Forest", "Inventory", "Work", "Pass Time", "Save and Exit" };

	Scanner help = new Scanner(System.in);
	Random rand = new Random();
	Database data = new Database();
	Shop sh = new Shop();

	// visszaadja a j�t�kos pokemonj�t
	public Pokemon getPokemon() {
		return pokemon;
	}

	// Visszaadja a j�t�kost
	public Player getPlayer() {
		return player;
	}

	// A j�t�k classja ahol a j�t�kos neve �s pokemonja el van t�rolva
	public Game(Player pl, Pokemon po) {
		player = pl;
		pokemon = po;
	}

	// Ebben a k�dban fut le a j�t�k f� k�dja, ez megh�v minden m�s class-b�l
	// met�dusokat ami neki sz�ks�ges
	public void fullGame() {
		while (true) {
			data.ReadFile();
			data.ReadFile2();
			// data.StoreMoves();

			// K�sz�n�s �s a helyek ki�rat�sa
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

			// Poke Center, 2000$-�rt cser�be teljesen felgy�gy�tja a pokemont
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

			// Bolt, itt van es�lye a j�t�kosnak venni vagy eladni a n�la l�v� italokat
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

			// Erd�, itt pr�b�lhat a j�t�kos elmenni csat�zni az erd�ben
			else if (choice == 3) // Forest or Fight
			{
				if (this.pokemon.getHealth() > 0) {
					this.pokemon.Fight(data.randomPoke());
					time += 1;
				} else {
					System.out.println("Sorry but your Pokemon can't fight.");
				}
			}

			// Tulajdonod, kiiratja a p�nzed, a pokemonod xp-�t �s a tulajdonodban l�v�
			// t�rgyakat
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

			// A j�t�kosnak van lehet�s�ge p�nz�rt dolgozni
			else if (choice == 5) {// Work
				if (time >= 20 || time < 8) {
					System.out.println("You knocked, but no one answered.");
				} else {
					System.out.println("You went to work for 4 hours!");
					this.player.getInventory().changeMoney(1000);
					time += 4;
				}
			}

			// A j�t�kosnak van lehet�s�ge pihenni p�r �r�ig (Mivel este nem biztos hogy tud
			// b�rmit is csin�lni)
			else if (choice == 6) {// Pass Time
				time += 2;
			}

			// Kil�p�s, ezt az opci�t v�lasztva a j�t�k kil�p �s lementi a j�t�kos adatait
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
