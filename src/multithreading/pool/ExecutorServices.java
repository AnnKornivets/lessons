package multithreading.pool;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {
        //создает фиксированное количество потоков

        ExecutorService fixedPool= Executors.newFixedThreadPool(2);
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));

        fixedPool.shutdown();


        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown(); //дальше не используется

        ExecutorService cashedThread = Executors.newCachedThreadPool();
        cashedThread.submit(new RunnableTask("cashedThread"));
        cashedThread.submit(new RunnableTask("cashedThread"));
        cashedThread.submit(new RunnableTask("cashedThread"));
        cashedThread.submit(new RunnableTask("cashedThread"));
        cashedThread.submit(new RunnableTask("cashedThread"));
        cashedThread.submit(new RunnableTask("cashedThread"));

        cashedThread.shutdown();

        //отложенное выполнение

        ScheduledExecutorService scheduledService=Executors.newSingleThreadScheduledExecutor();
        Future future1=scheduledService.schedule(new CallableTask("scheduledService "),5,TimeUnit.SECONDS);
        try {
            System.out.println(future1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        scheduledService.shutdown();
        //выполнение каждые 5 секунд
        ScheduledExecutorService runEveryFiveSeconds=Executors.newSingleThreadScheduledExecutor();
        runEveryFiveSeconds.scheduleAtFixedRate(new RunnableTask("runEveryFiveSeconds "),0,5,TimeUnit.SECONDS);
        runEveryFiveSeconds.shutdown();

        ScheduledExecutorService everySeconds=Executors.newSingleThreadScheduledExecutor();
        everySeconds.scheduleWithFixedDelay(new RunnableTask("everySeconds "),0,1,TimeUnit.SECONDS);
        everySeconds.shutdown();




    }
}


class CallableTask implements Callable<Integer>{
    String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Поток: "+ Thread.currentThread().getName()+" из пула "+name+"="+(2+3));
        return 2+3;

    }
}

class RunnableTask implements Runnable{
    String name;

    public RunnableTask (String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println("Поток: "+ Thread.currentThread().getName()+" из пула "+ name+"="+(2+3));

    }
}