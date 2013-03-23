/*
 * The Adapter pattern converts the interface of a class into an interface the client requires
 */

package designpatterns.structural.adapter;


/**
 *
 * @author vijay
 */

public class AdapterExample{
    public static void main(String[] args){
        BedInterface bed = new Bed();
        bed.lay();
        bed = new BedAdapterByObject(new Sofa());
        bed.lay();
        bed = new BedAdapterByClass();
        bed.lay();
        bed = new BedAdapterForMatByObject(new Mat());
        bed.lay();
        bed = new BedAdapterForMatByClass();
        bed.lay();
    }
}
class BedAdapterByObject extends Bed{
    Sofa sofa;
    BedAdapterByObject(Sofa sofa){
        System.out.println("BedAdapterByObject - Constructor called");
        this.sofa = sofa;
    }

    public void lay(){
        sofa.stretch();
    }
}

class BedAdapterByClass extends Sofa implements BedInterface{
    BedAdapterByClass(){
        System.out.println("BedAdapterByClass - Constructor called");
    }
    public void lay(){
        stretch();
    }
}




interface BedInterface{
    void lay();
}

class Bed implements BedInterface{
    public void lay(){
        System.out.println("Sleeping in Bed");
    }
}

class Sofa{
    void fold(){
        System.out.println("Sitting in Sofa");
    }

    void stretch(){
        System.out.println("Sleeping in Sofa");
    }
}

class Mat{
    void spread(){
        System.out.println("Sleeping in Mat");
    }
}


class BedAdapterForMatByObject extends Bed{
    Mat mat;
    BedAdapterForMatByObject(Mat mat){
        System.out.println("BedAdapterByObject - Constructor called");
        this.mat = mat;
    }

    public void lay(){
        mat.spread();
    }
}

class BedAdapterForMatByClass extends Mat implements BedInterface{
    BedAdapterForMatByClass(){
        System.out.println("BedAdapterForMatByClass - Constructor called");
    }
    public void lay(){
        spread();
    }
}