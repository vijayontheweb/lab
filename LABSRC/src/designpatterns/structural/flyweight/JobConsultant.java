/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vijay
 */
public class JobConsultant {//CLIENT

    public static void main(String[] args) {
        IndustryFactory factory = IndustryFactory.getInstance();
        Industry industry = factory.locateIndustryFromPool("IT");
        industry.printCandidate("SSE");
        industry.printCandidate("Architect");
        industry = factory.locateIndustryFromPool("MED");
        industry.printCandidate("Doctor");
        industry.printCandidate("Nurse");
        //REUSED
        industry = factory.locateIndustryFromPool("IT");
        industry.printCandidate("Tester");
    }
}

class IndustryFactory {//FLYWEIGHT FACTORY

    Industry industry;
    Map<String, Industry> industryMap = new HashMap<String, Industry>();

    static IndustryFactory getInstance() {
        return new IndustryFactory();
    }

    public Industry locateIndustryFromPool(String industryStr) {//GET FLYWEIGHT

        if (industryMap.get(industryStr) == null) {
            if ("IT".equals(industryStr)) {
                industry = new ITIndustry();
            } else if ("MED".equals(industryStr)) {
                industry = new MedicalIndustry();
            }
            industryMap.put(industryStr, industry);
        }
        return (Industry) industryMap.get(industryStr);
    }
}

interface Industry {//FLYWEIGHT INTERFACE

    void printCandidate(String title);
}

class ITIndustry implements Industry {//CONCRETE FLYWEIGHT 1

    public void printCandidate(String title) {//title Extrinsic
        System.out.println("IT ->" + title);
    }
}

class MedicalIndustry implements Industry {//CONCRETE FLYWEIGHT 2

    public void printCandidate(String title) {//title Extrinsic
        System.out.println("Medical ->" + title);
    }
}