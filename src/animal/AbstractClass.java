package animal;

public abstract class AbstractClass implements SomeInterface { //методы с реализации или без реализации
    public  abstract void abstractVoid();

    public void someVoid(){
        System.out.println("someVoid");
    }
}
interface  SomeInterface{
    public void iVoid();

}



class SomeClass extends AbstractClass{


    @Override
    public void abstractVoid() {
        System.out.println("Реализация метода абстрактного класса");
    }

    @Override
    public void iVoid() {
        someVoid();

    }

}
