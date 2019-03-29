package lesson6.object.staticFinal;

public class CalcUtils {



    //статические переменные (свойства)
    static double PI=3.14;
    //статические блоки
    static {
        PI=3.14;
    }



    //статический метод
    public static double summ(int a, int b){
        return a+b;
    }
    //final методы нельзя переопределить в дочерных классах
    //final аргументы доступны только для чтения в методе
    public final void someVoid(final int a){}
}
/*class Utils extends CalcUtils{
    @Override
public final void someVoid(){}}*/ //нельзя так делать
