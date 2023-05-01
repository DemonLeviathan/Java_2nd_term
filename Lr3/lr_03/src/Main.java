import company.IT_Company;
import employee.Director;
import employee.staff.Engeenier;
import employee.staff.Programmer;
import employee.staff.SysAdmin;
import programmers.programmerEx;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        Director director = new Director(null, "Anna", 17, 100);

        Director.Plan plan = director. new Plan(new ArrayList<IT_Company>(){
            {
                add(new Engeenier(programmerEx.Middle, "Evgenii", 8, 700));
                add(new Programmer(programmerEx.Junior, "Aleksei", 2, 720));
                add(new Programmer(programmerEx.Senior, "Alisa", 7, 720));
                add(new SysAdmin(programmerEx.Senior, "Sasha", 13, 670));
                add(new Engeenier(programmerEx.Senior, "Maks", 10, 700));
            }
        });
        director.getEmployees(plan);

        System.out.println("Quantity of employees: " + director.CountEmployees());
        System.out.println("Sorting: " + director.SortBySalary());
        System.out.println("Searching: " + director.SearchBySkillLevel(programmerEx.Middle));
        System.out.println("Salary: " + director.CountProcent());

        XMLInputFactory factory = XMLInputFactory.newInstance();
        System.out.println("Working directory: " + System.getProperty("user.director"));
        InputStream stream = new FileInputStream("files\\xml.xml");

        XMLStreamReader reader = factory.createXMLStreamReader(stream);

    }
}