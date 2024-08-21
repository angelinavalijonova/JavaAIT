package ait.employee_company.dao;


import ait.employee_company.model.Employee;

public interface Company {

    // only abstract methods for Employee and Children
    //--------------
     //CRUD - методы
   // С= сreate
    //r = read
    //u = update
    //d= delete

    //нанимать = create =
    boolean addEmployee(Employee employee);// удалось добавить или нет

    //искать в списке =
    Employee findEmployee(int id);

    // обновлять данные
    Employee updateEmployee(Employee employee);

    //увольнять(delete)
    Employee removeEmployee(int id);

    // print
   void printEmployee();


   // количество сотрудников компании
    int quantity();

    // считать зарплату и оборот

    double totalSalary();//зп
    double totalSales(); // оборот и продажи

}
