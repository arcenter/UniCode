// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;

class Car {

    String vehicleId;
    float cost[] = new float[3];
    float total, grand_total;

    Car(String vehicleId, float basic, float exercise, float sales) {
        this.vehicleId = vehicleId;
        cost[0] = basic;
        cost[1] = exercise;
        cost[2] = sales;
    }
    
    void calc_total() {
        total = cost[0] + cost[1] + cost[2];
    }

    void calc_grand_total() {
        grand_total = total * 0.9f;
    }

}

public class L7Q1 {

    public static void highest(Car cars[]) {
        int highest = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].grand_total > cars[highest].grand_total)
                highest = i;
        }
        System.out.printf("Highest grand price is for %s of %f, with base price %f, exercise duty of %f, and sales tax of %f, after 10%% discount", cars[highest].vehicleId, cars[highest].grand_total, cars[highest].cost[0], cars[highest].cost[1], cars[highest].cost[2]);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Cars");
        int n = Integer.parseInt(sc.nextLine());

        Car cars[] = new Car[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Vehicle ID, Basic, Exercise Duty, and Sales Tax of Car #" + (i+1));
            cars[i] = new Car(sc.nextLine(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
            sc.nextLine();
        }

        for (Car car : cars) {
            car.calc_total();
            car.calc_grand_total();
        }

        highest(cars);

        sc.close();

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/
