/*
 *
 * Allow an object to alter its behavior when its internal state changes. The
 * object will appear to change its class.
 *
 * Use the State pattern whenever:
 * An object's behavior depends on its state, and it must change its
 *      behavior at run-time depending on that state
 * Operations have large, multipart conditional statements that depend on the
 *      object's state. The State pattern puts each branch of the conditional in
 *      a separate class.
 */

package designpatterns.behavioral.state;

/**
 *
 * @author vijay
 */
public class FinancialLevel {

    public static void main(String[] args){
        Context context = new Context();        
        System.out.println("Initial State -> "+context.getCurrentStatus());
        context.earn();
        System.out.println("After Saving, new State -> "+context.getCurrentStatus());
        context.earn();
        System.out.println("After Saving, new State -> "+context.getCurrentStatus());
        context.spend();
        System.out.println("After Spending, new State -> "+context.getCurrentStatus());
        context.spend();
        System.out.println("After Spending, new State -> "+context.getCurrentStatus());
    }
}


//CONTEXT
class Context{
    Status status;//represents STATE
    Context(){
        setStatus(new PoorClass());
    }

    public String getCurrentStatus() {
        return status.getStatusLevel();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void earn(){
        status.handleEarn(this);
    }

    public void spend(){
        status.handleSpend(this);
    }

}
interface Status{
    //HANDLE METHODS
    public void handleSpend(Context context);
    public void handleEarn(Context context);

    public String getStatusLevel();
}

class PoorClass implements Status{
    public void handleSpend(Context context){
        context.setStatus(new PoorClass());
    }
    public void handleEarn(Context context){
        context.setStatus(new MiddleClass());
    }
    public String getStatusLevel(){
        return "Poor";
    }
}

class MiddleClass implements Status{
    public void handleSpend(Context context){
        context.setStatus(new PoorClass());
    }
    public void handleEarn(Context context){
        context.setStatus(new RichClass());
    }
    public String getStatusLevel(){
        return "Middle";
    }
}

class RichClass implements Status{
    public void handleSpend(Context context){
        context.setStatus(new MiddleClass());
    }
    public void handleEarn(Context context){
        context.setStatus(new RichClass());
    }
    public String getStatusLevel(){
        return "Rich";
    }
}
