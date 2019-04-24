package multithreading.synchronize;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;

public class Counter {
    int counter=0;

    public synchronized void increment(){
        counter++;
    }
}


class IncrementThread extends Thread{
    Counter counter;

    public IncrementThread(Counter counter){
        this.counter=counter;
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
//            synchronized (counter){//не может несколько потоков брать объект
//            counter.counter++;}
            counter.increment(); //аналогично(быстрее)
        }

    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        ArrayList<IncrementThread> threads =new ArrayList<>();

        //создаем потоки

        for(int i=0;i<100;i++){
            threads.add(new IncrementThread(counter));
        }

        //запуск потоков
        for (IncrementThread thread: threads){
            thread.start();
        }
//ждем завершения
        for (IncrementThread thread: threads){
            thread.join();
        }
//
        System.out.println("counter: "+counter.counter);

    }
}