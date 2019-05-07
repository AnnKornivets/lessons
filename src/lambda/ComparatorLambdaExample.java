package lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        Manager alex=new Manager("Alex",23,"Tradition");
        Manager peter=new Manager("Peter",28,"OOO Sadr");
        Manager tom=new Manager("Tom",27,"OAO REd");
        Manager mike=new Manager("Mike",29,"OOO Soopm");

        ArrayList<Manager> managers= new ArrayList<>();
        managers.add(alex);
        managers.add(peter);
        managers.add(tom);
        managers.add(mike);

        Comparator<Manager> byName=(manager1, manager2)->manager1.getName().compareTo(manager2.getName());
        Comparator<Manager> byNAme2=Comparator.comparing(Manager::getName);
        managers.sort(byNAme2);
        System.out.println(managers);

        Comparator<Manager> byAge=Comparator.comparing(Manager::getAge);
        System.out.println(managers);

        Comparator<Manager> byCompany=Comparator.comparing(Manager::getCompany);
        System.out.println(managers);


    }
}


class Manager{
   private String name;
   private int age;
   private String company;

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
