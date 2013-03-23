/*
 * Avoid coupling the sender of a request to its receiver by giving more than 
 * one object a chance to handle the request. Chain the receiving objects and 
 * pass the request along the chain until an object handles it.
 *
 * The Chain of Responsibility pattern uses a chain of objects to handle a
 * request, which is typically an event. Objects in the chain forward the
 * request along the chain until one of the objects handles the event.
 * Processing stops after an event is handled.
 *
 * The Chain of Responsibility pattern is applicable if:
 * You want to decouple a request's sender and receiver
 * Multiple objects, determined at runtime, are candidates to handle a request
 * You don't want to specify handlers explicitly in your code
 *
 * If you use the CoR pattern, remember:
 * Only one object in the chain handles a request
 * Some requests might not get handled
 */
package designpatterns.behavioral.chainofresponsibility;

/**
 *
 * @author vijay
 */
public class BudgetApprover {

    public static void main(String[] args) {
        //Setting the approval order
        Handler handler,teamLead;
        handler = teamLead = new TeamLead();
        handler = handler.setNext(new Manager());
        handler = handler.setNext(new Director());
        
        teamLead.handleRequest(90);
        System.out.println("----------------------------------");
        teamLead.handleRequest(900);
        System.out.println("----------------------------------");
        teamLead.handleRequest(9000);

    }
}

abstract class Handler {

    Handler successor;
    int limit = 0;

    Handler setNext(Handler s) {
        successor = s;
        return successor;
    }

    public void handleRequest(int budget) {
        if (isAuthorizedApprover(budget)) {
            approve(budget);
        }else if (successor != null) {
            successor.handleRequest(budget);
        }
    }

    boolean isAuthorizedApprover(int budget) {
        if (this.limit > budget) {
            return true;
        }
        return false;
    }

    abstract void approve(int budget);
}

class TeamLead extends Handler {

    TeamLead() {
        this.limit = 100;
    }

    public void approve(int budget) {
        System.out.println("Team Leader Approves");

    }
}

class Manager extends Handler {

    Manager() {
        this.limit = 1000;
    }

    public void approve(int budget) {
        System.out.println("Manager Approves");

    }
}

class Director extends Handler {

    Director() {
        this.limit = 10000;
    }

    public void approve(int budget) {
        System.out.println("Director Approves");

    }
}
