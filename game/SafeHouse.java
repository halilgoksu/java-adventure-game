package game;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "SafeHouse");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Healthy %100...");
		System.out.println("Now You Are at SafeHouse");
		return true;
	}

}
