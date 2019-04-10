package lesson13;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
    //Рефлекусия в Java

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,NoSuchMethodException,InstantiationException {
        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getClass());

        Class cls =someClass.getClass();
        System.out.println(cls.getName());


        cls = cls.getSuperclass();
        System.out.println(cls.getName());
        //доступ к компонентам класса

        Class <SomeClass> someCls= SomeClass.class;
        //доступ к полям класса
        Field[] fields=someCls.getFields();  //возвращает все публичные поля , свои и родителя
        System.out.println(Arrays.toString(fields));

        Field[] declaredField=someCls.getDeclaredFields();
        System.out.println(Arrays.toString(declaredField));

        //доступ к методам

        Method[] methods=someCls.getMethods();
        System.out.println(Arrays.toString(methods));

        Method[] declaredmeyhods = someCls.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredmeyhods)); //только методы класса, но и публичные, и приватные

        //доступ к конструкторам

        Constructor<?>[] declaredConstructors=someCls.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));


        // доступ к конкретному полю, методу,конструктору

        Field field=someCls.getDeclaredField("version");
        System.out.println(field.getType());
        field.setAccessible(true);

        field.set(someClass,1);//задает значение поля

        System.out.println(someClass);
        //доступ к приватному методу
//       Method method = someCls.getDeclaredMethods("getInfo");
//       method.setAccessible(true);
//       String data=(String) method.invoke(someClass);
//        System.out.println("data: " + data);

        // конструктор
        Constructor<SomeClass> someClassConstructor=someCls.getDeclaredConstructor(String.class,int.class);
        SomeClass someClass1=someClassConstructor.newInstance("SomeClass",3);
        System.out.println(someClass1);

        //
        boolean isPrivate= Modifier.isPrivate(field.getModifiers());
        boolean isFinal = Modifier.isFinal(field.getModifiers());
        //написать статический toString(obj), который возвращвет информацию о переданном объекте
    }
}

class ParentClass{
    public  String parentField;
   private void parentVoid(){
        System.out.println("Parent void");
    }
}
class SomeClass extends  ParentClass{
  private  String name;
  public int version;

   private  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

// private void setVersion(int version) {
//        this.version = version;
//    }

    private String getInfo(){
       return "privat void";
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }


}