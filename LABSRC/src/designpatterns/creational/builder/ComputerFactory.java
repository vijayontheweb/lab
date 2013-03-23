/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.creational.builder;

/**
 *
 * @author vijay
 */
public class ComputerFactory {

    public static void main(String[] args){
        Builder builder = new DellBuilder();
        Director director = new Director(builder);
        Computer computer = director.buildComputer();
        computer.printDetails();
        builder = new IBMBuilder();
        director = new Director(builder);
        computer = director.buildComputer();
        computer.printDetails();
    }
}
    class Director{
        Builder builder;
        Director(Builder builder){
            this.builder = builder;
        }
        Computer buildComputer(){
            builder.buildMonitor();
            builder.buildCPU();
            builder.buildKeyboard();
            return builder.getFinalProduct();
        }

    }

    interface Builder{
        void buildMonitor();
        void buildCPU();
        void buildKeyboard();
        Computer getFinalProduct();
    }

    class Computer{
        String name;
        String monitor;
        String cpu;
        String keyboard;

        Computer(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCpu() {
            return cpu;
        }

        public void setCpu(String cpu) {
            this.cpu = cpu;
        }

        public String getKeyboard() {
            return keyboard;
        }

        public void setKeyboard(String keyboard) {
            this.keyboard = keyboard;
        }

        public String getMonitor() {
            return monitor;
        }

        public void setMonitor(String monitor) {
            this.monitor = monitor;
        }

        public void printDetails(){
            System.out.println(name);
            System.out.println("---------------");
            System.out.println("Monitor: "+monitor);
            System.out.println("CPU: "+cpu);
            System.out.println("Keyboard: "+keyboard);
        }

    }

    class DellBuilder implements Builder{
        Computer computer;
        DellBuilder(){
            computer = new Computer("Dell");
        }
        public void buildMonitor(){
            computer.setMonitor("Sony");
        }
        public void buildCPU(){
            computer.setCpu("Intel");
        }
        public void buildKeyboard(){
            computer.setKeyboard("Logitech");
        }
        public Computer getFinalProduct(){
            return computer;
        }
    }

    class IBMBuilder implements Builder{
        Computer computer;
        IBMBuilder(){
            computer = new Computer("IBM");
        }
        public void buildMonitor(){
            computer.setMonitor("LG");
        }
        public void buildCPU(){
            computer.setCpu("AMD");
        }
        public void buildKeyboard(){
            computer.setKeyboard("Samsung");
        }
        public Computer getFinalProduct(){
            return computer;
        }
    }


