// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.Scanner;
import java.util.ArrayList;

class FlightDest {
    private String flightNo, destination;
    FlightDest(String flightNo, String destination) {
        this.flightNo = flightNo;
        this.destination = destination;
    }
    String getFlightNo() {return flightNo;}
    String getDest() {return destination;}
}

class FlightInfo {

    ArrayList<FlightDest> flightDestList = new ArrayList<FlightDest>();
    
    public void addFlightDestPair(String fNo, String dest) {
        flightDestList.add(new FlightDest(fNo, dest));
    }

    public ArrayList<String> getFlights(String dest) {
        ArrayList<String> flights = new ArrayList<String>();
        for (FlightDest flight : flightDestList) {
            if (flight.getDest().equals(dest)) {
                flights.add(flight.getFlightNo());                
            }
        }
        return flights;
    }

}

public class L8Q1 {

    public static void main(String args[]) {

        int choice = 0;
        FlightInfo fi = new FlightInfo();

        Scanner sc = new Scanner(System.in);

        while (choice != 3) {

            System.out.println("Enter choice:\n1. Add Flight-Destination Pair\n2. Get Flights for Destination\n3. Exit\n");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1: {
                    System.out.println("Enter Flight and Destination separately");
                    fi.addFlightDestPair(sc.nextLine(), sc.nextLine());
                    break;
                }

                case 2: {
                    System.out.print("Enter Destination = ");
                    System.out.println(fi.getFlights(sc.nextLine()));
                    break;
                }

            }

            System.out.println("");

        }

        sc.close();

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/