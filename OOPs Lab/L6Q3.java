import java.util.Scanner;

class Purse {

    private int dirham;
    private int fils50;
    private int fils25;
    private float total;

    Purse(int dirham, int fils50, int fils25) {
        this.dirham = dirham;
        this.fils50 = fils50;
        this.fils25 = fils25;
    }

    void add_dirham(int amt) {
        this.dirham += amt;
    }
    
    void remove_dirham(int amt) {
        this.dirham -= amt;
    }
    
    void add_fils50(int amt) {
        this.fils50 += amt;
    }
    
    void remove_fils50(int amt) {
        this.fils50 -= amt;
    }
    
    void add_fils25(int amt) {
        this.fils25 += amt;
    }
    
    void remove_fils25(int amt) {
        this.fils25 -= amt;
    }

    void total_cash() {
        this.total = this.dirham + (this.fils50*0.5f) + (this.fils25*0.25f);
        System.out.println("Total Amount = " + this.total);
    }

}

public class L6Q3 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int choice;

        System.out.println("Enter dirhams, 50 fils, and 25 fils count");
        
        Purse purse = new Purse(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        while (true) {
            
            System.out.println("Enter a choice\n1. Add Dirham\n2. Remove Dirham\n3. Add 50 fils\n4. Remove 50 fils\n5. Add 25 fils\n6. Remove 25 fils\n7. Show total\n8. Exit Program");
            
            choice = sc.nextInt();
            
            switch (choice) {

                case 1:
                    System.out.print("Enter Amount to be added: ");
                    purse.add_dirham(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter Amount to be removed: ");
                    purse.remove_dirham(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Amount to be added: ");
                    purse.add_fils50(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Amount to be removed: ");
                    purse.remove_fils50(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Amount to be added: ");
                    purse.add_fils25(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Amount to be removed: ");
                    purse.remove_fils25(sc.nextInt());
                    break;

                case 7:
                    purse.total_cash();
                    break;

                case 8:
                    System.exit(0);

            }
            
        }

    }

}
