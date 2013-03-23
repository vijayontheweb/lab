package designpatterns.behavioral.visitor;

/**
 * DOCUMENT ME!
 *
 * @author Perot Systems Germany 
 * @version $Id:$
 *
 * @created 2007
 *
  */
public class VisitorExample {
	public static void main(String[] args){
		FoodVendor foodVendor = new FoodVendor();
		Visitable first = new FirstClassCustomer("Vijay");
		Visitable business = new BusinessClassCustomer("Priya");
		Visitable economy = new EconomyClassCustomer("Anand");
		first.accept(foodVendor);
		business.accept(foodVendor);
		economy.accept(foodVendor);
	}
}


interface Visitable {
    void accept(final Visitor visitor);
}


interface Visitor {
    void visit(FirstClassCustomer firstClassCustomer);
    void visit(BusinessClassCustomer businessClassCustomer);
    void visit(EconomyClassCustomer economyClassCustomer);
}


class FoodVendor implements Visitor {


    public void visit(FirstClassCustomer first) {
        System.out.println("FoodVendor visited FirstClassCustomer " + first.getName());
    }
    
    public void visit(BusinessClassCustomer business) {
        System.out.println("FoodVendor visited BusinessClassCustomer " + business.getName());
    }
    
    public void visit(EconomyClassCustomer economy) {
        System.out.println("FoodVendor visited EconomyClassCustomer " + economy.getName());
    }
}


class FirstClassCustomer implements Visitable {
    String name;

    FirstClassCustomer(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}

class BusinessClassCustomer implements Visitable {
    String name;

    BusinessClassCustomer(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}

class EconomyClassCustomer implements Visitable {
    String name;

    EconomyClassCustomer(final String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
