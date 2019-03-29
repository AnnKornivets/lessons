package nested;

public interface Logger {
    public void log();

}

class SomeClass{

    public void someVoid(){
        //анонимный класс на основе итерфейса или абстрактных классов

        Logger logger=new Logger() {
            @Override
            public void log() {
                System.out.println("log smth");
            }
        };
        logger.log();


        Logger logger1=new Logger() {
            @Override
            public void log() {
                System.out.println("Парампампам");
            }
        };

    }
}