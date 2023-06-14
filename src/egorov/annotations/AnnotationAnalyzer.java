/**
 * ClassAnalizer.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Jun-2023 16:02
 */

package egorov.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationAnalyzer {
    public static void main(String[] args) {
        AnnotationAnalyzer.check(TestClass.class);
        var testClass = new TestClass();

        testClass.deprecatedMethod();
        testClass.securedMethod();
    }
    public static void check(Class<?> clazzz) {
        //Class<?> clazzz = object.getClass();
        Method[] methods = clazzz.getDeclaredMethods();
        for (int i = 0; i < methods.length ; i++) {
            Method m = methods[i];
            if (m.isAnnotationPresent(DeprecatedMethod.class)){
                System.out.println("Warning. Deprecated method '" + m.getName() + "' used in class " + clazzz.getName());
                m.setAccessible(false);
            }
            if (m.isAnnotationPresent(Secured.class)){
                String[] permissions = m.getAnnotation(Secured.class).value();
                System.out.println("" + "Method '" + m.getName() + "' with @Secured annotation has following permissions");
                System.out.println(Arrays.toString(permissions));

            }

        }
    }


}
