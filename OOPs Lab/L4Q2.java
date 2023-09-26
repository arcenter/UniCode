// Code by arcenter
// https://github.com/arcenter/BPDC/

import java.util.Scanner;

class Employee {

        private String id;
        private String name;
        private int dept;
        private float basic;
        private float allowance;
        private float totalSalary;

        Employee(String id, String name, int dept, float basic) {
                this.id = id;
                this.name = name;
                this.dept = dept;
                this.basic = basic;
                if (dept == 1) allowance = 1500;
                else if (dept == 2) allowance = 2500;
                else if (dept == 3) allowance = 3500;
        }

        void calculateSalary() {
                totalSalary = basic + (0.4f * basic) + allowance;
        }

        void display() {
                System.out.println("ID = " + id);
                System.out.println("Name = " + name);
                System.out.println("Department = " + dept);
                System.out.println("Basic Salary = " + basic);
                System.out.println("Allowance = " + allowance);
                System.out.println("Total Salary = " + totalSalary);
        }

}

class L4Q2 {

        public static void main(String args[]) {

                Employee p1 = new Employee("1", "A", 1, 100);
                Employee p2 = new Employee("2", "B", 2, 200);
                Employee p3 = new Employee("3", "C", 3, 300);

                p1.calculateSalary();
                p2.calculateSalary();
                p3.calculateSalary();

                p1.display();
                p2.display();
                p3.display();

        }

}

// Code by arcenter
// https://github.com/arcenter/BPDC/
