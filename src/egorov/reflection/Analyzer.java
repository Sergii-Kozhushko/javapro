/**
 * Main.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 03-Jun-2023 15:04
 */

package egorov.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        analyzeClass(new Car("BMW"));
        // создать экземпляр класса, введенного с клавиатуры

        setPrivateField();
        callPrivateMethod();


    }

    public static void createObjectDynamically() {
        System.out.println("Enter full class name: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();

        try {
            var car = Class.forName(className).getDeclaredConstructor().newInstance();

            // creating object with parameter constructor
            var car2 = Class.forName(className).getConstructor(new Class[]{String.class}).newInstance("BMW");
            System.out.println("Create object dynamically" + car);
            System.out.println("Create object dynamically with parameters constructor: " + car2);


        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void analyzeClass(Object o) {
        Class clazz = o.getClass();
        System.out.println("Analyzing object class.");
        System.out.println("Name: " + clazz);
        System.out.println("Fields: " + Arrays.toString(clazz.getDeclaredFields()));
        System.out.println("Parent class: " + clazz.getSuperclass());
        System.out.println("Class methods: " + Arrays.toString(clazz.getDeclaredMethods()));
        System.out.println("Constructors: " + Arrays.toString(clazz.getConstructors()));
    }

    public static void setPrivateField() {
        try {
            var carClass = Class.forName("egorov.reflection.Car");
            Car carObj = (Car) carClass.getDeclaredConstructor().newInstance();
            Field field = carClass.getDeclaredField("model");
            field.setAccessible(true);
            field.set(carObj, "Audi");
            System.out.println("Changed private field 'model' value of Object Car: " + carObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void callPrivateMethod() {
        Car car = new Car();
        try {
            var clazz = Class.forName(Car.class.getName());
            Method method = clazz.getDeclaredMethod("privateMethod");
            method.setAccessible(true);
            method.invoke(car);// вызов приватного метода
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
