package lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {


        //Встроенные функциональные интерфейсы
        //Интерфейс Predicate <T>
        //метод: boolean test(T,t);
        //default методы:
        //and(Predicate other);
        //or(Predicate other);
        //negative();

//Здесь не может быть вычислений, проверяем условия
        Predicate<Integer> pos = (num) -> num > 0;
        Predicate<Integer> neg = (num) -> num < 0;
        Predicate<Integer> four = (num) -> num == 4;

        System.out.println(pos.test(45)); // true
        System.out.println(neg.test(45));//false
        System.out.println(four.test(45));//false

        System.out.println(pos.and(four).test(6));//false
        System.out.println(pos.or(four).test(6)); // true

        //Интерфейс Function<T,R> ,принимает на вход значение типа T , а возвращает R
        // преобразование одного типа данных в другой
        //метод: R apply(T t)
        //default методы:
        //andThen(Function after);
        //compose(Function before);

        Function<Integer,String> convert= a->a+"$";
        System.out.println(convert.apply(45));
        System.out.println(convert.apply(15));

        Function<Integer,Double> tenPercent=a->a*0.1;
        System.out.println(tenPercent.apply(45));
        System.out.println(tenPercent.apply(15));

        Function<Integer,Integer> plusTen=a->a+10;
        Function<Integer,Integer> plusFive=a->a+5;

        double res=plusTen.andThen(plusFive).andThen(tenPercent).apply(20);
        System.out.println(res);

        Function<Integer,Integer> addTwo=a->a+2;
        Function<Integer,Integer> squareTwo=a->a*a;

        System.out.println(addTwo.andThen(squareTwo).apply(3));//25 1 2
        System.out.println(addTwo.compose(squareTwo).apply(3));//18 2 1

        //задача :
        //дан предикат Predicate condition и две функции Function ifTrue и ifFalse
        //написать метод, который вернет новую функцию (Function),возвращающую значение функции ifTrue ,если condition-true и наоборот

        Predicate<Integer> condition= num->num>0;
        Function<Integer,Integer> ifTrue=a->a+10;
        Function<Integer,Integer> ifFalse=a->a-10;


        Function<Integer,Integer> func=getFunction(condition,ifTrue,ifFalse);
        System.out.println(func.apply(34));
        System.out.println(func.apply(-34));

        //Интерфейс Consumer<T> принимает значение и ничего не возвращает
        //метод void accept(T,t);
        //default метод andThen(Consumer<T> after)

        //BinaryOperator<T> | UnaryOperator<T>



    }
    public static Function<Integer,Integer> getFunction(

            Predicate<Integer> condition,
    Function<Integer,Integer> ifTrue,
    Function<Integer,Integer> ifFalse )
    {
        return a->  condition.test(a) ? ifTrue.apply(a) :ifFalse.apply(a);
    }
}