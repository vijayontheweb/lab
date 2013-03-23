/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.structural.decorator;

/**
 *
 * @author vijay
 */
public class IceCreamDecorator {

    public static void main(String[] args){
        CherryDecorator cherryDecorator = new CherryDecorator(new VanillaIceCream());
        System.out.print(cherryDecorator.describeIceCream()+":");
        System.out.println("        Rs."+cherryDecorator.getPrice());
        cherryDecorator = new CherryDecorator(new StrawberryIceCream());
        System.out.print(cherryDecorator.describeIceCream()+":");
        System.out.println("        Rs."+cherryDecorator.getPrice());
        DryFruitDecorator dryFruitDecorator = new DryFruitDecorator(new VanillaIceCream());
        System.out.print(dryFruitDecorator.describeIceCream()+":");
        System.out.println("        Rs."+dryFruitDecorator.getPrice());
        dryFruitDecorator = new DryFruitDecorator(new StrawberryIceCream());
        System.out.print(dryFruitDecorator.describeIceCream()+":");
        System.out.println("        Rs."+dryFruitDecorator.getPrice());
    }

}

 interface IceCream{
        String describeIceCream();
        int getPrice();
    }

    class VanillaIceCream implements IceCream{
        public String describeIceCream(){
             return "Vanilla IceCream";
        }
        public int getPrice(){
            return 10;
        }
    }

    class StrawberryIceCream implements IceCream{
        public String describeIceCream(){
             return "Strawberry IceCream";
        }
        public int getPrice(){
            return 15;
        }
    }

    class Decorator implements IceCream{
        IceCream iceCream;
        Decorator(IceCream iceCream){
            this.iceCream = iceCream;
        }

        public String describeIceCream(){
            return iceCream.describeIceCream();
        }

        public int getPrice(){
            return iceCream.getPrice();
        }
    }

    class CherryDecorator extends Decorator{

        CherryDecorator(IceCream iceCream){
            super(iceCream);
        }
        public String describeIceCream(){
            return iceCream.describeIceCream()+" With Cherry";
        }

        public int getPrice(){
            return iceCream.getPrice()+5;
        }
    }

    class DryFruitDecorator extends Decorator{

        DryFruitDecorator(IceCream iceCream){
            super(iceCream);
        }
        public String describeIceCream(){
            return iceCream.describeIceCream()+" With Dryfruits";
        }

        public int getPrice(){
            return iceCream.getPrice()+10;
        }
    }

