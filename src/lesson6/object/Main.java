package lesson6.object;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object object =new Object();
        Author author=new Author("Author");


        Message message=new Message();
        message.setAuthor(author);
        message.setMessageText("message text");

        //строковое представление объекта
        System.out.println(message.toString());

        //hashCode() - возращает хэш код объекта, будет переменная int, исходный адрес объекта памяти в 16-ричной системе счисления
        System.out.println(message.hashCode());
        System.out.println(author.hashCode());

        Message message1=new Message();
        message1.setAuthor(author);
        message1.setMessageText("message text");

        Message message2=new Message();
        message2.setAuthor(author);
        message2.setMessageText("message text");

        System.out.println(message1.equals(message2)); //false
        System.out.println(message2.hashCode());
        System.out.println(message1.hashCode());
        System.out.println(message1.getClass());


        //метод clone() позволяет создать копию объекта

        Message message3=(Message) message1.clone();

    }


}
