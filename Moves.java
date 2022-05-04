package full;

public class Moves 
{
	private String[] move = new String [4];

	public String[] allMoves() {return move;}
	
	public Moves(String first, String second, String third, String forth)
	{
		move[0] = first;
		move[1] = second;
		move[2] = third;
		move[3] = forth;
	}
}
