package multithreading.synchronises;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static  final CountDownLatch START=new CountDownLatch(6); //число событий

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<3;i++){
            new Thread(new Runner(2000)).start();
        }

        while (START.getCount()>3){
            Thread.sleep(100);

        }
        Thread.sleep(1000);
        System.out.println("На старт"); //событие
        START.countDown();
        Thread.sleep(1000);
        System.out.println(" Внимание");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("  Мaрш");
        START.countDown();
    }



    public  static class Runner implements Runnable{
long sleep;

        public Runner(long sleep) {
            this.sleep = sleep;
        }

        @Override
        public void run() {

            try {
                System.out.println("Бегун " + Thread.currentThread().getName()+" на старте");
                START.countDown();//уменьшение счетчика на 1
                START.await(); //блокирование потока, пока значение счетчика не будет равно нулю
                Thread.sleep(sleep);
                System.out.println("Бегун " + Thread.currentThread().getName()+" финишировал");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}




