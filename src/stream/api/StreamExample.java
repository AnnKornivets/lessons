package stream.api;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {


        Stream<Integer> integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        integerStream.filter(num -> num < 0)
                .map(num -> num * 100)
                .limit(1) //вернет первые элементы
                .forEach(System.out::println); //промежуточные методы

        integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        integerStream
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //anyMatch | noneMatch | allMatch

        integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        System.out.format("anyMatch: %b \n",integerStream.anyMatch(num->num==0));//true

        integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        System.out.format("noneMatch: %b \n",integerStream.noneMatch(num->num>1000));//true все не удовлетворяют условию

        integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        System.out.format("allMatch: %b \n",integerStream.allMatch(num->num>0));//false


        integerStream = Stream.of(3, 6, 56, 56, -23, -5, 0, 78);
        integerStream.filter(num->num>0)
                .map(num-> num +"$")
        .forEach(System.out::println);

        String[] strings={"a56","bb","ccc56","dd","f56"};
        System.out.format("Первый элемент: %s \n", Arrays.stream(strings).findFirst().orElse("Коллекция пуста"));
        System.out.format("The last element: %s \n",Arrays.stream(strings)
                .skip(strings.length-1)
                .findAny()
                .orElse("Коллекция пуста")); //skip пропускает первые n элементов
        System.out.format("Элемент bb: %s \n",Arrays.stream(strings).filter("bb"::equals).findFirst().get());
        System.out.format("Элементы, содержащие 56: %s \n",Arrays.stream(strings)
                .filter(s->s.contains("56")).collect(Collectors.toList()));

        ArrayList<User> users=new ArrayList<>();
        users.add(new User("qwe",45));
        users.add(new User("rwtqwe",35));
        users.add(new User("qwerw",41));
        users.add(new User("qwe",26));
        users.add(new User("qwewefwe",14));

        //массив пользователей старше 30

        User[] usersArr =users.stream()
                .filter(user->user.getAge()>30).toArray(User[]::new);
        System.out.println(Arrays.toString(usersArr));
        //c помощью стрима сохранить инфу в лист
        List<User> userList=users.stream().peek(user->user.setActive(true)).collect(Collectors.toList());
        System.out.println(userList);
     users.stream()
             .distinct()
             .forEach(System.out::println);

     users.stream()
             .sorted(Comparator.comparing(User::getAge))
             .forEach(System.out::println);

        System.out.println(users.stream().min(Comparator.comparing(User::getAge)).get());
        System.out.println(users.stream().max(Comparator.comparing(User::getAge)).get());

//Collectors

 strings= new String[]{"a56","bb","ccc56","dd","f56"}; // анонимный массив
        List<String> stringList=Arrays.stream(strings).collect(Collectors.toList());
       Set<String> stringSet=Arrays.stream(strings).collect(Collectors.toSet());
       ArrayList<String> stringArrayList=Arrays.stream(strings).collect(Collectors.toCollection(ArrayList::new));
//to map
Map<String,Integer> integerMap= Arrays.stream(strings)
        .collect(Collectors.toMap(Function.identity(),String::length,((item,item1)->item)));
        System.out.println(integerMap);

        String string= Arrays.stream(strings)
                .collect(Collectors.joining(" : ", " Before: ", " End "));
        System.out.println(string);


    }
}

class User{
    private String login;
    private int age;
    private boolean active;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (isActive() != user.isActive()) return false;
        return getLogin() != null ? getLogin().equals(user.getLogin()) : user.getLogin() == null;

    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (isActive() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}
