package org.pozopardo.challenges.iplytics.proman.model;

import com.google.common.base.Preconditions;

public class Employee {

    private final String firstName;
    private final String lastName;
    private Employee supervisor;

    public Employee(String firstName, String lastName) {
        Preconditions.checkNotNull(firstName);
        Preconditions.checkNotNull(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setSupervisor(Employee supervisor) {
        Preconditions.checkNotNull(supervisor);
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
