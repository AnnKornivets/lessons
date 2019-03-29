package nested;

public class Main {
    public static void main(String[] args) {
        Food apple= new Food.Builder(4)
                .calories(45)
                .fat(6)
                .build();
        System.out.println(apple);



    }
}
