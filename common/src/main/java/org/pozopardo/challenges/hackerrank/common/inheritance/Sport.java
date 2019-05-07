package org.pozopardo.challenges.hackerrank.common.inheritance;

public class Sport {

    String getName() {
        return "Generic Sport";
    }

    void getNumberOfTeamMembers() {
        System.out.println("Each Team has n players in " + getName());
    }

    public static void main(String []args){
        Sport c1 = new Sport();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
    }
}

class Soccer extends Sport {

    @Override
    String getName() {
        return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers() {
        System.out.println("Each team has " + 11 + " players in " + getName());
    }
}
