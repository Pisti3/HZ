package full;

import java.util.ArrayList;
public class Inventory 
{
	private Player player;
	private int money;
	ArrayList<String> item = new ArrayList<String>();
	
	//Visszaadja a p�nzt
	public int getMoney() {return money;}
	
	//Visszaadja az item ArrayList-et
	public ArrayList<String> getItem() {return item;}
	
	//Beleteszi az "a" t�rgyat a t�rgyaid k�z�
	public void addItem(String a) 
	{
		item.add(a);
	}

	//Kiveszi az "a" index� tagot a t�rgyaid k�z�l
	public void removeItem(int a) 
	{
		player.getInventory().getItem().remove(a);
	}
	
	
	//Megv�ltoztatod a j�t�kos p�nz�t "a" �szeggel
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
