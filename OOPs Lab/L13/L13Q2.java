// Code by arcenter
// https://github.com/arcenter/UniCode/

class InvalidNameException extends Exception {
    public InvalidNameException(String name) {
        super("Invalid Name selected - " + name);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(int age) {
        super("Invalid Age selected - " + age);
    }
}

class InvalidYearException extends Exception {
    public InvalidYearException(int year) {
        super("Invalid Year selected - " + year);
    }
}

class InvalidIDException extends Exception {
    public InvalidIDException(String id) {
        super("Invalid ID selected - " + id);
    }
}

class Student {
    
    private String name;
    private int age;
    private int year;
    private String id;

    private boolean checkID(String id) {
        for (int i = 1; i < 5; i++) {
            if (Character.isDigit(id.charAt(i))) {}
            else return true;
        } return false;
    }

    Student(String name, int age, int year, String id) throws Exception {
        
        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')) {}
            else {throw new InvalidNameException(name);}
        }
        this.name = name;

        if (age > 34) throw new InvalidAgeException(age);
        this.age = age;

        if (year < 1 || year > 4) throw new InvalidYearException(year);
        this.year = year;

        if (id.length() != 6) throw new InvalidIDException(id);
        else if (id.charAt(0) != 'f' || id.charAt(5) != 'U' || checkID(id)) throw new InvalidIDException(id);
        this.id = id;

    }

}

public class L13Q2 {
    public static void main(String args[]) throws Exception {
        
        new Student("APerson", 34, 2, "f1523U");

        try {new Student("BPerson", 36, 2, "f1523U");}
        catch (Exception e) {System.out.println("Exception : " + e);}

        try {new Student("CPerson", 34, 6, "f1523U");}
        catch (Exception e) {System.out.println("Exception : " + e);}

        try {new Student("DPerson", 34, 2, "f1523A");}
        catch (Exception e) {System.out.println("Exception : " + e);}

        try {new Student("EPerson", 34, 2, "f15a3U");}
        catch (Exception e) {System.out.println("Exception : " + e);}

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/