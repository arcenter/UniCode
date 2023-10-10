// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.lang.Math;
import java.util.Scanner;

class User {
	String user;
	int wins;
	User (String user) {
		this.user = user;
	}
	void win() {
		wins++;
		System.out.println(user + " wins!");
	}
}

public class RPS {

	public static void main(String args[]) {
	
		int pc, cc;
		
		User player   = new User("Player");
		User computer = new User("Computer");
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
		
			cc = (int)(Math.random()*2+1);
			
			System.out.println("Enter 1 for Rock, 2 for Paper, 3 for scissor");
			pc = Integer.parseInt(sc.nextLine());

			System.out.println("Computer chose " + cc);
			
			if (pc == cc) {		
			} else if (pc == 1) {
				if (cc == 2)
					computer.win();
				else
					player.win();
			} else if (pc == 2) {
				if (cc == 1)
					player.win();
				else
					computer.win();
			} else {
				if (cc == 1)
					computer.win();
				else
					player.win();
			}
					
		}
		
		System.out.println("Winner is " + (player.wins > computer.wins ? "Player" : "Computer"));
	
	} 

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
