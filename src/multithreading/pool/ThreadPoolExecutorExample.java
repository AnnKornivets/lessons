package multithreading.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue= new LinkedBlockingQueue<>();

        ThreadPoolExecutor pool= new ThreadPoolExecutor(
                1,//основное количество потоков
                10,// максимальное количество потоков
                2, TimeUnit.MINUTES,// как долго могут простаивать потоки
                new ArrayBlockingQueue<>(3) //очередь в которую задачи будут помещаться //принято ограничивать очередь
        ); // можем указать настройки пула

        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task3());
        queue.add(new Task3());
        queue.add(new Task2());
        queue.add(new Task3());
        queue.add(new Task2());
        queue.add(new Task());

        for (Runnable runnable:queue){
            pool.execute(runnable);
        }

        pool.shutdown();

    }


}


class Task implements Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task: " + Thread.currentThread().getName());

    }
}


class Task2 implements Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2: " + Thread.currentThread().getName());

    }
}

class Task3 implements Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3: " + Thread.currentThread().getName());

    }
}