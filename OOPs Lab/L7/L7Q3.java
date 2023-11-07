// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

public class L7Q3 {

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number = ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print((i*j)+"\t");
            } System.out.println();
        }

        sc.close();

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
