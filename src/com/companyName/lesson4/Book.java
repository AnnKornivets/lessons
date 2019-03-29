package com.companyName.lesson4;
/*Создание класса книга*/
/*import */
/*объект без класса не создать,в классе определяются св-ва какими будет обладать объект и также есть методы */
public class Book {
    //свойства(атрибуты, поля)
   private int pageCount; //у всех объектов будет это свойство //к имени класса можем обращатся
   private String title;
   private Author author; // добавим автора

    public Book() {} //конструктор по умолчанию, используетя для инициализации объектов (объязательно,если есть другие конструкторы)
    public Book(int pageCount){ //конструктор с одним свойством
        this.pageCount = pageCount;
        //любой доступный код
    }
    public Book(int pageCount, String title){ //конструктор с 2 свойствами
        this.pageCount = pageCount;
        this.title=title;
    }
    public Book(Author author){ //конструктор автор
        this.author=author;
    }



    public int getPageCount() { //Getter //дает значение в sout
        return pageCount;
    }

    public String getTitle() {
        return title; // возращает значение
    }

    public void setPageCount(int pageCount) {
        //проверка входящих данных
        if (pageCount<1){
            System.out.println("Ошибка в количестве страниц");
            return; // прерывает работу метода
        }
        this.pageCount = pageCount;  //Setter //устанавливает
    }

    public void setTitle(String title) { //Setter можем в метод передать значения
        this.title = title; //this-ссылка на текущий объект
    }



    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


//информация в Book
    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
