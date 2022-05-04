package full;

import java.util.ArrayList;
public class Inventory 
{
	private Player player;
	private int money;
	ArrayList<String> item = new ArrayList<String>();
	
	//Visszaadja a pénzt
	public int getMoney() {return money;}
	
	//Visszaadja az item ArrayList-et
	public ArrayList<String> getItem() {return item;}
	
	//Beleteszi az "a" tárgyat a tárgyaid közé
	public void addItem(String a) 
	{
		item.add(a);
	}

	//Kiveszi az "a" indexû tagot a tárgyaid közül
	public void removeItem(int a) 
	{
		player.getInventory().getItem().remove(a);
	}
	
	
	//Megváltoztatod a játékos pénzét "a" öszeggel
	public void changeMoney(int a) 
	{
		money+=a;
	}
	
	
	//Objektum
	public Inventory()
	{
		money=0;
	}
}
