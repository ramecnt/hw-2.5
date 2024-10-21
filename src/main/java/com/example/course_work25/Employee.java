package com.example.course_work25;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Имя: " + this.getFullName();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Employee) {
            Employee otherEmployee = (Employee) other;
            return this.getFullName().equals(otherEmployee.getFullName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getFullName().hashCode();
    }
}