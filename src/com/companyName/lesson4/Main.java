package com.companyName.lesson4;

public class Main {
    public static void main(String[] args) {
        //При создании объекта мы описываем тип данных , имя объекта = new создание объекта(вызов конструктора)

        Book book1 = new Book(); //в переменной находится ссылка на объект, все пользовательские объекты создаются в куче
        System.out.println(book1);
        //задаем свойства объекту
//      book1.pageCount = 34; //обратились к свойству объекта
//      book1.title="Азбука";
        book1.setPageCount(34);
        book1.setTitle("Азбука");


        System.out.println(book1);

        Book book2 = new Book();
//       book2.pageCount=122;
//       book2.title="Сказки";
        book2.setPageCount(122);
        book2.setTitle("Сказки");

        System.out.println(book2);

        Book book3=new Book(89); //конструктор №2
        System.out.println(book3);
        Book book4=new Book(223,"Словарь"); //конструктор №3
        System.out.println(book4);

        int book4PageCount=book4.getPageCount();

        System.out.println("book4PageCount = " +book4.getPageCount());


        Author author=new Author("Чарльз","Дикенсон"); //новый автор

        book4.setAuthor(author);

        System.out.println(book4);

        Library library = new Library(); // конструктор по умолчанию

        Character.isDigit(5); // проверка на цифры





    }
}
