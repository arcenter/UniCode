// Code by arcenter
// https://github.com/arcenter/UniCode/

abstract class Car {
    double price;
    int year;

    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }

    abstract double calculateSalePrice();
}

class ClassicCar extends Car {

    ClassicCar(double price, int year) {
        super(price, year);
    }

    double calculateSalePrice() {
        return 10000d;
    }
}

class SportsCar extends Car {

    SportsCar(double price, int year) {
        super(price, year);
    }

    double calculateSalePrice() {
        if (year>2000) {
            return 0.75*price;
        } else if (year>1995) {
            return 0.5*price;
        }
        return 0.25*price;
    }

}

public class L10Q2 {
    public static void main(String args[]) {

        ClassicCar cc = new ClassicCar(500, 2002);
        SportsCar sc1 = new SportsCar(100, 2002);
        SportsCar sc2 = new SportsCar(100, 1997);
        SportsCar sc3 = new SportsCar(100, 1987);

        System.out.println(cc.calculateSalePrice());
        System.out.println(sc1.calculateSalePrice());
        System.out.println(sc2.calculateSalePrice());
        System.out.println(sc3.calculateSalePrice());

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/
