/*
 * Define an object that encapsulates how a set of objects interact. Mediator
 * promotes loose coupling by keeping objects from referring to each other
 * explicitly, and it lets you vary their interaction independently
 */
package designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vijay
 */
public class AirTrafficController {
    
    public static void main(String[] args){
        AirTrafficControlMediator mediator = new DelhiTrafficControlMediator();
        Colleague jet = new JetAirways(mediator);
        Colleague spice = new SpiceJet(mediator);
        Colleague indigo = new Indigo(mediator);
        jet.block();
        spice.block();
        jet.unblock();
        spice.block();
        indigo.block();
        spice.unblock();
        indigo.block();
    }
}
//Mediator Interface
interface AirTrafficControlMediator {

    void addAirway(Colleague colleague);

    void blockForLanding(String airway);

    void unblockForLanding(String airway);
}

//Concrete Mediator interface
class DelhiTrafficControlMediator implements AirTrafficControlMediator {

    List<Colleague> colleagues = new ArrayList<Colleague>();

    DelhiTrafficControlMediator() {
    }

    public void addAirway(Colleague colleague) {
        colleagues.add(colleague);
    }

    public void blockForLanding(String airway) {
        if (canBlock(airway)) {
            for (Colleague colleague : colleagues) {
                if (!airway.equals(colleague.getName())) {
                    colleague.isBlocked = true;
                }
            }
            System.out.println(airway + " can Land. Other Airways successfully blocked");
        } else {
            System.out.println(airway + " cannot Land. Other Airway has already blocked");
        }
    }

    private boolean canBlock(String airway) {
        for (Colleague colleague : colleagues) {
            if (!airway.equals(colleague.getName()) && colleague.isBlocked == true) {
                return false;
            }
        }
        return true;
    }

    public void unblockForLanding(String airway) {
        for (Colleague colleague : colleagues) {
            if (!airway.equals(colleague.getName())) {
                colleague.isBlocked = false;
            }
        }
        System.out.println(airway + " has Landed. Other Airways Unblocked");
    }
}

abstract class Colleague {

    AirTrafficControlMediator mediator;
    boolean isBlocked = false;

    abstract void block();

    abstract void unblock();

    abstract String getName();
}

class JetAirways extends Colleague {

    public JetAirways(AirTrafficControlMediator mediator) {
        this.mediator = mediator;
        this.mediator.addAirway(this);
    }

    String getName() {
        return "Jet Airways";
    }

    void block() {
        mediator.blockForLanding(this.getName());
    }

    void unblock() {
        mediator.unblockForLanding(this.getName());
    }
}

class SpiceJet extends Colleague {

    public SpiceJet(AirTrafficControlMediator mediator) {
        this.mediator = mediator;
        this.mediator.addAirway(this);
    }

    String getName() {
        return "SpiceJet Airways";
    }

    void block() {
        mediator.blockForLanding(this.getName());
    }

    void unblock() {
        mediator.unblockForLanding(this.getName());
    }
}

class Indigo extends Colleague {

    public Indigo(AirTrafficControlMediator mediator) {
        this.mediator = mediator;
        this.mediator.addAirway(this);
    }

    String getName() {
        return "Indigo Airways";
    }

    void block() {
        mediator.blockForLanding(this.getName());
    }

    void unblock() {
        mediator.unblockForLanding(this.getName());
    }
}

