package full;

import java.io.*;
import java.util.*;

public class Game {
	private Player player;
	private Pokemon pokemon;
	
	//A f�t�rr�l el�rhet� opci�k
	private String[] places = { "Poke Center", "Shop", "Forest", "Inventory", "Save and Exit" };

	Scanner help = new Scanner(System.in);
	Random rand = new Random();
	Database data = new Database();
	Shop sh = new Shop();

	//visszaadja a j�t�kos pokemonj�t
	public Pokemon getPokemon() {
		return pokemon;
	}

	//Visszaadja a j�t�kost
	public Player getPlayer() {
		return player;
	}

	//A j�t�k classja ahol a j�t�kos neve �s pokemonja el van t�rolva
	public Game(Player pl, Pokemon po) {
		player = pl;
		pokemon = po;
	}

	
	//Ebben a k�dban fut le a j�t�k f� k�dja, ez megh�v minden m�s class-b�l met�dusokat ami neki sz�ks�ges
	public void fullGame() {
		while (true) {
			data.ReadFile();
			data.ReadFile2();
			//data.StoreMoves();
			
			//K�sz�n�s �s a helyek ki�rat�sa
			System.out.println("Hi " + this.player.getName() + " where do you want to go?");
			for (int i = 1; i < places.length+1; i++) {
				if (i==1) {
					System.out.println(i + ". " + places[i-1] + " (2000$)");
				}
				else {
					System.out.println(i + ". " + places[i-1]);
				}
			}
			
			int choice = help.nextInt();
			
			//Poke Center, 2000$-�rt cser�be teljesen felgy�gy�tja a pokemont
			if (choice == 1) // Poke center or Healing
			{
				System.out.println("The PokeCenter costs 2000$");
				if (player.getInventory().getMoney()>2000)
				{
					this.pokemon.bigHeal();
					System.out.println("Your Pokemon has been healed!");
					player.getInventory().changeMoney(-2000);
				}
				else {
					System.out.println("You don't have enough money!");
				}	
			}
			
			
			//Bolt, itt van es�lye a j�t�kosnak venni vagy eladni a n�la l�v� italokat
			else if (choice == 2) // Shop
			{
				System.out.println("1. Buy");
				System.out.println("2. Sell");
				int bolti = help.nextInt();
				if (bolti == 1) {
					sh.playerBuy(this.getPlayer());
				} else if (bolti == 2) {
					sh.playerSell(this.getPlayer());
				} else {
					fullGame();
				}
			} 
			
			
			//Erd�, itt pr�b�lhat a j�t�kos elmenni csat�zni az erd�ben
			else if (choice == 3) // Forest or Fight
			{
				this.pokemon.Fight(data.randomPoke());
			}
			
			
			//Tulajdonod, kiiratja a p�nzed, a pokemonod xp-�t �s a tulajdonodban l�v� t�rgyakat
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
				}else {
					System.out.println("Your inventory is Empty!");
				}
			}
			
			
			//Kil�p�s, ezt az opci�t v�lasztva a j�t�k kil�p �s lementi a j�t�kos adatait
			else if (choice == 5) { // Exit
				System.out.println("Goodbye!");
				File f = new File("Playerdata.txt");
			
				try {
				      if (!f.exists()) {
				        f.createNewFile();
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
