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
		
		User player = new User("Player");
		User computer = new User("Computer");
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
		
			cc = (int)(Math.random()*3+1);
			
			System.out.println("Enter 1 for Rock, 2 for Paper, 3 for scissor");
			pc = Integer.parseInt(sc.nextLine());
			
			System.out.println("Computer choose " + cc);
			
			if (pc == cc) {		
			} else {
				switch (pc) {
					case 1:
						switch (cc) {
							case 2: computer.win(); break;
							case 3: player.win(); break;
						} break;
					case 2:
						switch (cc) {
							case 1: player.win(); break;
							case 3: computer.win(); break;
						} break;
					case 3:
						switch (cc) {
							case 1: computer.win(); break;
							case 2: player.win(); break;
						}
				}
			}
					
		}
		
		System.out.println("Winner is " + (player.wins > computer.wins ? "Player" : "Computer"));
	
	} 

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
