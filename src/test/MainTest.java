package test;

import model.CommissionEmployee;
import model.Department;
import model.Employee;
import model.Gender;
import model.HourlyEmployee;
import model.MonthlyEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {

        CommissionEmployee commissionEmployee = new CommissionEmployee(
                1,
                "Ahmed",
                Gender.MALE,
                LocalDate.of(2024, 1, 10),
                5000,
                0.05,
                20000
        );

        MonthlyEmployee monthlyEmployee = new MonthlyEmployee(
                2,
                "Mariam",
                Gender.FEMALE,
                LocalDate.of(2023, 5, 15),
                8000,
                21,
                0.10,
                true
        );

        HourlyEmployee hourlyEmployee = new HourlyEmployee(
                3,
                "Omar",
                Gender.MALE,
                LocalDate.of(2025, 2, 1),
                100,
                45,
                150
        );

        List<Employee> employees = new ArrayList<>();
        Department department = new Department(
                101,
                "Sales Department",
                commissionEmployee,
                employees
        );

        department.addEmployee(commissionEmployee);
        department.addEmployee(monthlyEmployee);
        department.addEmployee(hourlyEmployee);

        System.out.println("===== Department =====");
        System.out.println(department);

        System.out.println("\n===== Employees =====");
        department.printAllEmployees();

        System.out.println("\n===== Salary Calculations =====");
        System.out.println("Commission employee salary: " +
                commissionEmployee.calculateSalary());

        System.out.println("Monthly employee salary: " +
                monthlyEmployee.calculateSalary());

        System.out.println("Hourly employee salary: " +
                hourlyEmployee.calculateSalary());

        System.out.println("\nTotal Payroll: " +
                department.calculateTotalPayroll());

        System.out.println("\nFind Employee with ID 2:");
        Employee found = department.findEmployee(2);
        System.out.println(found);

        System.out.println("\nAdditional Vacation for Monthly Employee: " +
                monthlyEmployee.calculateAdditionalVacation());

        System.out.println("\nRemoving Employee with ID 3...");
        department.removeEmployee(3);

        System.out.println("Employees after removal:");
        department.printAllEmployees();
    }
}
