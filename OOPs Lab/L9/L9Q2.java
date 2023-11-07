// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.*;

public class L9Q2 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String = ");
        String string = sc.nextLine();
        StringTokenizer st = new StringTokenizer(string, " ");
        String temp = new String();

        while(st.hasMoreTokens()) {
            temp = st.nextToken();
            if(temp.charAt(0) == 'b') {
                System.out.println(temp);
            }
        }

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/