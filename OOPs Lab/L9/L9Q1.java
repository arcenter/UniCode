// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.*;

public class L9Q1 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the;");
        
        System.out.print("Year = ");
        String year = sc.nextLine();
        
        System.out.print("Discipline = ");
        String dsp = new String();
        switch(sc.nextLine()) {
            case "CHEM": dsp = "A1"; break;
            case "EEE": dsp = "A3"; break;
            case "MECH": dsp = "A4"; break;
            case "CS": dsp = "A7"; break;
            default: dsp = "XX";
        }
        
        String pt = new String();
        boolean x = true;
        while(x) {
            System.out.print("PS/TS = ");
            switch(sc.nextLine()) {
                case "PS": pt = "PS"; x = false; break;
                case "TS": pt = "TS"; x = false; break;
            }
        }
        
        System.out.print("Campus = ");
        String campus = sc.nextLine();
        String camp = new String();
        switch(campus) {
            case "Pilani": camp = "P"; break;
            case "Hyderabad": camp = "H"; break;
            case "Goa": camp = "G"; break;
            case "Dubai": camp = "U"; break;
            default: camp = "X";
        }

        Random random = new Random();
        String id = String.format("%03d", random.nextInt(301));

        String sid = year + dsp + pt + id + camp;
        String email = "f" + year + id + "@" + campus.toLowerCase() + ".bits-pilani.ac.in";
        
        System.out.println("ID = " + sid);
        System.out.println("Email = " + email);

    }

}

// Code by arcenter
// https://github.com/arcenter/UniCode/