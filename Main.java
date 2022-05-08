package full;

import java.util.Scanner;

public class Main 
{
	//Hiányzó bónuszok:
	//- nehézségi fokozat
	//- lehessen xp-vel fejleszteni
	
	public static void main(String[] args) 
	{
		Scanner help = new Scanner(System.in);
		//String name = help.nextLine();
		
		
		//létrehozom az inventory-t és a játékost
		//System.out.println("Mi a neved?");
		Inventory inv = new Inventory();
		Player play = new Player("Player",inv);
		
		
		//létrehozom a 3 kezdõ pokémont és mozdulataikat akik közül lehet választani
		Moves bulbmove = new Moves("Leaf Seed","Scratch","Life Steel","Growl");
		Pokemon bulb = new Pokemon(1, "Bulbusaur", 15, 10, bulbmove, "grass");
		
		//Létrehozom a játéknak a class-t és megadom a játékost és az õ pokemonját
		Game full =new Game(play,bulb);
		
		//Hozzáadom a pokemont a játékoshoz
		bulb.setPlayer(play);
		
		//Adok a játékosnak 2000$-t és egy közepes potiont hogy ne legyen túl nehéz a játék az elején
		play.getInventory().changeMoney(2000);
		play.getInventory().addItem("Medium Potion");
		
		//Ezzel indítom el a játékot
		full.fullGame();
	}

}
