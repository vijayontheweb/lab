/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.structural.proxy;

/**
 *
 * @author vijay
 */
public class ProxyAttendance {
    public static void main(String[] args){
        Student proxy = new ProxyStudent();
        proxy.sayAttendance("Vijay");
        proxy.sayAttendance("Priya");
    }

}

interface Student{//SUBJECT
        void sayAttendance(String name);
    }

    class RealStudent implements Student{//REAL SUBJECT
        public void sayAttendance(String name){
            System.out.println(name+". Present Sir");
        }
    }

    class ProxyStudent implements Student{//PROXY
        public void sayAttendance(String name){
            new RealStudent().sayAttendance(name);
        }
    }