class evenGenerator extends Thread {

    private Thread t;

    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i+" ");
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "even");
            t.start();
        }
    }

}

class oddGenerator extends Thread {

    private Thread t;

    public void run() {
        for (int i = 1; i <= 20; i += 2) {
            System.out.print(i+" ");
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "odd");
            t.start();
        }
    }

}

public class L14Q1 {
    
    public static void main(String args[]) {

        evenGenerator even = new evenGenerator();
        oddGenerator odd = new oddGenerator();

        even.start();
        odd.start();

    }

}
