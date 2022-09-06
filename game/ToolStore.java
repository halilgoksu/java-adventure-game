package game;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "ToolStore");
	}

	public boolean getLocation() {
		System.out.println("Money : " + player.getMoney());
		System.out.println("1. Weapons");
		System.out.println("2. Armor");
		System.out.println("3. Exit");
		System.out.print("Your Choice : ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}

		return true;
	}
	
	public int armorMenu() {
		System.out.println("1. Easy \t <Money : 15 - Damage : 1>");
		System.out.println("2. Middle \t <Money : 25 - Damage : 3>");
		System.out.println("3. Strong\t <Money : 40 - Damage : 5>");
		System.out.println("4. Exit");
		System.out.print("Pick Your Armor : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	
	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Easy";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Middle";
			price = 15;
			break;
		case 3:
			avoid = 5;
			aName = "Strong";
			price = 40;
			break;
		case 4:
			System.out.println("Exit.");
			break;
		default:
			System.out.println("Invalid action !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " you bought, Blocked Damage : " + player.getInv().getArmor());
				System.out.println("Remaining Money :" + player.getMoney());
			} else {
				System.out.println("not enough money!");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1. Gun\t<Money : 25 - Damage : 2>");
		System.out.println("2. Sword\t<Money : 35 - Damage : 3>");
		System.out.println("3. Rifle\t<Money : 45 - Damage : 7>");
		System.out.println("4. Exit");
		System.out.print("Pick Your weapon : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Gun";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Exit");
			break;
		default:
			System.out.println("not enough money. !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + "You did buy: Your Damage :" + player.getDamage() + ", New damage: "
						+ player.getTotalDamage());
				System.out.println("Your Money:" + player.getMoney());
			} else {
				System.out.println("not enough money !");
			}
		}
	}

}
