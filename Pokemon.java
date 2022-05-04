package full;

import java.util.Random;
import java.util.Scanner;

public class Pokemon {
	Random rand = new Random();
	Scanner help = new Scanner(System.in);

	private Moves moves;
	private Player player;

	private int def = 0;
	private int rank;
	private String name;
	private double health;
	private double attack;
	private double defense;
	private int xp;
	private Player owner;
	private String type;
	private String[] options = { "Attack", "Defend", "Run" };

	// Evolúció lekérése
	public int getRank() {
		return rank;
	}

	// Pokemon nevének lekérése
	public String getName() {
		return name;
	}

	// Pokemon életének lekérése
	public double getHealth() {
		return health;
	}

	// Pokemon támadásának lekérése
	public double getAttack() {
		return attack;
	}

	// Pokemon védekezésének lekérése
	public double getDefense() {
		return defense;
	}

	// Pokemon xp-nek lekérése
	public int getXp() {
		return xp;
	}

	// Pokemon mozdulatainak lekérése
	public Moves getMoves() {
		return moves;
	}

	// Csata előtti adatok kiiratása
	public String toString() {
		System.out.println("Name: " + this.name);
		System.out.println("Health: " + this.health);
		System.out.println("Attack: " + this.attack);
		System.out.println("Defense: " + this.defense);
		return "";
	}

	// A játékost beállítjuk a pokemon tulajdonosának
	public Player setPlayer(Player a) {
		owner = a;
		return player;
	}

	// Levonunk "a" mennyiségű életet
	public void minusHealth(double a) {
		health = health - a;
	}

	// Feltöltünk 25% életet
	public void smallHeal() {
		if (health + (health * 0.25) > 50*rank) {
			health = 50*rank;
		} else {
			health += (health * 0.25);
		}
	}

	// Feltöltünk 50% életet
	public void mediumHeal() {
		if (health + (health * 0.5) > 50*rank) {
			health = 50*rank;
		} else {
			health += (health * 0.5);
		}
	}

	// Feltöltünk 100% életet
	public void bigHeal() {
		health = 50*rank;
	}

	// Visszaugrani a kezdő választásokhoz
	// Kéne valami loop
	// Nem kéne minden ütésre 100% esély

	// 2 pokemon közötti harcot lejátszó kód
	public void Fight(Pokemon b) {
		this.toString();
		System.out.println();
		System.out.println("VS");
		System.out.println();
		b.toString();
		System.out.println();

		// Addig fut amíg valaki le nem győzi a másikat
		//Ha a játékos győz akkor kap 0-1000 közt pénzt és 0 - rank*50 közötti xp-t
		while (true) {
			def = 1;
			// your turn
			System.out.println("What's your choice?");
			for (int i = 0; i < this.options.length; i++) {
				System.out.println((i + 1) + ". " + this.options[i]);
			}

			int option = help.nextInt();

			//Harcolás az ellenféllel
			if (option == 1) {
				System.out.println("What's your choice?");
				for (int i = 0; i < this.moves.allMoves().length; i++) {
					System.out.println((i + 1) + ". " + this.moves.allMoves()[i]);
				}
				int choice = help.nextInt();
				if (choice < 5 && choice > 0) {
					System.out.println(this.name + " used " + this.moves.allMoves()[choice - 1] + "!");
					System.out.println(this.moves.allMoves()[choice - 1] + " caused " + this.attack + " damage!");
					b.minusHealth(this.attack);
					if (b.health <= 0) {
						int randmoney = rand.nextInt(1000);
						int randxp = rand.nextInt((b.getRank() - 1) * 50, b.getRank() * 50);
						System.out.println("Congratulations, you won!");
						System.out.println("You earned " + randmoney + "$ and " + randxp + " xp");
						this.owner.getInventory().changeMoney(randmoney);
						this.xp += randxp;
						return;
					} else {
						System.out.println(b.name + " " + "-".repeat(((int) b.health) / 5));
					}
				} else {
					break;
				}

			// Védekezés esetén a védekezés növelése
			} else if (option == 2) {
				def = 2;
			}

			// Elfutni probálkozás
			else if (option == 3) {
				int run = rand.nextInt(100);
				if (run > 50) {
					System.out.println("You managed to escape!");
					return;
				} else {
					System.out.println("You didn't manage to escape!");
				}
			} else {
				break;
			}

			System.out.println();

			// ellenfél köre
			int randmove = rand.nextInt(4);
			System.out.println(b.name + " used " + b.moves.allMoves()[randmove] + "!");
			System.out.println(b.moves.allMoves()[randmove] + " caused " + (b.attack / def) + " damage!");
			this.minusHealth(b.attack / def);
			if (this.health <= 0) {
				System.out.println("Sorry but you lost.");
				return;
			} else {
				System.out.println(this.name + " " + "-".repeat(((int) this.health) / 5));
			}

			System.out.println();
		}
	}

	// Pokemon objektum
	public Pokemon(int evo, String na, double at, double de, Moves mo, String ty) {
		rank = evo;
		name = na;
		health = 50;
		attack = at;
		defense = de;
		moves = mo;
		type = ty;
		owner = player;
		xp = 0;
	}
}
