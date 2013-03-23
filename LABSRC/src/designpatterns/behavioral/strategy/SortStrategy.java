/*
 * The strategy pattern is useful for situations where it is necessary to
 * dynamically swap the algorithms used in an application. The strategy pattern
 * is intended to provide a means to define a family of algorithms, encapsulate
 * each one as an object, and make them interchangeable. The strategy pattern
 * lets the algorithms vary independently from clients that use them.
 *
 * The UML class diagram for the Strategy pattern is the same as the diagram for
 * the Bridge pattern. However, these two design patterns aren't the same in
 * their intent. While the Strategy pattern is meant for behavior, the Bridge
 * pattern is meant for structure.
 *
 * The strategy pattern uses composition instead of inheritance. In the strategy
 * pattern behaviors are defined as separate interfaces and specific classes
 * that implement these interfaces. Specific classes encapsulate these
 * interfaces. This allows better decoupling between the behavior and the class
 * that uses the behavior
 *
 * This gives greater flexibility in design and is in harmony with the
 * Open/closed principle (OCP) that states classes should be open for extension
 * but closed for modification
 */

package designpatterns.behavioral.strategy;

/**
 *
 * @author vijay
 */
public class SortStrategy {
    public static void main(String[] args){
        int[] array = null;
       Context context = new Context();
       array = new int[10];
       context.sortCollection(array);
       array = new int[150];
       context.sortCollection(array);
       array = new int[1050];
       context.sortCollection(array);
    }
}


class Context{
    SortAlgorithm algorithm;
    void sortCollection(int[] array){
        if(array.length>0 && array.length<100){
            algorithm = new BubbleSort();
        }else if(array.length>=100 && array.length<1000){
            algorithm = new SelectionSort();
        }else{
            algorithm = new InsertionSort();
        }
        algorithm.sort(array);
    }
}

interface SortAlgorithm{
    void sort(int[] array);
}

class BubbleSort implements SortAlgorithm{
    public void sort(int[] array){
        System.out.println("BubbleSort used");
    }
}

class InsertionSort implements SortAlgorithm{
    public void sort(int[] array){
        System.out.println("InsertionSort used");
    }
}

class SelectionSort implements SortAlgorithm{
    public void sort(int[] array){
        System.out.println("SelectionSort used");
    }
}