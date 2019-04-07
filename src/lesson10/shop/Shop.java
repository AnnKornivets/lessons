package lesson10.shop;

import java.util.HashMap;

public class Shop {

    static HashMap<String,User> users=new HashMap<>();
   static HashMap<String,Good> storage=new HashMap<>();

   public boolean doTransaction(User user){
       double price=user.getCart().getSumm();
       if(user.getBalance()<price){

           return false;
       }

//оплата
       user.setBalance(user.getBalance()-price);
       return true;
    }





    public static void main(String[] args) {

        User user1=new User("QWE","1343",5446768);
        User user2=new User("QqwWE","197642",545438);
        User user3=new User("QWrfdxE","1343",5446768);
        User user4=new User("tyQWewE","1334543",54768);
        User user5=new User("sfeQWE","122233",5446368);

        Good car=new Good("car",2000);
        Good phone=new Good("phone",1500);
        Good book=new Good("book",500);

        users.put(user1.getLogin(),user1);
        users.put(user2.getLogin(),user2);
        users.put(user3.getLogin(),user3);
        users.put(user4.getLogin(),user4);
        users.put(user5.getLogin(),user5);


        storage.put(car.getTitle(),car);
        storage.put(phone.getTitle(),phone);
        storage.put(book.getTitle(),book);

//        Cart cart=new Cart();
//        user1.addGood(car);
//        user1.addGood(phone);
//        user1.regCart(cart);


    }
}
