/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.creational.prototype;

/**
 *
 * @author vijay
 */
public class CloneMachine {
    public static void main(String[] args){
        CloneInterface originalSheep = new Sheep();
        CloneInterface cloneSheep = originalSheep.clone();
        cloneSheep.action();
    }
}

interface CloneInterface{
    CloneInterface clone();
    void action();
}

class Sheep implements CloneInterface{
    public CloneInterface clone(){
        return new Sheep();
    }

    public void action(){
        System.out.println("Sheep is cloned");
    }

}