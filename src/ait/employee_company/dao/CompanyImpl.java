package ait.employee_company.dao;

import ait.employee_company.model.Employee;
import ait.employee_company.model.SalesManager;

public  class CompanyImpl implements Company {
    private Employee[] employees; // array for objects
    private int size; // current size of array

    //constructor
    public CompanyImpl(int capacity) {
        employees = new Employee[capacity]; // this. - не обязательно
        // this.size = 0;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(employee == null){
            return false;
        }
        if(employees.length == size){
            return false;
        }
        if(findEmployee(employee.getId()) != null){
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getId() == employee.getId()) {
                employees[i] = employee;
            }
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee removedEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && employees[i].getId() == id) {
                removedEmployee = employees[i];
                employees[i] = null;
                break;
            }
        }
        return removedEmployee;
    }

    @Override
    public void printEmployee() {
        for (int i = 0; i < size; i++) {
            System.out.println( employees[i] );
        }
    }

    @Override
    public int quantity() {
        int counter = 0;
        for (Employee e: employees)
            if(e != null)
                counter++;
        return counter;
    }

    @Override
    public double totalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null)
                totalSalary += employee.salary();
        }
        return totalSalary;
    }

    @Override
    public double totalSales() {
        double totalSales = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] instanceof SalesManager)
                totalSales += ((SalesManager) employees[i]).getSalesValue();
        }
        return totalSales;
    }
}