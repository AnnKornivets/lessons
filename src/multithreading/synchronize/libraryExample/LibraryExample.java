package multithreading.synchronize.libraryExample;

import lesson8.Book;

import java.util.concurrent.ArrayBlockingQueue;

//Библиотека. Доступны для чтения несколько книг. Одинаковых книг в библиотеке нет.
//       Некоторые выдаются на руки, некоторые только в читальный зал.
//       Читатель (потоки) может брать на руки и в читальный зал несколько книг.
public class LibraryExample {
    public static void main(String[] args) {
        ArrayBlockingQueue<Books> newBooks= new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<Books> forHands= new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<Books> forreadingroom= new ArrayBlockingQueue<>(3,true);
        Books book1= new Books("Сказки");
        Books book2= new Books("Алфавит");
        Books book3= new Books("Данте");
        Books book4= new Books("Птицы");
        Books book5= new Books("Письма к невесте");
        Books book6= new Books("Мифы Древней Греции");
        Books book7= new Books("Серафим");
        Books book8= new Books("Зов Ктулху");
        Books book9= new Books("Путишествие Гуливера");
        Books book10= new Books("Все о сальмонеле");
        forHands.add(new Books("Традиции сезонов"));
        forHands.add(new Books("Традиции сезонов"));
        forHands.add(new Books("Традиции сезонов"));
    }

}

class Client extends Thread{
    ArrayBlockingQueue<Books> newBooks;
    ArrayBlockingQueue<Books> forHands;
    ArrayBlockingQueue<Books> forreadingroom;


    public Client(ArrayBlockingQueue<Books> newBooks, ArrayBlockingQueue<Books> forHands,ArrayBlockingQueue<Books> forreadingroom){
        this.newBooks=newBooks;
        this.forHands=forHands;
        this.forreadingroom=forreadingroom;
    }

    public void takeBook(Books books){
        try {
            newBooks.put(books);
            System.out.println("Читатель хочет забрать книгу  " + books.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Читатель взял книгу"+ forreadingroom.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Books{
    String name;

    public Books(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}