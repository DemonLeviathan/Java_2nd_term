package company;

import employee.staff.Programmer;

public abstract class IT_Company implements ICompany {
    protected programmers.programmerEx programmer;
    public String name;
    public int expirience;
    public int standartSalary;

    public IT_Company(programmers.programmerEx pr, String name, int experience, int salary)
    {
        programmer = pr;
        this.expirience = experience;
        standartSalary = salary;
        this.name = name;
    }

    public programmers.programmerEx get_level()
    {
        return programmer;
    }

    public void setProgrammer(programmers.programmerEx programmer)
    {
        this.programmer = programmer;
    }

    public int getExperience() {
        return expirience;
    }

    public void setExperience(int expirience)
    {
        this.expirience = expirience;
    }

    public int getSalary()
    {
        return standartSalary;
    }
    public void setSalary(int standartSalary)
    {
        this.standartSalary = standartSalary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "{" + '\n' +
                "Name: " + name + '\n'
                + "Expirience: " + expirience + '\n' +
                "Salary: " + CountProcent() + '\n'
                + "}";
    }

    public abstract int CountProcent();
}
