package stream.api;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {
        Author mike=new Author("mike",23);
        Author peter=new Author("peter",62);
        Author alice=new Author("alice",24);
        Author tom=new Author("tom",14);
        Author jane=new Author("jane",36);

        Article article1=new Article("java12",tom,Article.Category.JAVA);
        Article article2=new Article("parsing i python",tom,Article.Category.PYTHON);
        Article article3=new Article("php and world",mike,Article.Category.PHP);
        Article article4=new Article("java12",alice,Article.Category.JAVA);
        Article article5=new Article("parsing i python",alice,Article.Category.PYTHON);
        Article article6=new Article("php tne best",peter,Article.Category.PHP);
        Article article7=new Article("triumph java12",tom,Article.Category.JAVA);
        Article article8=new Article("parsing i python",jane,Article.Category.PYTHON);
        Article article9=new Article("php",jane,Article.Category.PHP);

        ArrayList<Article> articles=new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);

//сгрупировать
        articles.stream()
                .collect(Collectors.groupingBy(a->a.getAuthor().getName()))
                .entrySet()
        .forEach(System.out::println);
        //вывести имена авторов по алфавиту
        articles.stream()
                .map(a->a.getAuthor().getName())
        .distinct()
        .sorted()
        .forEach(System.out::println);

        //количество статей по каждому автору
        articles.stream()
                .collect(Collectors.groupingBy(a->a.getAuthor().getName(), Collectors.counting()))
                .forEach((a,count)-> System.out.println(a+ " : " + count));


        Map<Article.Category, Map<String, List<Article>>> map =articles.stream()
                .sorted(Comparator.comparing(Article::getCategory, Comparator.comparing(Enum::name)).thenComparing(a->a.getAuthor().getName()))
                .collect(Collectors.groupingBy(Article::getCategory,LinkedHashMap::new,Collectors.groupingBy(a->a.getAuthor().getName())));
        System.out.println(map);


        ArrayList<Author> authors= new ArrayList<>();
        authors.add(tom);
        authors.add(mike);
        authors.add(alice);
        authors.add(peter);
        authors.add(jane);

        IntSummaryStatistics statistics= authors.stream() //объект для сбора статистики
        .collect(Collectors.summarizingInt(Author::getAge));
        System.out.println(statistics);

        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());

        //

        ArrayList<Developer> developers=new ArrayList<>();
        //группировка по должности pos
        Map<String,List<Developer>> posMap= developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos));

        //количество
       Map<String,Long> posCount=developers.stream()
               .collect(Collectors.groupingBy(Developer::getPos,Collectors.counting()));
       //групировка имен по должности
        Map<String,Set<String>> posName= developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos, Collectors.mapping(Developer::getName, Collectors.toSet())));
        //средняя зарплата по должности
        Map<String,Double> posAvergeSalary= developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.averagingDouble(Developer::getSalary)));

        //
        Map<String,Map<Integer, List<Developer>>> posAndAge= developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.groupingBy(Developer::getAge)));



    }

}

class Author{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author(String name, int age) {
        this.name = name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        return getName() != null ? getName().equals(author.getName()) : author.getName() == null;

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Article{
    enum Category{
        JAVA, PHP, PYTHON;
    }
    private String title;
    private Author author;
    private Category category;

    public Article(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (author != null ? !author.equals(article.author) : article.author != null) return false;
        return category != null ? category.equals(article.category) : article.category == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}


class Developer{
    private String name;
    private int age;
    private int salary;
    private  String pos;

    public Developer(String name, int age, int salary, String pos) {

        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pos='" + pos + '\'' +
                '}';
    }
}