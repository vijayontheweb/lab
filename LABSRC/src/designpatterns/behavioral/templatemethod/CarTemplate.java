/*
 * First a class is created that provides the basic steps of an algorithm design.
 * These steps are implemented using abstract methods. Later on, subclasses 
 * change the abstract methods to implement real actions. Thus the general 
 * algorithm is saved in one place but the concrete steps may be changed by the 
 * subclasses
 *
 */

package designpatterns.behavioral.templatemethod;

/**
 *
 * @author vijay
 */
public class CarTemplate {
    public static void main(String[] args){
        Car car = new BMW();
        car.buildCar();
    }
}

abstract class Car{
    void buildCar(){
        System.out.println("Building the Car");
        buildBody();
        System.out.println("Car is built");
    }
    protected abstract void buildBody();
}

class BMW extends Car{
    public void buildBody(){
         System.out.println("Assembling BMW ..");
    }
}
