/*
 * provides an ability to restore an object to its previous state(undo via rollback)
 */
package designpatterns.behavioral.memento;

/**
 *
 * @author vijay
 */
public class MementoExample {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        careTaker.run();
    }
}

class Originator {

    String state;

    public Originator() {
        this.state = "BORN";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Memento SaveToMemento() {
        return new Memento(state);
    }

    void restoreFromMemento(Memento memento) {
        setState(memento.getSavedState());
    }
}

class Memento {

    String stateToSave;

    Memento(String state) {
        this.stateToSave = state;
    }

    String getSavedState() {
        return stateToSave;
    }
}

class CareTaker {

    void run() {
        Originator originator = new Originator();
        originator.setState("MEDIUM");
        Memento memento = originator.SaveToMemento();
        originator.setState("HIGH");
        originator.restoreFromMemento(memento);
        System.out.println(originator.getState());
    }
}
