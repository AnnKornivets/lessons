package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<User> users= new ArrayList<>();
        User user1 = new User("qwe",36,"Russia");
        User user2 = new User("erte",26,"German");
        User user3 = new User("ervhgte",41,"China");
        User user4 = new User("eewrete",15,"German");
        User user5 = new User("evbnrte",30,"Canada");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Listeners listeners=new Listeners(users);
        System.out.println(listeners.getMoreThen45());
        List<User> russianUsers=listeners.getFilterUsers(user -> "Russian".equals(user.getCountry()));
        System.out.println(russianUsers);
        Predicate<User> russianFilter = user -> "Russian".equals(user.getCountry());
        Predicate<User> ageAfter45 = user -> user.getAge()>45;
        Predicate<User> canadaFilter = user -> "Canada".equals(user.getCountry());

        System.out.println(listeners.getFilterUsers(canadaFilter.or(russianFilter)));





    }

}



class Listeners{
  private List<User> userList;

    public Listeners(List<User> userList) {
        this.userList = userList;
    }
    public List<User> getRussianUsers(){
        List<User> list= new ArrayList<>();
        for(User user:userList){
            if ("Russian".equals(user.getCountry())){
                list.add(user);
            }

        }
        return list;
    }


public  List<User> getMoreThen45(){
    List<User> list= new ArrayList<>();
    for(User user:userList){
        if (user.getAge()>45){
            list.add(user);
        }

    }
    return list;
}
    public  List<User> getFromCanada45(){
        List<User> list= new ArrayList<>();
        for(User user:userList){
            if ("Canada".equals(user.getCountry()) && user.getAge()>45){
                list.add(user);
            }

        }
        return list;
    }

    //с использованием predicate
    public List<User> getFilterUsers(Predicate<User> filter){
        List<User> list= new ArrayList<>();
        for (User user:userList){
            if (filter.test(user)){
                list.add(user);

            }
        }
        return list;
    }

}




class User{
    private String login;
    private int age;
    private String country;

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        return getCountry() != null ? getCountry().equals(user.getCountry()) : user.getCountry() == null;

    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }


}
