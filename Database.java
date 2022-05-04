package full;

import java.util.*;
import java.io.*;

public class Database {
	ArrayList<Moves> movedata = new ArrayList<Moves>();
	ArrayList<Pokemon> pokedata = new ArrayList<Pokemon>();
	Random rand = new Random();

	// Mozdulatok soronkénti beolvasása fájlból és létrehozásuk
	public void ReadFile() {
		try {
			Scanner reader = new Scanner(new File("Movedata.txt"));
			while (reader.hasNextLine()) {
				String[] readmove = reader.nextLine().split(", ");
				Moves move = new Moves(readmove[0], readmove[1], readmove[2], readmove[3]);
				movedata.add(move);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Pokemonok soronkénti beolvasása fájlból és létrehozásuk
	public void ReadFile2() {
		try {
			Scanner reader = new Scanner(new File("Pokemondata.txt"));
			while (reader.hasNextLine()) {
				String[] readmove = reader.nextLine().split(", ");	
				if (readmove[4].equals("grass")) {
					Pokemon poke = new Pokemon(Integer.parseInt(readmove[0]), readmove[1], Integer.parseInt(readmove[2]), Integer.parseInt(readmove[3]) , movedata.get(0), readmove[4]);
					pokedata.add(poke);
				}
				else if (readmove[4].equals("fire")) {
					Pokemon poke = new Pokemon(Integer.parseInt(readmove[0]), readmove[1], Integer.parseInt(readmove[2]), Integer.parseInt(readmove[3]) , movedata.get(1), readmove[4]);
					pokedata.add(poke);
				}
				else if (readmove[4].equals("water")) {
					Pokemon poke = new Pokemon(Integer.parseInt(readmove[0]), readmove[1], Integer.parseInt(readmove[2]), Integer.parseInt(readmove[3]) , movedata.get(2), readmove[4]);
					pokedata.add(poke);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Maybe creat your own pokemon?
	// String[] readpoke = reader.nextLine().split(", ");
	// Pokemon poke = new Pokemon(Integer.parseInt(readpoke[0]), readpoke[1],
	// Integer.parseInt(readpoke[2]),Integer.parseInt(readpoke[3]), move,
	// readpoke[4]);

	
	//Pokemonok véletlenszerû kiválasztása a harcban
	public Pokemon randomPoke() {
		int rando = rand.nextInt(pokedata.size());
		pokedata.get(rando).bigHeal();
		return pokedata.get(rando);
	}

	public Database() {}
}
