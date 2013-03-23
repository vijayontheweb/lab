/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.creational.singleton;

/**
 *
 * @author vijay
 */
public class SingletonFactory {
    public static void main(String[] args){
        Singleton singleton1 = Singleton.getInstance();
        singleton1.setName("Flexprod");
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.getName());
    }
}

class Singleton{
    private static Singleton instance;
    String name;

    private Singleton(){
        System.out.println("Singleton Created");
    }

    static Singleton getInstance(){
        if(instance == null){
           instance = new Singleton();
        }
            return instance;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

