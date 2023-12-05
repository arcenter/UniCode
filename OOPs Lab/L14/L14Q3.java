import java.util.*;

class primeThread extends Thread {

    private Thread t;
    private int limit;

    boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number%i == 0) return false;
        } return true;
    }

    primeThread(int limit) {
        this.limit = limit;
    }

    public void run() {
        int sum = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime(i)) sum += i;
        }
        System.out.println("Sum of primes upto " + limit + " is " + sum);
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "hwT");
            t.start();
        }
    }

}

public class L14Q3 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter limit = ");
        int limit = Integer.parseInt(sc.nextLine());
        sc.close();

        ArrayList<primeThread> threads = new ArrayList<primeThread>();

        for (int i = 0; i <= limit; i++) {
            threads.add(new primeThread(i));
            threads.get(i).start();
        }

    }

}
