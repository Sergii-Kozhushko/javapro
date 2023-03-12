/**
 * Start.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 11-Mar-2023 18:18
 */

package egorov.patterns.prototype;

import egorov.MyIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Start {
    public static void main(String[] args) {
//      Address address = new Address("Kollontay", 15);
//      Person person = new Person("Mike", 38, address);
//
//      Person person2 = new Person(person);
//      System.out.println("---------------------------------");
//
//      System.out.println(person2 == person);
//      System.out.println(person2.name == person.name);
//      System.out.println(person2.address.street == person.address.street);
//      System.out.println("---------------------------------");
//
//      person.name = "test name";
//      System.out.println(person2.name);
//      System.out.println("-->> " + person2.name == person.name);
//
//      person.address.street = "test street";
//      System.out.println(person2.address.street);
//      Address adr1 = new Address("street 1", 1);
//      Address adr2 = new Address(adr1);
//      System.out.println("adr1=" + adr1);
//      System.out.println("adr2=" + adr2);
//      System.out.println("_________________________");
//      adr1.street = "street1 changed";
//      System.out.println("adr1=" + adr1);
//      System.out.println("adr2=" + adr2);
        Address adr1 = new Address("street 1", 1);
        Person person1 = new Person("Person 1", 30, adr1);
        System.out.println(person1.address);

        Person person2 = new Person("Person 2", 30, adr1);
        person2 = person1;// сейчас объекты идентичны
        //System.out.println(person1 instanceof Object);
        Iterator iterator = new ArrayList<>().iterator();



    }
}
