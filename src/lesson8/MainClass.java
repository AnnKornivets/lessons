package lesson8;

import sun.util.locale.provider.JRELocaleConstants;
interface I{
    void some();
    //default void some(){};
}

public class MainClass {



    private  void SomeVoid2(){
        int a=124;
        String str="String";
    }

    private  void SomeVoid(){
        int a=12;
        SomeVoid2();
    }

    public static void main(String[] args) {
        MainClass mainClass=new MainClass();
        mainClass.SomeVoid();
    }



}
