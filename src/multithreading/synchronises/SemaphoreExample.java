package multithreading.synchronises;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    //объекты синхронизации
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(1);
        new IncrementThread("Increment",semaphore);
        new DecrementThread("Decrement",semaphore);
    }

}
//общий ресурс
class Counter{
    static  int count=0;
}

class IncrementThread implements Runnable{

    String name;
    Semaphore semaphore;

    public IncrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Начало работы потока " + name);


        try {
            System.out.println("Ожидание разрешение потоком " + name);
            semaphore.acquire(); //запрашивает разрешение , переключение на ноль
            System.out.println("Поток "+name+" разрешение получил " );
            for (int i =0;i<5;i++){
                Counter.count++;
                System.out.println("Counter.count= " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Потоку "+name+" больше не нужно разрешение ");
        semaphore.release(); // отпустить разрешение,  переключение на 1
    }
}
class DecrementThread implements Runnable{
    String name;
    Semaphore semaphore;

    public DecrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Начало работы потока " + name);
        try {
            System.out.println("Ожидание разрешение потоком " + name);
            semaphore.acquire(); //запрашивает разрешение , переключение на ноль
            System.out.println("Поток "+name+" разрешение получил " );
            for (int i =0;i<5;i++){
                Counter.count--; //разница реализаций
                System.out.println("Counter.count= " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Потоку "+name+" больше не нужно разрещение ");
        semaphore.release(); // отпустить разрешение,  переключение на 1
    }

    }
