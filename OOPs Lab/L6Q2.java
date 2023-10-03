// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

public class L6Q2 {
    
    public static void main(String args[]) {

        float nums[] = new float[10];

        Scanner sc = new Scanner(System.in);

        float min, max, avg = 0;

        System.out.println("Enter 10 Numbers");
        
        nums[0] = sc.nextFloat();
        min = nums[0];
        max = nums[0];
        avg += nums[0];

        for (int i = 1; i < 10; i++) {
            nums[i] = sc.nextFloat();

            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            avg += nums[i];
        }

        avg /= 10;

        System.out.println("Minimum Number = " + min);
        System.out.println("Maximum Number = " + max);
        System.out.println("Average = " + avg);

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
