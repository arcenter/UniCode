// Code by arcenter
// https://github.com/arcenter/BPDC/

import java.util.Scanner;

class L2Q2 {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int nu;
		String a = "";
		while (num != 0) {
			nu = num % 10;
			num = num / 10;
			a = nu + " " + a;
		}
		System.out.println(a);
	}
}

// Code by arcenter
// https://github.com/arcenter/BPDC/