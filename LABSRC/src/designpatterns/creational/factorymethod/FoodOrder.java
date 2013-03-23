/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.creational.factorymethod;

/**
 *
 * @author vijay
 */
public class FoodOrder {
    public static void main(String[] args){
        for(FoodFactory.FoodType foodType: FoodFactory.FoodType.values()){
            Food food = FoodFactory.getFood(foodType);
            food.printDetails();
        }
    }
}


class FoodFactory{
    public enum FoodType {
        IDY,
        DSA,
        APM,
    }

    static Food getFood(FoodType type){
        switch(type){
            case IDY:
                return new Idly();
            case DSA:
                return new Dosa();
            case APM:
                return new Appam();
            default:
                return null;
        }
    }
}

abstract class  Food{
    String name;
    int price;
    Food getFood(){
        return this;
    }
    void printDetails(){
        System.out.println(this.name+" -> Rs."+this.price);
    }
}

class Idly extends Food{
    Idly(){
        this.name = "Idly";
        this.price = 10;
    }
}

class Dosa extends Food{
    Dosa(){
        this.name = "Dosa";
        this.price = 15;
    }
}

class Appam extends Food{
    Appam(){
        this.name = "Appam";
        this.price = 12;
    }
}