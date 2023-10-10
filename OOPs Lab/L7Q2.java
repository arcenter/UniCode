// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

class Number {
    public static int counter = 0;
    int num;
    int count;
    Number(int number) {
        this.num = number;
        count = 1;
        counter += 1;
    }
    void increment() {
        this.count += 1;
    }
}

public class L7Q2 {

    static int getPositionOfNum(Number numCounter[], int n)
        for (int i = 0; i < Number.counter; i++) {
            if (numCounter[i].num == n)
                return i;
        return -1;
    }

    public static Number[] findDuplicates(int numbers[]) {

        Number numCounter[] = new Number[numbers.length];

        for (int number : numbers) {
            int pos = getPositionOfNum(numCounter, number);
            if (pos >= 0)
                numCounter[pos].increment();
            else
                numCounter[Number.counter] = new Number(number);
        }

        return numCounter;
    
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 Numbers = ");

        int numbers[] = new int[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = sc.nextInt();

        Number duplicates[] = new Number[numbers.length];
        duplicates = findDuplicates(numbers);

        for (int i = 0; i < Number.counter; i++)
            if (duplicates[i].count > 1)
                System.out.printf("%d has come %d times\n", duplicates[i].num, duplicates[i].count);

        sc.close();

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
