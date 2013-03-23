/*
 * COMPOSE OBJECTS INTO TREE STRUCTURES TO REPRESENT PART-WHOLE HIERARCHIES.
 * COMPOSITE LET'S CLIENT TREAT INDIVIDUAL OBJECTS AND COMPOSITION OF OBJECTS
 * UNIFORMLY
 * 
 * Intent is to allow group of objects to be treated in the same way as a single
 * instance of an object
 */
package designpatterns.structural.composite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vijay
 */
public class EmployeeHierarchy {

    static Employee firstEmployee = null;

    public static void main(String[] args) throws Exception {
        while(true){
            System.out.println("Enter your choice:A-Add Employee P-Print Employee");
            switch (getChoice()) {
                case 'A':
                    addEmployee();
                    break;
                case 'P':
                    printEmployee();
                    break;
                default:
                    System.exit(0);
            }
        }
    }




    private static Employee addEmployee() throws Exception {
        System.out.println("Enter Name");
        String name = getStringFromUser();
        System.out.println("Enter Designation");
        String designation = getStringFromUser();
        System.out.println("Enter Salary");
        String salary = getStringFromUser();
        Employee employee = new Employee(name, designation, new Integer(salary));
        if(firstEmployee == null){
            firstEmployee = employee;
        }
        while(true){
            System.out.println("Do you wish to add Subordinate for "+name+"? Y-Yes N-No");
            String addSubordinate = getStringFromUser();
            if(addSubordinate.equals("Y")){
                employee.addSubordinate(addEmployee());
            }else{
                break;
            }
        }        
        return employee;
    }

    private static void printEmployee(){
        if(firstEmployee!=null){
            Employee.showSubordinates(firstEmployee);
        }else{
            System.out.println("No Employees to print :(");
        }
    }

    private static int getChoice() throws Exception {
        System.out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().charAt(0);
    }

    private static String getStringFromUser() throws Exception {
        System.out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

class Employee {

    String name;
    String designation;
    Integer salary;
    List<Employee> subordinates;

    Employee(String name, String designation, Integer salary) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinate(Employee employee) {
        if (subordinates == null) {
            subordinates = new ArrayList<Employee>();
        }
        subordinates.add(employee);
    }

    public static void showSubordinates(Employee e) {
        System.out.println("NAME=" + e.getName());
        System.out.println("DESIGNATION=" + e.getDesignation());
        System.out.println("SALARY=" + e.getSalary());
        System.out.println("----------------------------------");
        if(e.getSubordinates()!=null){
            for (Employee employee : e.getSubordinates()) {
                System.out.println("SUBORDINATE OF "+e.getName());
                System.out.println("----------------------------------");
                System.out.println("NAME=" + employee.getName());
                System.out.println("DESIGNATION=" + employee.getDesignation());
                System.out.println("SALARY=" + employee.getSalary());
                if (employee.getSubordinates() != null) {
                    showSubordinates(employee);
                }
            }
        }
        System.out.println("----------------------------------");
    }
}
