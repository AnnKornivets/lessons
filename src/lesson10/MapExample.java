package lesson10;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        User user=new User("asd","231");
        User user1=new User("qwentin1","2332");
        User user2=new User("qwentin2","23243");
        User user3=new User("qwentin3","1325");
        User user4=new User( );
        HashMap<String, User> userHashMap=new HashMap<>(23); //тип данных ключей, тип данных значений//(23);
        userHashMap.put(user.getLogin(),user);  //добавить в map элемент
        userHashMap.put(user1.getLogin(),user1);
        userHashMap.put(user2.getLogin(),user2);
        userHashMap.put(user3.getLogin(),user3);
        userHashMap.put(null,user4);
        //        userHashMap.put("qwentin",new User("qwentin"));
        //
        //new Entry(asd,231)
        //Entry[] table [new Entry(asd,231)]

        System.out.println(userHashMap.get("asd"));

        userHashMap.keySet();
        userHashMap.values();
        //перебор
        for (Map.Entry entry: userHashMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());


        }

        //LinkedHashMap
        //EnumMap в качестве ключей хранит enum
        //нельзя использовать null в качестве ключа
        EnumMap<State,String> enumMap=new EnumMap<>(State.class);
        enumMap.put(State.ERROR,"ERROR");
        enumMap.put(State.START,"START");
        enumMap.put(State.STOP,"STOP");
        System.out.println(enumMap.get(State.ERROR));

        //сортировать по ключам
        TreeMap<Integer,String> treeMap= new TreeMap<>();
        treeMap.put(3,"3");
        treeMap.put(1,"1");
        treeMap.put(6,"6");
        treeMap.put(2,"2");
        System.out.println(treeMap);
        //сортируются только ключи


//        Object obj=new Object();
//        WeakReference weakReference=new WeakReference(obj);// может быть удален сборщиком мусора

        WeakHashMap<Object,String> weakHashMap=new WeakHashMap<>();
        HashMap<Object,String> hashMap=new HashMap<>();

        //ключи и значения
        Object hashkey=new Object();
        String hashValue="hashValue";

        Object weakKey=new Object();
        String weakValue="weakValue";

        hashMap.put(hashkey,hashValue);
        weakHashMap.put(weakKey,weakValue);

        System.out.println(hashMap+"hashmap");
        System.out.println(weakHashMap+"weakHashMap");

        hashkey=null;
        weakKey=null;

        System.gc();
        System.out.println(hashMap+"hashmap");
        System.out.println(weakHashMap+"weakHashMap");

         //ключи сравниваются с помощью операции==(не метода equals)
        IdentityHashMap<Integer,String> identityHashMap=new IdentityHashMap<>();
        HashMap<String, Integer> map=new HashMap<>();
       map.put("weq",23);
        map.put("weqqq",223);
        map.put("wezfq",234);
        map.put("wefsq",2233);
        map.put("weweq",2433);
        map.remove("weq");

//        for (Map.Entry<String,Integer>entry:map.entrySet()){
//            if(entry.getValue()<20){
//            map.remove(entery.getKey); }  ОШИБКА!!!!!!
//        }

        Iterator<Map.Entry<String, Integer>> iterator=map.entrySet().iterator();
        //удаление во время итерации
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry=iterator.next();
            String key =entry.getKey();
            int val=entry.getValue();
            if(val<20){
          iterator.remove();
            }


        }





    }


}
enum State{
    START,STOP,ERROR;
}

class User{
    private String login;
    private String pwd;

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    public User(){}

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
