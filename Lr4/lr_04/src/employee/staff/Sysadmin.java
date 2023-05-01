package employee.staff;

import company.Employee;
import programmers.Grades;
public class Sysadmin extends Employee {
    public Sysadmin(String name, int age, int salary, Grades grade) {
        super(name, age, salary, grade);
    }
    @Override
    public void work() {
        System.out.println("admining");
    }
}
