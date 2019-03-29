package lesson6.object;

public class SomeClass {

private static SomeClass obj=new SomeClass(); //создание объекта

    private  SomeClass(){}

    static SomeClass getObj(){
        return new SomeClass();
    }



        public void printInfo(String string){
            System.out.println(" "+string);
        }

}


class SomeClass2{ //воспользоваться классом SOme Class
    public void SomeVoid(){
        SomeClass someClass=SomeClass.getObj(); //new SomeClass();

        someClass.printInfo("Господи");


    }

}