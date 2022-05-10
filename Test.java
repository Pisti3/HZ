package full;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	//Player
	//Player nevének tesztelése
	@org.junit.jupiter.api.Test
	public void testPlayerName() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		String a = "Sajt";
		
		assertEquals(a, pl.getName());
	}

	//Player inventory és a létrehozott inventory ugyan az-e
	@org.junit.jupiter.api.Test
	public void testPlayerInventory() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		assertSame(inv, pl.getInventory());
	}
	
	//Game
	//Game player ugyan az e mint a létrehozott player
	@org.junit.jupiter.api.Test
	public void testGamePlayer() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "fû");
		
		Game g = new Game(pl, po);
		assertSame(pl, g.getPlayer());
	}
	//Game pokemon ugyan az e mint a létrehozott pokemon
	@org.junit.jupiter.api.Test
	public void testGamePokemon() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "fû");
		
		Game g = new Game(pl, po);
		assertSame(po, g.getPokemon());
	}
	
	
	//Pokemon
	//Megnézi hogy a Pokemon neve egyezik a megadott String-el
	@org.junit.jupiter.api.Test
	public void testPokemonName() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "fû");

		String a = "Bulbasaur";
		assertEquals(a, po.getName());
	}

	//Megnézi hogy a Pokemon rank-ja egyezik a megadott int-el
	@org.junit.jupiter.api.Test
	public void testPokemonRank() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "fû");

		int a = 1;
		assertEquals(a, po.getRank());
	}

	//Megnézi hogy a Pokemon támadása egyezik a megadott double-el
	@org.junit.jupiter.api.Test
	public void testPokemonAttack() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 20, 10, mov, "fû");

		double a = 20;
		assertEquals(a, po.getAttack());
	}
	
	//Megnézi hogy a Pokemon védelme egyezik a megadott double-el
	@org.junit.jupiter.api.Test
	public void testPokemonDefense() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 15, mov, "fû");

		double a = 15;
		assertEquals(a, po.getDefense());
	}
	
	//Megnézi hogy a Pokemon élete egyezik a megadott int-el
	@org.junit.jupiter.api.Test
	public void testPokemonHealth() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(2, "Bulbasaur", 10, 10, mov, "fû");

		int a = po.getRank()*50;
		assertEquals(a, po.getHealth());
	}
	
	//Megnézi hogy a Pokemon mozdulata ugyan az e mint a létrehozott mozdulat
	@org.junit.jupiter.api.Test
	public void testPokemonMoves() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(2, "Bulbasaur", 10, 10, mov, "fû");

		assertEquals(mov, po.getMoves());
	}

}
