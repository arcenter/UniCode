// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.*;

class L2Q4 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num, pc = 0, nc = 0, zc = 0;
		for (int i = 0; i < 5; i++) {
			num = input.nextInt();
			if (num > 0) pc += 1;
			else if (num < 0) nc += 1;
			else zc += 1;
		}
		System.out.printf("Positive Numbers = %d\nNegative Numbers = %d\nZeros = %d\n", pc, nc, zc);
	}
}

// Code by arcenter
// https://github.com/arcenter/UniCode/
