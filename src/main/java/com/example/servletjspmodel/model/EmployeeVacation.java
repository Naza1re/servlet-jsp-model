package com.example.servletjspmodel.model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVacation implements Serializable {
    private String employeeCode;
    private String department;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date startDate;
    private Date endDate;
    private double salary;
    private double vacationAllowance;

    public EmployeeVacation(String employeeCode, String department, String lastName, String firstName, String middleName,Date startData , Date endDate, double salary, double vacationAllowance) {
        this.employeeCode = employeeCode;
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.startDate=startData;
        this.endDate=endDate;
        this.salary = salary;
        this.vacationAllowance = vacationAllowance;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }
    public EmployeeVacation(){

    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getVacationAllowance() {
        return vacationAllowance;
    }

    public void setVacationAllowance(double vacationAllowance) {
        this.vacationAllowance = vacationAllowance;
    }

    // Конструктор, геттеры, сеттеры и другие методы
    // ...
}
