package lesson13.annotation;


import java.lang.annotation.*;

//@Documented
@Target(ElementType.METHOD)
// перед чем мы можем ее поставить
//TYPE  к чему угодно
//METHOD только к методу
//FIELD исключительно  полю
//CONSTRUCTOR к конструкторам
//PARAMETER  применяем к параметру метод

//@Inherited // будет передоваться по наследованию

@Retention(RetentionPolicy.RUNTIME) // время жизни анотации

public @interface MethodInfo {
    String date();
    String author();
    int version() default 1;

}
