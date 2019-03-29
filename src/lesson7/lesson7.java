package lesson7;

import javax.swing.*;

public class lesson7 {
    public static void main(String[] args) {
        int a=5;

        //использование оболочки
        java.lang.Integer intVar=5;
        Byte byteVar;
        Float floatVar;
        Double doubleVar;
        Character character;
        Short shortVar;
        Boolean bool;

        System.out.println(Integer.MAX_VALUE); //вернут максимальное значение
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MAX_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);

        // методы, преобразующие строку в число

        System.out.println(Byte.parseByte("2")); //примитив byte
        System.out.println(Byte.valueOf("23"));//Byte

        System.out.println(Integer.parseInt("2")); //int
        System.out.println(Integer.valueOf("45"));// Integer


        //Integer int1 =new Integer("23");
        Integer int1=2; //автоупоковка
        Integer int2=2;

        //-127 до 128

        if(int1==int2){
            System.out.println("int1==int2");
        }

        //сравнивает отдельные объекты
        Integer int3=300;
        Integer int4=300;
        if(int3==int4){
            System.out.println("int3=int4");
        }
        else {
            System.out.println("int3!=int4");
        }

        Integer res = int1+int2; // при сложении из объекта будет примитив, а потом сново упаковка в объект
        System.out.println(Integer.compare(int1,int2));
        System.out.println(Integer.max(int1,int3));
        System.out.println(Integer.min(int1,int3));
        System.out.println(Integer.hashCode(25));
        Integer.sum(5,9);

        //System.out.println(Integer.parseInt("45aqw"));  ошибка

        //методы доступные объекту,приведение типов
        int1.longValue(); //возвращают примитив
        int2.doubleValue();

    }
}
