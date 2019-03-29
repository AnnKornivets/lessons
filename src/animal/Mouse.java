package animal;

public class Mouse  extends Animal implements Run {
    @Override
    public void run() {
        System.out.println("Run for life");
    }
}
