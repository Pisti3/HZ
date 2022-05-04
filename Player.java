package full;

public class Player 
{
	private Inventory inventory;
	
	private String name;
	private Pokemon[] pokemons = new Pokemon[6];
	
	//Visszaadja a j�t�kos nev�t
	public String getName() {return name;}
	
	//Visszaadja a j�t�kos tulajdon�t
	public Inventory getInventory() {return inventory;}
	
	//Hozz�adja a pokemont a j�t�koshoz
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
