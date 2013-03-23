/*
 * The bridge pattern intent is to decouple abstraction(class hierarchy) from implementation(behavior)
 */

package designpatterns.structural.bridge;

/**
 *
 * @author vijay
 */
public class BridgeExample {
    public static void main(String[] args){
        Animal animal = new Cow();
        animal.showActivity();
        System.out.println("_______________________________");
        animal = new Lion();
        animal.showActivity();
        System.out.println("_______________________________");
        animal = new Owl();
        animal.showActivity();
        System.out.println("_______________________________");
        animal = new Fish();
        animal.showActivity();
    }
}

//ABSTRACTION
class Animal{
    EatAction eatAction;
    SleepAction sleepAction;
    MoveAction moveAction;
    
    Animal(){
        System.out.println("ABSTRACTION:-");
    }

    void showActivity(){
      System.out.println("IMPLEMENTATION:-");
      eatAction.eat();
      sleepAction.sleep();
      moveAction.move();
    }
}

class Oviparous extends Animal{
    Oviparous(){
     System.out.println("I'M OVIPAROUS");
    }
}

class Viviparous extends Animal{
    Viviparous(){     
     System.out.println("I'M VIVIPAROUS");
    }
}

class Owl extends Oviparous{
    Owl(){
       System.out.println("I'M OWL");
       this.moveAction = new FlyAction();
       this.eatAction = new NonVegAction();
       this.sleepAction = new DayAction();
    }
}

class Fish extends Oviparous{
    Fish(){
       System.out.println("I'M FISH");
       this.moveAction = new SwimAction();
       this.eatAction = new VegAction();
       this.sleepAction = new NightAction();
    }
}

class Lion extends Viviparous{
    Lion(){
       System.out.println("I'M LION");
       this.moveAction = new WalkAction();
       this.eatAction = new NonVegAction();
       this.sleepAction = new NightAction();
    }
}

class Cow extends Viviparous{
    Cow(){
       System.out.println("I'M COW");
       this.moveAction = new WalkAction();
       this.eatAction = new VegAction();
       this.sleepAction = new NightAction();
    }
}
//IMPLEMENTATION

interface EatAction{
   void eat();
}

interface SleepAction{
  void sleep();
}

interface MoveAction{
    void move();
}

class VegAction implements EatAction{
    public void eat(){
     System.out.println("I EAT VEGETERIAN");
    }
}

class NonVegAction implements EatAction{
    public void eat(){
     System.out.println("I EAT NON-VEGETERIAN");
    }
}

class DayAction implements SleepAction{
    public void sleep(){
     System.out.println("I SLEEP AT DAY");
    }
}

class NightAction implements SleepAction{
    public void sleep(){
     System.out.println("I SLEEP AT NIGHT");
    }
}

class WalkAction implements MoveAction{
    public void move(){
        System.out.println("I MOVE BY WALKING");
    }
}

class SwimAction implements MoveAction{
    public void move(){
        System.out.println("I MOVE BY SWIMMING");
    }
}

class FlyAction implements MoveAction{
    public void move(){
        System.out.println("I MOVE BY FLYING");
    }
}