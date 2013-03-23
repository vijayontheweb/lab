/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vijay
 */
public class TimesOfIndia {
    public static void main(String[] args){
    Suscriber s1 = new Vijay();
    Suscriber s2 = new Priya();
    Newspaper n1 = new TimesOfIndiaNP();
    n1.register(s1);
    n1.register(s2);
    n1.publish("Avatar Movie is a Blockbuster");
    n1.unRegister(s2);
    n1.publish("Taj Mahal acclaimed world renowed status");
    }
}


interface Suscriber{
    public void update(String message);
    String getName();
}

class Vijay implements Suscriber{

    public String getName(){ return "Vijay";}

    public void update(String message){
        System.out.println(getName()+" got a message ->"+message);
    }
}

class Priya implements Suscriber{

    public String getName(){ return "Priya";}

    public void update(String message){
        System.out.println(getName()+" got a message ->"+message);
    }
}

interface Newspaper{//Subject
    void publish(String  news);
    void register(Suscriber suscriber);
    void unRegister(Suscriber suscriber);

}

class TimesOfIndiaNP implements Newspaper{
    String news = "NO NEWS" ;
    List<Suscriber> suscribers = new ArrayList<Suscriber>();

    public void register(Suscriber suscriber){
        System.out.println(suscriber.getName()+" is registered");
        suscribers.add(suscriber);
    }

    public void unRegister(Suscriber suscriber){
        System.out.println(suscriber.getName()+" is unregistered");
        suscribers.remove(suscriber);
    }

    void setNews(String news){
        this.news  = news;
        publish(news);
    }

    public void publish(String  news){
        for(Suscriber suscriber:suscribers){
            suscriber.update(news);
        }
    }


}