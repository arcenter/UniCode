// Code by arcenter
// https://github.com/BPDC/

class q2 {
        public static void main(String args[]) {

                SavingsAccount sa1 = new SavingsAccount(10d);
                SavingsAccount sa2 = new SavingsAccount(50d);
                SavingsAccount sa3 = new SavingsAccount(100d);

                SavingsAccount.modifyInterestRate(4d);
                SavingsAccount sa[] = {sa1, sa2, sa3};

                for (SavingsAccount saa : sa) {
                        saa.calculateMonthlyInterest();
                        System.out.println("New balance = " + saa.getBalance());
                }

                SavingsAccount.modifyInterestRate(5d);
                for (SavingsAccount saa : sa) {
                        saa.calculateMonthlyInterest();
                        System.out.println("New balance = " + saa.getBalance());
                }
        }
}

// Code by arcenter
// https://github.com/BPDC/
