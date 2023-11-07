// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

public class L9Q4 {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String = ");
        String s1 = sc.nextLine().toLowerCase();
        
        System.out.print("Enter another String = ");
        String s2 = sc.nextLine().toLowerCase();

        int count1[] = new int[26];
        int count2[] = new int[26];

        int ascii;

        for (int i = 0; i < s1.length(); i++) {
            ascii = (int)(s1.charAt(i));
            if (ascii > 96 && ascii < 123) {
                count1[ascii-96] += 1;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            ascii = (int)(s2.charAt(i));
            if (ascii > 96 && ascii < 123) {
                count2[ascii-96] += 1;
            }
        }

        boolean x = true;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) continue;
            System.out.println("Not an anagram");
            x = false;
            break;
        }
        if (x) System.out.println("Is is an anagram");

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/