/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.structural.facade;

/**
 *
 * @author vijay
 */
public class MakeMyTrip {
    public static void main(String[] args){
        ItenaryFacade facade = new ItenaryFacade();
        facade.processItenary();
    }

}


class ItenaryFacade{
        void processItenary(){
            Search search = new Search();
            search.findItenary();
            Select select = new Select();
            select.selectItenary();
            Book book = new Book();
            book.bookItenary();
            Pay pay = new Pay();
            pay.payItenary();
        }
    }

    class Search{
        void findItenary(){
            System.out.println("Itenary Searched");
        }
    }

    class Select{
        void selectItenary(){
            System.out.println("Itenary Selected");
        }
    }

    class Book{
        void bookItenary(){
            System.out.println("Itenary Booked");
        }
    }

    class Pay{
        void payItenary(){
            System.out.println("Itenary paid");
        }
    }