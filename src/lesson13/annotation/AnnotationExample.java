package lesson13.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationExample {
    String name;

    @Override
    @MethodInfo(date="12.02.2019", author = "user",version=2) // если есть по умолчанию то можно не писать, в данном случае version
    public String toString() {
        return "AnnotationExample{" +
                "name='" + name + '\'' +
                '}';
    }
    @Deprecated//отмечает метод как устаревший
    @MethodInfo(date="12.12.2019", author = "user1")
    public void SomeVoid(){
        System.out.println("Deprecated void");
    }

    public static void main(String[] args) {
        //как получить анотации
        AnnotationExample example=new AnnotationExample();
        //для метода
        Method[] methods=example.getClass().getDeclaredMethods();
        for (Method method:methods){
            Annotation[] annotations=method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));
            method.isAnnotationPresent(MethodInfo.class); // есть такая анотация
//            MethodInfo methodInfo=method.getDeclaredAnnotations(MethodInfo.class);
//            System.out.println(methodInfo);
//            if(methodInfo!=null){
//                System.out.println(methodInfo.author());
//                System.out.println(methodInfo.date());
//                System.out.println(methodInfo.version());
//            }

        }
    }
}
