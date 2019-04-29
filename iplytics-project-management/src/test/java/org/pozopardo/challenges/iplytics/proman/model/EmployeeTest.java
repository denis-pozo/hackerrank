package org.pozopardo.challenges.iplytics.proman.model;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class EmployeeTest {

    @Test(expected = NullPointerException.class)
    public void firstNameCannotBeNull() {
        Employee employee = new Employee(null, "Cage");
        System.out.println(employee);
    }

    @Test(expected = NullPointerException.class)
    public void lastNameCannotBeNull() {
        Employee employee = new Employee("Nicolas", null);
        System.out.println(employee);
    }




}
