package catan;

public class Settlement {
	protected Player player;
	protected String type;
	
	public Settlement(Player player, String type) {
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
