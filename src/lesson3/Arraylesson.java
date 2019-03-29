package lesson3;

import java.util.Arrays;

public class Arraylesson {
    public static void main(String[] args) {
        //java.util.Arrays
        //обЪявления переменной массива
        int[] arr; // более предпочтительный
        int arr2[];
        //создание массива
        arr=new int[5];
        System.out.println(Arrays.toString(arr));

        char[] chars=new char[3];
        System.out.println(Arrays.toString(chars));
        //null

        //размер массива изменять нельзя  arr=new int[5]; [0, 0, 0, 0, 0]
        int arrLenght=arr.length;
        System.out.println("Размер маасива " +arrLenght);

        // наполненный массив
        int[] arr3={2,4,6,1,89};
        arr3= new int[]{2,6}; //присвоили массиву новые переменные
        // обращение к элементу массива
        System.out.println(arr3[1]);


        int[] arr4=new int[4];
        for(int i=0;i<arr4.length;i++){

            arr4[i]+=4;
        }
        System.out.println(Arrays.toString(arr4));

        //коопирование массива
        int[] arr5={2,7,1,90};
        //int[] arr6=arr5; //ссылка на массив arr5


        //копирование массивов
        int[] arr6=arr5.clone();

        int[] arr7=new int[10];
        System.arraycopy(arr5, 1,arr7,2,2); // позволяет сделать частичную копию массива
        System.out.println(Arrays.toString(arr7));

        int[] arr8={2,7,1,90};
        int[] copyArr=Arrays.copyOf(arr8, 12);
        System.out.println(Arrays.toString(copyArr));


        //перебор массива
        for (int i=0;i<arr8.length;i++){
            System.out.println(arr8[i]);
        }
        System.out.println(Arrays.toString(arr8));

        /*for (int num:arr8){
            System.out.println(num);
            num+=3; ,бесполезно
        }
         System.out.println(Arrays.toString(arr8));*/

        //сравнение массивов
         int[] arr9 =new int[5];
        int[] arr10 =new int[5];
        System.out.println(arr9==arr10); //нельзя
        System.out.println(arr9.equals(arr10));//нельзя

        System.out.println(Arrays.equals(arr9,arr10));

       Arrays.fill(arr9,23); // наполняет массив значениями

        //поиск в массиве

        int[] arr11={2,4,6,1,89};
        System.out.println(Arrays.binarySearch(arr11,3)); //бинарный поиск
        //-(точка входа)-1 = -1-1


        //содержит ли массив указанный элемент

        String[] strArr={"qwe","sad","zxc"};
        System.out.println(Arrays.asList(strArr).contains("qwe"));

        //метод сортировки массива

         Arrays.sort(arr11); //алгоритм быстрой сортировки
        System.out.println(Arrays.toString(arr11));

    }
}
