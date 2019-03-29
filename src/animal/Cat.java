package animal;
// метод run,метод eat
public class Cat extends Animal implements Run,Eat { //реализует метод описаный в интерфейсе

    @Override
    public void run() {
        System.out.println("Run");

    }

    @Override
    public void eat(Animal animal) {

    }

    @Override
    public void stop() {
        System.out.println("Mouse Stop");
    }
}
