package org.pozopardo.challenges.iplytics.proman.model;

public class Employee {

    private final String firstName;
    private final String lastName;
    private Employee supervisor;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee getSupervisor() {
        return supervisor;
    }
}
