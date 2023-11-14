// Code by arcenter
// https://github.com/arcenter/UniCode/

import java.util.*;

abstract class Member {

    private String name;
    private String address;

    Member(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }

    abstract public int getFee();

}

class StandardMember extends Member {

    StandardMember(String name, String address) {
        super(name, address);
    }

    @Override
    public int getFee() {return 0;}

}

class SeniorMember extends Member {

    private int fee;

    SeniorMember(String name, String address, int fee) {
        super(name, address);
        this.fee = fee;
    }

    @Override
    public int getFee() {
        return fee;
    }

}

class Society {

    private String name;

    ArrayList<Member> members = new ArrayList<Member>();

    Society(String name) {
        this.name = name;
    }

    public void addMember(String name, String address) {
        members.add(new StandardMember(name, address));
    }
    
    public void addSeniorMember(String name, String address, int fee) {
        members.add(new SeniorMember(name, address, fee));
    }

    public int getFeeTotal() {
        int totalFee = 0;
        for (Member member : members) {
            totalFee += member.getFee();
        }
        return totalFee;
    }

}

public class L11Q1 {
    public static void main(String args[]) {

        Society society = new Society("Soc1");

        society.addMember("Aname", "Aadd");
        society.addMember("Bname", "Badd");
        
        society.addSeniorMember("SAname", "SAadd", 100);
        society.addSeniorMember("SBname", "SBadd", 200);

        System.out.println(society.getFeeTotal());

    }
}

// Code by arcenter
// https://github.com/arcenter/UniCode/