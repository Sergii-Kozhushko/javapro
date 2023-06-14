package egorov.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Создать аннотацию @Secured, которая будет применяться к методу и указывать,
        что данный метод требует определенных прав доступа. Аннотация должна иметь следующие параметры:
        value: массив строк, представляющих разрешения, необходимые для выполнения метода.
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Secured {
    String[] value();
}
