// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

class L2Q1 {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		double radius = input.nextInt();

		double diameter = radius * 2;
		double circum = 2 * 3.14 * radius;
		double area = 3.14 * radius * radius;

		System.out.println("Diameter = " + diameter);
		System.out.println("Circumference = " + circum);
		System.out.println("Area = " + area);
	}
}

// Code by arcenter
// https://github.com/arcenter/UniCode/
