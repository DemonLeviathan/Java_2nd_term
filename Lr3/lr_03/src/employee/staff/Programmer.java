package employee.staff;

import company.IT_Company;
import employee.Director;
import programmers.programmerEx;


public class Programmer extends IT_Company {
    public Programmer(programmers.programmerEx prog, String name, int experience, int salary)
    {
        super(prog, name, experience, salary);
    }

    @Override
    public int CountProcent()
    {
        if (programmer == programmerEx.Junior)
        {
            return standartSalary * expirience;
        }
        else if (programmer == programmerEx.Middle)
        {
            return standartSalary * expirience * 2;
        }
        else
        {
            return standartSalary * expirience * 3;
        }
    }
}
