package lesson6.object.staticFinal;

public class Main {
    public static void main(String[] args) {
        String fileName ="file.json";
        //вызов статистического метода
        Handler handler=Handler.getInstance(fileName); //вернул объект

        handler.read();
        handler.write();


      //  CalcUtils calcUtils =new CalcUtils();
      //  calcUtils.summ(3,8);
        System.out.println(CalcUtils.summ(2,7));
    }
}
