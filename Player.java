package full;

public class Player 
{
	private Inventory inventory;
	
	private String name;
	private Pokemon[] pokemons = new Pokemon[6];
	
	//Visszaadja a játékos nevét
	public String getName() {return name;}
	
	//Visszaadja a játékos tulajdonát
	public Inventory getInventory() {return inventory;}
	
	//Hozzáadja a pokemont a játékoshoz
	public void setPokemon(Pokemon a) 
	{
		for(int i=0;i<pokemons.length;i++)
		{
			if(pokemons[i]==null)
			{
				pokemons[i]=a;
				return;
			}
		}
		return;
	}
	
	
	//Objektum
	public Player(String na, Inventory inv) 
	{
		name=na;
		inventory=inv;
	}
}
