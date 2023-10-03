import java.util.Scanner;

class Area {

    private int side1;
    private int side2;
    private float area;

    void calc_Area(int side) {
        this.area = side*side;
    }
    
    void calc_Area(float r) {
        this.area = 3.14f*r*r;
    }
    
    void calc_Area(float s1, float s2) {
        this.area = s1*s2;
    }

    void display() {
        System.out.println("Area = " + area);
    }

}

public class L6Q1 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int choice;

        Area area = new Area();
        
        while (true) {

            System.out.println("\nCalculate Area of a\n1. Square\n2. Circle\n3. Rectangle\n4. Exit Program");
            
            choice = sc.nextInt();
            switch (choice) {
                
                case 1:
                    System.out.println("Enter side of Square");
                    area.calc_Area(sc.nextInt());
                    break;
                    
                case 2:
                    System.out.println("Enter radius of Circle");
                    area.calc_Area(sc.nextFloat());
                    break;
                    
                case 3:
                    System.out.println("Enter two sides of rectangle");
                    area.calc_Area(sc.nextFloat(), sc.nextFloat());
                    break;
                
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
                    
            }

            area.display();

        }

    }
}