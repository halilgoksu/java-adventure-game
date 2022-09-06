package game;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome Adventure Game!");
		System.out.println("Input Your name Pls : a");
		String playerName = scan.nextLine();
		player = new Player("a");
		player.selectCha();
		start();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=================================================");
			System.out.println();
			System.out.println("Pick A Place : ");
			System.out.println("1. SafeHouse--> A safe place for you, no enemies !");
			System.out.println("2. Cave --> Maybe you can See zombies !");
			System.out.println("3. Forest --> Maybe you can See Vampire!");
			System.out.println("4. River --> Maybe you can See Bear !");
			System.out.println("5. Store --> You can get Weapons or Armor!");
			System.out.print("Where Do You Want To Go : ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("PLS Pick A Place : ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);
			}

			if (location.getClass().getName().equals("game.SafeHouse")) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Congratulations You Won The Game !");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Game Over !");
				break;
			}

		}
	}
}
