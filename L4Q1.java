// Code by arcenter
// https://github.com//BPDC/

import java.util.Scanner;
class CreditCard {

        private String name;
        private String cardNo;
        private boolean status;
        private int pin;
        private String expiryMonth;
        private int cardType;
        private int currentCredit;
        int creditLimit;

        CreditCard(String name, String cardNo, boolean status, int pin, String expiryMonth, int cardType, int currentCredit, int creditLimit) {
                this.name = name;
                this.cardNo = cardNo;
                this.status = status;
                this.pin = pin;
                this.expiryMonth = expiryMonth;
                this.cardType = cardType;
                this.currentCredit = currentCredit;
                this.creditLimit = creditLimit;
        }

        void changePin(int newPin) {
                this.pin = newPin;
        }

        void transact(int amount) {
                if (!status) {
                        System.out.println("Card not enabled!");
                        return;
                }
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your PIN Number = ");
                int epin = sc.nextInt();
                if (epin != pin) {
                        System.out.println("Incorrect PIN...");
                        return;
                }
                if (amount > creditLimit) {
                        System.out.println("Amount is over Credit Limit");
                        return;
                }
                if (amount > currentCredit) {
                        System.out.println("Not enough balance!");
                        return;
                }
                currentCredit -= amount;
                System.out.println("Transaction Completed.\nRemaining Balance = " + currentCredit);
        }

        void changeCardStatus(boolean status) {
                this.status = status;
        }

        void display() {
                System.out.println();
                System.out.println("Name = " + name);
                System.out.println("Card Number = " + cardNo);
                System.out.println("Status = " + status);
                System.out.println("Pin = " + pin);
                System.out.println("Expiry Month = " + expiryMonth);
                System.out.println("Card Type = " + cardType);
                System.out.println("Current Credit = " + currentCredit);
                System.out.println("Credit Limit = " + creditLimit);
                System.out.println();
        }

}

public class L4Q1 {

        public static void main(String args[]) {
                CreditCard p1 = new CreditCard("A", "1", true, 1234, "01/10", 3, 10000, 2000);
        }

}

// Code by arcenter
// https://github.com//BPDC/
