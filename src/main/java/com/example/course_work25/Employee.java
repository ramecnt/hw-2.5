package com.example.course_work25;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private String department;

    public Employee(String firstName, String lastName, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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