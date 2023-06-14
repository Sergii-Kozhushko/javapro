/**
 * Test.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Jun-2023 12:56
 */

package egorov.annotations;

/*Создать аннотацию @DeprecatedMethod для пометки метода как устаревшего.
        Методы, помеченные этой аннотацией, должны быть доступными только
        в режиме чтения и должны выдавать предупреждение о своем использовании.*/

public class TestClass {


    @DeprecatedMethod
    public void deprecatedMethod() {
        System.out.println("Deprecated method is executed");
    }

    @Secured({"read", "write"})
    public void securedMethod() {
        System.out.println("Method with @Secured annotation executed");
    }

    public void nonDeprecatedMethod() {

    }
}



