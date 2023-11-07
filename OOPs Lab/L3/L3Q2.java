// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

class Player {
	int number;
	public void guess(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
}

class GuessGame {
	int randomNumber;
	GuessGame() {
		this.randomNumber = (int)(Math.random() * 10);
	}
	public int getCorrectValue() {
		return randomNumber;
	}
}

public class L3Q2
{
	public static void main(String[] args) {

		GuessGame game1 = new GuessGame();

		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter 3 guesses");

		Player players[] = {p1, p2, p3};

		for (Player p : players)
			p.guess(input.nextInt());

		System.out.println("\nCorrect guess is " + game1.getCorrectValue() + "\n");

		for (int i = 0; i < players.length; i++) {
			if (players[i].getNumber() == game1.getCorrectValue())
				System.out.printf("Player %d got it right\n\n", (i+1));
		}


	}
}

// Code by arcenter
// https://github.com/arcenter/UniCode/
