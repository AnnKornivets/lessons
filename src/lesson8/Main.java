package lesson8;

public class Main {
    public static <ChildBook> void main(String[] args) {
        Book tails=new Book("tails",60);
        Book flowers=new Book("flowers",56);

        Car car =new Car("red");

//        LinkedList bookStorage = new LinkedList();
//        bookStorage.add(tails);
//        bookStorage.add(flowers);
//        bookStorage.add(car);
//
//        Book bookFromStorage=(Book) bookStorage.get(0); //используем приведние типов
//        System.out.println(bookFromStorage.getTitle());
//
//
//        Book bookFromStorage2=(Book) bookStorage.get(2); // попала машина //ошибка //ClassCastException
//        System.out.println(bookFromStorage2.getTitle());

        LinkedList<Book> bookStorage =new LinkedList<Book>(); //вместо T указываем тип
        bookStorage.add(tails);
        bookStorage.add(flowers);
//      bookStorage.add(car); выдается ошибка

        LinkedList<Car> carsStorage =new LinkedList<Car>();

        carsStorage.add(car);

        Book bookFromStorage= bookStorage.get(0);

      System.out.println(bookFromStorage.getTitle());
        Car carFromStorage= carsStorage.get(1);

        System.out.println(carFromStorage.Color);



      LinkedList<Book.ChildBooks> childBookStorage=new LinkedList<>();
       Book.ChildBooks coloring=new Book.ChildBooks("coloring" ,23);
      childBookStorage.add(coloring);
       Book book=getFirstBook(childBookStorage);


    }
    //со всеми потомками

    public static Book getFirstBook(LinkedList<? extends Book> storage){
//        ChildBook book = new ChildBook("book",57);
//        storage.add(book);

        return  storage.get(0);
    }
    //класс Book и все его предки
    public void addtoStorage(LinkedList<? super Book> storage){

        Book book=new Book("sss",45);
        storage.add(book); //добавляет книгу в хранилище
//        Book book1=storage.get(0); но вернуть не можем
        Object o= storage.get(0);
        System.out.println(0);
    }
    //пеерегрузка мутоды generic нельзя  (одинаковые по сигнатуре)
//    public void SomeVoid(LinkedList<String> storage){}
//    public void SomeVoid(LinkedList<Integer storage){}

    //в статике не используем
//    public static T staticVoid(){}

    public  static  void storage(LinkedList<?> storage){
        Book book =new Book("vhj",567);
//        storage.add(book); нельзя добавить так как тип данных неопределен
        storage.add(null);

//        Book book1=storage.get(0); // вернуть не может
        Object o =storage.get(0);
    }





}
