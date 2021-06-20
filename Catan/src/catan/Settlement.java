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
			player.score ++;//we build the town over an existing village so the score increases by 1 point in total
		}
	}
	public void addResources(String resource) {
		if(type.equals("village")) {
			player.addResources(resource, 1);
		}
		else if(type.equals("town")) {
			player.addResources(resource, 2);
		}
	}
}
