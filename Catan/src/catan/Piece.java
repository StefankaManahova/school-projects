package catan;

public class Piece {
	protected Player player;
	protected String type;
	
	public Piece(Player player, String type) {
		this.player = player;
		this.type = type;
	}
	public void addPoints(){
		if(type.equals("village")) {
			player.score++;
		}
		else if(type.equals("town")) {
			player.score += 2;
		}
	}
}
