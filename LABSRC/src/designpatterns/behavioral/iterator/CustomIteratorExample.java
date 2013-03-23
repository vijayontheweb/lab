/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vijay
 */
public class CustomIteratorExample {

    public static void main(String[] args) {
        CustomCollection collection = new CustomCollection();
        collection.add(new Employee("Vijay", 20));
        collection.add(new Employee("Anand", 21));
        collection.add(new Employee("Priya", 22));
        collection.add(new Employee("KV", 23));
        CustomIterator iterator = collection.getIterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println("Name=" + employee.getName() + " Age=" + employee.getAge());
        }
    }
}

class CustomCollection {

    List<Employee> employees = new ArrayList<Employee>();

    void add(Employee employee) {
        employees.add(employee);
    }

    Employee get(int index) {
        return employees.get(index);
    }

    void remove(Employee e) {
        employees.remove(e);
    }

    CustomIterator getIterator() {
        return new CustomIterator(this);
    }

    int size() {
        return employees.size();
    }
}

class CustomIterator {

    CustomCollection collection = null;
    int current = 0;

    CustomIterator(CustomCollection collection) {
        this.collection = collection;
    }

    Employee next() {
        return collection.get(current++);
    }

    boolean hasNext() {
        return collection.size() > current;
    }

    void remove() {
        collection.remove(collection.get(--current));
    }
}

class Employee {

    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
