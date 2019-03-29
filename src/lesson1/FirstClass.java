package lesson1;

public class FirstClass {
                                            //psvm точка входа
    public static void main(String[] args) {
        System.out.println("Some info");    //sout

        //примитивные
        //byte (целые,1 байт)
        //short (целые, 2 байта)
        //int (целые, 4 байта)
        //long (целые, 8 байта)
        //float (4 байта)
        //double (8 байта)
        //chart (2 байта)
        //boolean (1 байт)

        //объявление переменной
        //типДанных имяПеременной = значение;
        //типДанных имяПеременной1,имяПеременной2,имяПеременной3;

        //целые типы
        byte byteVar = 2;
        short shortVar1=5;
        short shortVar2=38;
        int shortVar3=shortVar1+shortVar2+byteVar;
        System.out.println(shortVar3);
        boolean boolVar = shortVar1>byteVar;
        int a=1_000_000;
        int b=9;
        int c=5;
        //при делении остаток отбрасывается
        // при делении на ноль получим ошибку
        int res=b/c;
        long longVar = 200000000000L;

        //числа с плавающей запятой
        float floatVar=2.3F;
        double doubleVar=2.3;

        boolean isActive =true;
        boolean started =false;


        int j=200;
        long k=j; //автоматическое преобразование

        long n=90;
        int m=(int)n; //приведение типов


        //тернарный оператор
        //переменная a = (условие)? выражение1:выражение2;
        int z=6;
        int x =8;
        int r = (z<8)? z*x:z+x;

        //ссылочные типы

    }
}
