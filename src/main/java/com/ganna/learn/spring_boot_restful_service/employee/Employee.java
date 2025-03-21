package com.ganna.learn.spring_boot_restful_service.employee;

public class Employee {

    private int employId;

    private String Department;
    private int Salary;

    public Employee(int employId, String department, int salary) {
        this.employId = employId;
        Department = department;
        Salary = salary;
    }


    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employId=" + employId +
                ", Department='" + Department + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
