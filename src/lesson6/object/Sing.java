package lesson6.object;

public class Sing {
    private static Sing ourInstance = new Sing();

    public static Sing getInstance() {
        return ourInstance;
    }

    private Sing() {
    }
}
