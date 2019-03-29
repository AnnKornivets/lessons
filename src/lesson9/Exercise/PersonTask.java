package lesson9.Exercise;


import java.util.*;
enum Company{
    PEPSI,LIPTON,BRAMOLT,UNILEVER,MORDOR,MALBORO,TRANS;

    public  static Company getCompany(int ord){

        for (Company mp:values()){
            if(ord==mp.ordinal()){
                return  mp;
            }
        }
        throw new AssertionError("wrong ordinary"+ord);
    }
}
enum Names{
    VLAD,LENA,KRIS,SLAVA,NIKA,BALDER,SARUMAN,LEGOLAS,QLAVDIY;
    public  static Names getNames(int ord){

        for (Names mp:values()){
            if(ord==mp.ordinal()){
                return  mp;
            }
        }
        throw new AssertionError("wrong ordinary"+ord);
    }
}

class Person implements Comparable<Person> {
    // написать генератор списка объектов класса Person
// Сортировать объекты Person по:
// имени
// имени и зарплaте
// имени, зарплaте, возрасту и компании
    Names name;
    int age;
    int salary;
   Company company;


    public Person(Names name, int age, int salary, Company company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public Names getName() {
        return name;
    }

    public void setName(Names name) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (getSalary() != person.getSalary()) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        return getCompany() != null ? getCompany().equals(person.getCompany()) : person.getCompany() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + getSalary();
        result = 31 * result + (getCompany() != null ? getCompany().hashCode() : 0);
        return result;
    }
}

public class PersonTask {
    public static void main(String[] args) {

        List<Person> personList = PersonGenerator.generate(7);

        for (Person person:personList){

            System.out.println(person.getName()+" " +person.getAge()+" "+person.getCompany()+" " +person.getSalary());
        }
        Comparator<Person> userComparator=new PersonNameComparator().thenComparing(new PersonAgeComparator().thenComparing(new PersonCompanyNameComparator().thenComparing(new PersonNameComparator())));
        TreeSet<Person> userTreeSet=new TreeSet<>(userComparator);

    }
}

class  PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class  PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
            return Integer.compare(o1.getAge(),o2.getAge());
        }
}

class  PersonSalaryComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getSalary(),o2.getSalary());
    }
}

class  PersonCompanyNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}

class PersonGenerator{

    public static List<Person> generate(int num){
        if (num<=0){ return Collections.emptyList(); }
        Random random = new Random();
        List<Person> messages=new ArrayList<>(num);

        //  values() - вернет массив констант
        int typesCount =Names.values().length;
        int typeCount=Company.values().length;
        for (int i=0;i<num;i++){
            messages.add(new Person(Names.getNames(random.nextInt(typesCount)),random.nextInt(100000),random.nextInt(80),
                    Company.getCompany(random.nextInt(typeCount))));
        }
        return messages;

    }
}