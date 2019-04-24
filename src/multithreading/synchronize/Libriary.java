package multithreading.synchronize;

public class Libriary {
    public static void main(String[] args) {
        BookStorage storage=new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();
    }

}

class BookStorage{
    int booksCount=0;

    public synchronized void putBook() throws InterruptedException {
        System.out.println("Put book выполнение");
        while(booksCount>=5){
            wait();//режим ожидания
            System.out.println("put Book в ожидании...");
        }
        booksCount++;
        System.out.println(" 1 добавили, всего книг = " + booksCount);
        System.out.println("put Book окончание выполнения ");
    }


    public synchronized void getBook() throws InterruptedException {
        System.out.println("Get book выполнение");
        while(booksCount<1){
            wait();//режим ожидания
            System.out.println("get Book в ожидании...");
        }
        booksCount--;
        System.out.println(" 1 забрали, осталось = " +booksCount);
        System.out.println("get Book окончание выполнения ");
        notify();//разбудит случайный поток  notifyAll() будит все потоки в режиме ожидания
         }
}

class PutThread implements Runnable {
    BookStorage storage;

    public PutThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){

            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}


class GetThread implements Runnable{
    BookStorage storage;

    public GetThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){

            try {
                storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        
    }
}