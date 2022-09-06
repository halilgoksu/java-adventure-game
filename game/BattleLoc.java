package game;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Now You are Here : " + this.getName());
		System.out.println("Be Careful   " + obsCount + "  " + obstacle.getName() + " Live !");
		System.out.print("<H>Hit or <E>Escape :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("H")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " You did  kill all enemy !");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " You Won ");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " You Won ");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " You Won  ");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			
			if(player.getHealthy() <= 0) {
				System.out.println("You Won  !");
				return false;
			}
		
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<H>Hit or <E>Escape :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You did Hit!");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("Monster Did Hit You !");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("You Won !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Your Money : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Player values \n--------------");
		System.out.println("Live:" + player.getHealthy());
		System.out.println("Damage:" + player.getTotalDamage());
		System.out.println("Money:" + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Gun:" + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor:" + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " Value\n--------------");
		System.out.println("Health:" + obstacle.getHealth());
		System.out.println("Damage:" + obstacle.getDamage());
		System.out.println("Award:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Player Healthy:" + player.getHealthy());
		System.out.println(obstacle.getName() + " Healthy:" + obstacle.getHealth());
		System.out.println();
	}

}
