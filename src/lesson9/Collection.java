package lesson9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Collection {
    public static void main(String[] args) throws IOException {
        //порядок элеметов сохраняется
        ArrayList<Book> bookArrayList=new ArrayList<>();//изначально память выделяется на 10 элементов
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Cars"));
        bookArrayList.add(2,new Book("Alfabet")); //на второе место
        System.out.println(bookArrayList.size()); // количество элементов

      for (Book book: bookArrayList){

          System.out.println(book.getTitle());
      }

      //LinkedHashSet

        Set<Book> bookSet=new HashSet<>(bookArrayList);//элементы хранятся не в порядке добавления//содаем коллекцию на основе другой коллекции
        System.out.println("bookSet");

        for (Book book: bookSet){

            System.out.println(book.getTitle());
        }

        LinkedList<Book> bookLinkedList=new LinkedList<>();
        bookLinkedList.add(new Book("Far cry"));
        bookLinkedList.add(new Book("Far cry 2"));
        bookLinkedList.add(new Book("Far cry 3"));

        for (Book book: bookLinkedList){

            System.out.println(book.getTitle());
        }

        TreeSet<String> strings= new TreeSet<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("Bye");

        for (String str:strings){
            System.out.println(str);
        }

        TreeSet<Book> bookTreeSet=new TreeSet<>();
        bookTreeSet.add(new Book("TRun"));
        bookTreeSet.add(new Book("Solaris"));
        System.out.println(bookTreeSet);



        User user1=new User("asw",34);
        User user2=new User("qwe",57);

        TreeSet<User> users = new TreeSet<>(new UserComparator());
        users.add(user1);
        users.add(user2);
        for (User user:users){

            System.out.println(user.getName());
        }
        Comparator<User> userComparator=new UserNameComparator().thenComparing(new UserAgeComparator());
        TreeSet<User> userTreeSet=new TreeSet<>(userComparator);

        userTreeSet.add(new User("Rtyu",78));
        userTreeSet.add(new User("Rtyu",98));
        userTreeSet.add(new User("Somtyu",18));
        userTreeSet.add(new User("Drak",78));

for (User user:userTreeSet){
    System.out.println(user.getName()+" "+user.getAge());
}


ClassLoader loader=Collection.class.getClassLoader();
File file =new File(loader.getResource("file").getFile());

//Читаем строки из файла
         List<String> lines= Files.readAllLines(file.toPath());
         //слова
List<String> words =new ArrayList<>();

for (String line:lines){
    String[] wordSplit = line.toLowerCase()//приведение к нижнему регистру
    .replaceAll("\\p{Punct}"," ")//знаки препинания на пробел
    .trim()// убираем пробелы с двух сторон
    .split("\\s");

    for (String s:wordSplit){
        if(s.length()>0) {
            words.add(s.trim());
        }
    }
}

for(String word:words){
    System.out.println(word);
}

    }
}
//для хранения объектов в TreeSet класс должен расширять интерфейс
class Book implements Comparable<Book>{

    String title;



    public Book(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null;
    }

    @Override
    public int hashCode() {
        return getTitle() != null ? getTitle().hashCode() : 0;
    }
    //0-объекты равны
    //отрицательное значение - объект будет стоять до Object 0
    //положительное значение - объект будет стоять после Object 0
    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }
}



class User{
   private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        return getName() != null ? getName().equals(user.getName()) : user.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

}

class  UserComparator implements Comparator<User>{


    //сравнение объектов
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserNameComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserAgeComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}



//ДЗ
//UserGenerator метод Generat
//сортируем
//по имени,возрасту,компании и зарплате
class Person{
    String name;
    int age;
    int salary;
    String company;

    public Person(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }


}

