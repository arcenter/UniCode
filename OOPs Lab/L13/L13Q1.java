// Code by arcenter
// https://github.com/arcenter/UniCode/

class CustomException extends Exception {
    public CustomException() {
        super("Cannot find prime for negative range");
    }
}

class Prime {

    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    Prime(int lower, int upper) throws CustomException {
        if (lower < 0 || upper < 0) {
            // throw new IllegalArgumentException();
            throw new CustomException();
        }
        for (int i = lower+1; i < upper; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        } System.out.println();
    }

}

public class L13Q1 {
    public static void main(String args[]) throws CustomException {
        Prime prime1 = new Prime(20, 50);
        Prime prime2 = new Prime(-20, 50);
    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/