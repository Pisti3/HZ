package full;

import java.util.Scanner;

public class Main 
{
	//Hi�nyz� b�nuszok:
	//- neh�zs�gi fokozat
	//- lehessen xp-vel fejleszteni
	
	public static void main(String[] args) 
	{
		Scanner help = new Scanner(System.in);
		//String name = help.nextLine();
		
		
		//l�trehozom az inventory-t �s a j�t�kost
		//System.out.println("Mi a neved?");
		Inventory inv = new Inventory();
		Player play = new Player("Player",inv);
		
		
		//l�trehozom a 3 kezd� pok�mont �s mozdulataikat akik k�z�l lehet v�lasztani
		Moves bulbmove = new Moves("Leaf Seed","Scratch","Life Steel","Growl");
		Pokemon bulb = new Pokemon(1, "Bulbusaur", 15, 10, bulbmove, "grass");
		
		//L�trehozom a j�t�knak a class-t �s megadom a j�t�kost �s az � pokemonj�t
		Game full =new Game(play,bulb);
		
		//Hozz�adom a pokemont a j�t�koshoz
		bulb.setPlayer(play);
		
		//Adok a j�t�kosnak 2000$-t �s egy k�zepes potiont hogy ne legyen t�l neh�z a j�t�k az elej�n
		play.getInventory().changeMoney(2000);
		play.getInventory().addItem("Medium Potion");
		
		//Ezzel ind�tom el a j�t�kot
		full.fullGame();
	}

}
