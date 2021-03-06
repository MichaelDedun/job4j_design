package ru.job4j.srp.model;

import java.util.Calendar;
import java.util.Objects;

public class Employe {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employe(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Double.compare(employe.salary, salary) == 0 &&
                Objects.equals(name, employe.name) &&
                Objects.equals(hired, employe.hired) &&
                Objects.equals(fired, employe.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", hired=" + hired +
                ", fired=" + fired +
                ", salary=" + salary +
                '}';
    }

}
