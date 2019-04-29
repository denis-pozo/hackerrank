package org.pozopardo.challenges.iplytics.proman.model;

import org.junit.Test;

public class EmployeeTest {

    @Test(expected = IllegalArgumentException.class)
    public void firstNameCannotBeNull() {
        Employee employee = new Employee(null, "Cage");
        System.out.println(employee);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lastNameCannotBeNull() {
        Employee employee = new Employee("Nicolas", null);
        System.out.println(employee);
    }




}
