package lesson11.exception;

import java.util.Arrays;

public class CatchException<b> {

    public static void main(String[] args) {
        //целочисленное деление на ноль

        int a = 9;
        int b = 0;
        System.out.println(a / b); //ArithmeticException

////////////////////////////////////////////////////////////////////////

        //попытка получить 10й элемент массива
        //из массива размером 5
        int[] arr = new int[5];
        arr[10] = 12;
        System.out.println(Arrays.toString(arr)); //ArrayIndexOutException

/////////////////////////////////////////////////////////////////////////////////////

        String str = null;
        str.equals("string"); //NoilPointerException

/////////////////////////////////////////////////////////////////////////////////////

        Integer.parseInt("asd");//NumberFormatException

/////////////////////////////////////////////////////////////////////////////////////

        //обработка исключений осуществляется при помощи try catch

        Object data = "42";
        //  Integer intData=(Integer)data; //ClassCastException

        try {
            Integer intData = (Integer) data; //ClassCastException
            System.out.println(" после Exception внутри try");
        } catch (ClassCastException e) {
            System.out.println("ClassCastException" + e.getMessage());

        }
        System.out.println("Код после try catch");


        try {
            if (System.currentTimeMillis() % 2 == 0) {
                Integer intData = (Integer) data;
            } else {
                arr[12] = 14;
            }


        }
//        catch (ClassCastException e){
//            System.out.println("ClassCastException");
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("ArrayIndexOutOfBoundsException");
//        }
        //или так
        //catch(ClassCastException"|ArrayIndexOutOfBoundsException e){
        //  System.out.println("ClassCastException"+"ArrayIndexOutOfBoundsException"+e.getMessage());}


        // RunTimeException

        catch (RuntimeException e) {
            System.out.println("RuntimeException" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("блок Finally");
            //только для закрытия ресурсов, открытых в блоке try(высвобождение ресурсов)
        }

        try {
            voidWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try { voidWithCheckedException(6);

        } catch (CheckedException e){
            System.out.println("Checked" +e.getMessage());

            try {
                throw new UncheckedException("Uchecked",e);

            }
            catch (UncheckedException e1){
                System.out.println("e1"+e1.getCause());
            }
        }

    }




    public static void voidWithException() throws Exception {

        //обрабатываемые исключения (checked exception)
//        try {
//            throw  new Exception("Some Exception ");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        throw  new Exception("Some Exception ");
//    }


        int a = 9;
        int b = 0;
        if (b == 0) {
//            try {
//                throw new Exception("Some Exception");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            throw  new CheckedException("Собственное исключение");
        }
    }
    public static void voidWithCheckedException(int i) throws CheckedException{
        if(i<10){
            throw new CheckedException("Bad");
        }
    }

}
