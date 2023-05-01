package employee;

import company.IT_Company;
import programmers.programmerEx;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.*;
public class Director extends IT_Company {
    int count = 0;
    private static final Logger LOGGER = Logger.getLogger(Director.class.getName());
    protected List<IT_Company> employees;
    public Director(programmers.programmerEx prog, String name, int experience, int salary)
    {
        super(prog, name, experience, salary);
    }

    public class Plan
    {
        private List<IT_Company> place;
        public Plan(List<IT_Company> list)
        {
            place = list;
        }
    }

        public void getEmployees(final Plan plan)
        {
            String method = new Exception().getStackTrace()[0].getMethodName();
            LOGGER.info("Method was called: " + method);
            employees = plan.place;
        }
        public int CountEmployees()
        {
            return employees.size();
        }

        public List<IT_Company> getTeam()
        {
            return employees;
        }

        public void setTeam(List<IT_Company> list)
        {
            employees = list;
        }

        public List<IT_Company> SortBySalary()
        {
            List<IT_Company> sortList = new ArrayList<>(employees);
            Collections.sort(sortList, Comparator.comparingInt(IT_Company::getSalary));
            return sortList;
        }

        public List<IT_Company> SearchBySkillLevel(programmers.programmerEx progr)
        {
            List<IT_Company> skills = new ArrayList<>();
            for (int i = 0; i < employees.size(); i++) {
                if (progr == programmerEx.Junior) {
                    skills.add(employees.get(i));
                }
                else if (progr == programmerEx.Middle)
                {
                    skills.add(employees.get(i));
                }
                else if (progr == programmerEx.Senior)
                {
                    skills.add(employees.get(i));
                }
            }
            return skills;
        }
    public void CountSalary()
    {

    }

    @Override
    public int CountProcent()
    {
        return expirience * standartSalary * 7;
    }

}
