package designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * A Command pattern is an object behavioral pattern that allows us to achieve complete decoupling between the
 * sender and the receiver. (A sender is an object that invokes an operation, and a receiver is an object that
 * receives the request to execute a certain operation. With decoupling, the sender has no knowledge of the Receiver's
 * interface.) The term request here refers to the command that is to be executed.      The Command pattern turns the
 * request itself into an object. This object can be stored and passed around like other objects. The key to this
 * pattern is a Command interface, which declares an interface for executing operations. In its simplest form, this
 * interface includes an abstract execute operation. Each concrete Command class specifies a receiver-action pair by
 * storing the Receiver as an instance variable.
 * 
 * Best examples are Multi-level Undo, Macro recording, Transactional behavior
 */
public class CommandExample {
    /**
     *
     *
     * @param args
     */
    public static void main(final String[] args) {
        Man man = new Man(); //This is receiver
        CreateMan createMan = new CreateMan(man); //Concrete Command Object that knows how to use receiver
        DestroyMan destroyMan = new DestroyMan(man); //Concrete Command Object that knows how to use receiver
        House house = new House(); //This is receiver
        CreateHouse createHouse = new CreateHouse(house); //Concrete Command Object that knows how to use receiver
        DestroyHouse destroyHouse = new DestroyHouse(house); //Concrete Command Object that knows how to use receiver
        CommandManager commandManager = new CommandManager(); //Invoker that actually invokes command to get executed
        commandManager.executeCommand(createMan);
        commandManager.executeCommand(destroyMan);
        commandManager.executeCommand(createHouse);
        commandManager.executeCommand(destroyHouse);
        System.out.println("-----------------------------------------");
        commandManager.playMacro();
        System.out.println("-----------------------------------------");
        commandManager.undoAllOperations();
    }
}


/**
 * Invoker(aka sender) is the one which invokes the command to be executed
 *
 * @author vijayana
 */
class CommandManager {
    private TransactionStack transactionStack = new TransactionStack();

    /**
     * @param cmd
     */
    public void executeCommand(final Command cmd) {
        cmd.execute();
        transactionStack.push(cmd);
    }
    /**
     * pops out all the commands in order out of stack and undoes it
     */
    public void undoAllOperations() {
        while (transactionStack.isNotEmpty()) {
            Command cmd = transactionStack.pop();
            cmd.undo();
        }
    }
    
    public void playMacro() {
    	int i=0;
    	while(i<transactionStack.size()){        
        	Command cmd = transactionStack.peek(i++);
        	cmd.execute();
        }
    }
}


/**
 * The command interface
 *
 */
interface Command {
    void execute();
    void undo();
}


/**
 * The concrete command object to create man
 */
class CreateMan implements Command {
    Man man;

    CreateMan(final Man man) {
        this.man = man;
    }

    /**
     * execute method
     */
    public void execute() {
        man.populateMan();
    }
    /**
     * undo method
     */
    public void undo() {
        man.undoPopulateMan();
    }
}


/**
 * The concrete command object to destroy man
 */
class DestroyMan implements Command {
    Man man;

    DestroyMan(final Man man) {
        this.man = man;
    }

    /**
     * execute method
     */
    public void execute() {
        man.killMan();
    }
    /**
     * undo method
     */
    public void undo() {
        man.undoKillMan();
    }
}


/**
 * The concrete command object to create house
 */
class CreateHouse implements Command {
    House house;

    CreateHouse(final House house) {
        this.house = house;
    }

    /**
     * execute method
     */
    public void execute() {
        house.constructHouse();
    }
    /**
     * undo method
     */
    public void undo() {
        house.undoConstructHouse();
    }
}


/**
 * The concrete command object to destroy house
 */
class DestroyHouse implements Command {
    House house;

    DestroyHouse(final House house) {
        this.house = house;
    }

    /**
     * execute method
     */
    public void execute() {
        house.demolishHouse();
    }
    /**
     * undo method
     */
    public void undo() {
        house.undoDemolishHouse();
    }
}


//Receiver #1
class Man {
    void populateMan() {
        System.out.println("Man Created");
    }
    void killMan() {
        System.out.println("Man Destroyed");
    }
    void undoPopulateMan() {
        System.out.println("undo Man Created");
    }
    void undoKillMan() {
        System.out.println("undo Man Destroyed");
    }
}


//Receiver #2
class House {
    void constructHouse() {
        System.out.println("House Created");
    }
    void demolishHouse() {
        System.out.println("House Destroyed");
    }
    void undoConstructHouse() {
        System.out.println("undo House Created");
    }
    void undoDemolishHouse() {
        System.out.println("undo House Destroyed");
    }
}


/**
 * Stores the transaction of command objects in a stack
 */
class TransactionStack {
    List<Command> transactions = null;

    /**
     * Creates a new TransactionStack object.
     */
    public TransactionStack() {
        transactions = new ArrayList<Command>();
    }

    /**
     * Pushes an executed command into the stack
     *
     * @param command
     */
    protected void push(final Command command) {
        transactions.add(command);
    }
    /**
     * pops out the command object that was executed last
     *
     * @return 
     */
    protected Command pop() {
        if (transactions.size() < 1) {
            System.out.println("Stack Empty. Can't Pop.");
            return null;
        }
        Command command = transactions.get(transactions.size() - 1);
        transactions.remove(command);
        return command;
    }
    /**
     * returns if the stack is empty or not
     *
     * @return 
     */
    protected boolean isNotEmpty() {
        return transactions.size() > 0;
    }
    
    protected int size(){
    	return transactions.size();
    }
    
    protected Command peek(int index){
    	return transactions.get(index);
    }
}
