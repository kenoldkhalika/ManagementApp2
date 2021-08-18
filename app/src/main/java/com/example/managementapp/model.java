package com.example.managementapp;

public class model {
String item1, name,job,department;
double salary;

    public model(String item1, String name, String job, String department, double salary) {
        this.item1 = item1;
        this.name = name;
        this.job = job;
        this.department = department;
        this.salary = salary;
    }

    public model(String string) {
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}



