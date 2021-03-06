package multithreading.pool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Article> articleThread = new ThreadTask();
        ArrayList<Future<Article>> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Future<Article> future = executorService.submit(articleThread);
            list.add(future);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        }
        for (Future<Article> future : list) {

                try {
                    System.out.println("Result: " + future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    class Article {
        private String title;

    }

    class ThreadTask implements Callable<Article> {

        @Override
        public Article call() throws Exception {
            Thread.sleep(399);
            Article artical = new Article();
            return null;
        }
    }
