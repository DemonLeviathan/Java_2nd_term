package employee.staff;

import company.IT_Company;

public class Engeenier extends IT_Company {
    public Engeenier(programmers.programmerEx prog, String name, int expirience, int salary)
    {
        super(prog, name, expirience, salary);
    }

    @Override
    public int CountProcent()
    {
        return  standartSalary * expirience;
    }
}
