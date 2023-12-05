class hwThread extends Thread {

    private Thread t;

    public void run() {
        System.out.println("Hello world!");
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "hwT");
            t.start();
        }
    }

}

public class L14Q1 {
    
    public static void main(String args[]) {

        hwThread hwT = new hwThread();

        hwT.start();

    }

}
