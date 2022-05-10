package full;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	//Player
	//Player nev�nek tesztel�se
	@org.junit.jupiter.api.Test
	public void testPlayerName() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		String a = "Sajt";
		
		assertEquals(a, pl.getName());
	}

	//Player inventory �s a l�trehozott inventory ugyan az-e
	@org.junit.jupiter.api.Test
	public void testPlayerInventory() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		assertSame(inv, pl.getInventory());
	}
	
	//Game
	//Game player ugyan az e mint a l�trehozott player
	@org.junit.jupiter.api.Test
	public void testGamePlayer() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "f�");
		
		Game g = new Game(pl, po);
		assertSame(pl, g.getPlayer());
	}
	//Game pokemon ugyan az e mint a l�trehozott pokemon
	@org.junit.jupiter.api.Test
	public void testGamePokemon() {
		Inventory inv = new Inventory();
		Player pl = new Player("Sajt", inv);
		
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "f�");
		
		Game g = new Game(pl, po);
		assertSame(po, g.getPokemon());
	}
	
	
	//Pokemon
	//Megn�zi hogy a Pokemon neve egyezik a megadott String-el
	@org.junit.jupiter.api.Test
	public void testPokemonName() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "f�");

		String a = "Bulbasaur";
		assertEquals(a, po.getName());
	}

	//Megn�zi hogy a Pokemon rank-ja egyezik a megadott int-el
	@org.junit.jupiter.api.Test
	public void testPokemonRank() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 10, mov, "f�");

		int a = 1;
		assertEquals(a, po.getRank());
	}

	//Megn�zi hogy a Pokemon t�mad�sa egyezik a megadott double-el
	@org.junit.jupiter.api.Test
	public void testPokemonAttack() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 20, 10, mov, "f�");

		double a = 20;
		assertEquals(a, po.getAttack());
	}
	
	//Megn�zi hogy a Pokemon v�delme egyezik a megadott double-el
	@org.junit.jupiter.api.Test
	public void testPokemonDefense() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(1, "Bulbasaur", 10, 15, mov, "f�");

		double a = 15;
		assertEquals(a, po.getDefense());
	}
	
	//Megn�zi hogy a Pokemon �lete egyezik a megadott int-el
	@org.junit.jupiter.api.Test
	public void testPokemonHealth() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(2, "Bulbasaur", 10, 10, mov, "f�");

		int a = po.getRank()*50;
		assertEquals(a, po.getHealth());
	}
	
	//Megn�zi hogy a Pokemon mozdulata ugyan az e mint a l�trehozott mozdulat
	@org.junit.jupiter.api.Test
	public void testPokemonMoves() {
		Moves mov = new Moves("a", "b", "c", "d");
		Pokemon po = new Pokemon(2, "Bulbasaur", 10, 10, mov, "f�");

		assertEquals(mov, po.getMoves());
	}

}
