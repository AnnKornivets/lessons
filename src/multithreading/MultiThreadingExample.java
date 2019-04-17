package multithreading;

public class MultiThreadingExample {


    // start позволяет запускать поток
    // Thread.currentThread(); получение текущего потока
    //setName задать потоку имя
    //getName получить имя потока
    //getState() возвращает текущее состояние потока
    //isAlive пишет выполняется или завершился поток (true,false)
    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();

        Thread myThread = new Thread();
        myThread.start();

        try {
            Thread.sleep(100); // приостановить поток на время
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1=new Thread(new OtherThread("Один"));
        System.out.println("thread1: " + thread1.getState());
        Thread thread2=new Thread(new OtherThread("Два"));
        Thread thread3=new Thread(new OtherThread("Три"));
        thread1.start();
        thread2.start();
        thread3.start();


        try {
            System.out.println("Ожидание завершения потоков");
            thread1.join(); //основной поток ждет thread1,thread2,thread3
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //инициализация анонимным классом

         Thread  thread4= new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println("Running : " + Thread.currentThread().isAlive());
                 System.out.println("Running : " + Thread.currentThread().getState());

             }
         });
        thread4.start();
        System.out.println("thread1: " + thread1.getState());
        //thread4.setDaemon(true); // когда завершится основной поток завершится

        Thread whilethread = new WhileThreade();
       // whilethread.start();
       // whilethread.setDaemon(true); бесконечная


        //Прерывание потоков
        //Поток останавливается в след.случаях
        //1.Если поток выполнил все инструкции и завершился(Вышел из метода run())
        //2.Если в потоке было выброшено необрабатываемое исключение
        //3.Если остановилас виртуальная машина JVM
        //4.Если это Deamon поток и основной поток завершил свою  работу



        //у каждого потока существует флаг, этот флаг можно проверить методом isInterrupted()// запущен поток или нет;
        //interrupt() меняет значение флага
        Thread thread5= new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("Thread5");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }

            }
        });
        thread5.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // thread5.interrupt();

        //System.out.println("Завершение основного потока");

    }
}
class WhileThreade extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("WhileThread");
        }
    }
}

//создание класса пoтока
//наследование от класса Thread
class MyTread extends Thread{
    @Override
    public void run(){
        Thread.currentThread().setName("MyThread");
        System.out.println(Thread.currentThread().getName());

    }
}

class OtherThread implements Runnable{

String name;

public OtherThread(String name){
    this.name=name;

}
    @Override
    public void run() {
    Thread.currentThread().setName(name);
    for(int i=0;i<3;i++){
        System.out.println(Thread.currentThread().getName() +" " + i);
    }

    }
}