package lesson3;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        String string="Строка"; //добавляет в пул строк
        char charVar='a'; //до 9 ,строки как массив char, после как byte

        String string2="Строка2"; //ссылка на string
        String string3=new String("Строка"); // создается обЪект и ссылка на него , не стоит создавать
        string3=string3.intern(); // добавляет в пул строк

        //сравнение строк
        System.out.println(string==string2); //сравнивает ссылки на один и тот же объект в памяти
        System.out.println(string==string3);

        //сравнение строк
        String string4=new String("Строка");

        System.out.println(string.equals(string4));
        //сравнение без учета регистра
        System.out.println(string.equalsIgnoreCase(string4));

        System.out.println(string.startsWith("Ст"));
        System.out.println(string.endsWith("a"));

        //сортировка строк

         String[] strArr={string,string2,string4};
        Arrays.sort(strArr);

        //конкатенация строк (склеивание)
        String string5="Str 1";
        String string6="Str 2";
        String string7=string5+string6;

        //в цикле

        String string8="Начало";
        for (int i=0;i<3;i++){
            string8+=" итерация цикла"; //не рекомендуется
        }
        System.out.println(string8);

        StringBuilder stringBuilder; //быстрее
        StringBuffer stringBuffer; //потоко безопасен


        string8="Начало";
        StringBuilder stringBuilder1=new StringBuilder();
        stringBuilder1.append(string8);

        for (int i=0;i<3;i++){
            stringBuilder1.append(" итерация цикла")
                    .append(" ")
                 .append(i)
                    .append(" ");

        }
        string8=stringBuilder1.toString();
        System.out.println(string8);
        //методы работы со строками

        string8.substring(2);   //взятие подстроки
        string8.substring(2,7);
        System.out.println( string8.substring(2,7));

        string8.split("");// позволяет разбить строку на массив

        //по регулярному выражению
        System.out.println( Arrays.toString( string8.split("")));

        System.out.println(string8.trim()); //удаляет пробелы в конце и начале

        string8.replaceAll("","new str"); // найдет все совпадения и заменит их

    }
}
