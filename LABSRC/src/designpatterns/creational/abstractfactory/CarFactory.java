package designpatterns.creational.abstractfactory;

public class CarFactory{
	public static void main(String[] args){
		Car car1 = new MarutiCar();
		Sports sports1 = car1.getSports();
		sports1.driveFast();
		Car car2 = new HyundaiCar();
		Sports sports2 = car2.getSports();
		sports2.driveFast();
	}
}

interface Car{
	 Sports getSports();
	 Economy getEconomy();
}

interface Sports{
	 void driveFast();
}

interface Economy{
	 void driveSlow();
}

class MarutiCar implements Car{
	 public Sports getSports(){
		return new Baleno();
	}
	 public Economy getEconomy(){
		return new Alto();
	}
}

class HyundaiCar implements Car{
	public Sports getSports(){
		return new Accent();
	}
	public Economy getEconomy(){
		return new Santro();
	}
}

class Baleno implements Sports
{
	public void driveFast(){
		System.out.println("Baleno drives fast");
	}
}

class Accent implements Sports
{
	public void driveFast(){
		System.out.println("Accent drives fast");
	}
}

class Alto implements Economy
{
	public void driveSlow(){
		System.out.println("Alto drives slow");
	}
}

class Santro implements Economy
{
	public void driveSlow(){
		System.out.println("Santro drives slow");
	}
}


