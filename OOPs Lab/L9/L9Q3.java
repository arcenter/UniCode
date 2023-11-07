// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

public class L9Q3 {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Phone Number = ");
        String pn = sc.nextLine();

        int length = pn.length();
        if (length == 14) {
            System.out.println("Country code = " + pn.substring(0, 5));
            System.out.println("Mobile Number - " + pn.substring(5, 7));
        } else if (length == 13){
            System.out.println("Country code = " + pn.substring(0, 5));
            System.out.println("Landline - " + pn.charAt(5));
        } else {
            System.out.println("Invalid Number");
        }

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/