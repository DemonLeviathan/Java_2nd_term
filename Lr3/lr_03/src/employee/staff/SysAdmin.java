package employee.staff;

import company.IT_Company;

public class SysAdmin extends IT_Company {
    public SysAdmin(programmers.programmerEx prog, String name, int experience, int salary)
    {
        super(prog, name, experience, salary);
    }

    public int CountProcent()
    {
        return standartSalary * expirience;
    }
}
