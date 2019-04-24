package multithreading.Pizza;

import java.util.concurrent.ArrayBlockingQueue;

//три потока:Клиент,Официант и повар
// три очереди , новые заказы,заказы для кухни и готовые
//Клиент делает заказ и добавляет в очередь 1
//Официант добавляет  заказ из 1 в очередь 2
//Повар передает из 2 в очередь 3
//Клиент забирает готовый заказ из очереди 3
public class Pizza {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> newOrders= new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<Order> forCook= new ArrayBlockingQueue<>(3,true);
        ArrayBlockingQueue<Order> done= new ArrayBlockingQueue<>(3,true);

        Order meat=new Order("meat");
        Order cheese= new Order("cheese");
        Order veg=new Order("veg");
        Order tomato= new Order("tomato");

        Waiter waiter1=new Waiter(newOrders,forCook);
        Waiter waiter2=new Waiter(newOrders,forCook);
        Waiter waiter3=new Waiter(newOrders,forCook);
        waiter1.start();
        waiter2.start();
        waiter3.start();

        Client client1=new Client(newOrders,done);
        Client client2=new Client(newOrders,done);
        Client client3=new Client(newOrders,done);


        client1.makeOrder(meat);
        client2.makeOrder(cheese);

        client1.start();
        client2.start();
        client3.start();

        client3.makeOrder(veg);
        client1.makeOrder(tomato);


        Cook cook1=new Cook(forCook,done);


        cook1.start();


    }

}

class Client extends Thread{
    private ArrayBlockingQueue<Order> newOrders;
    private ArrayBlockingQueue<Order> done;

    public Client(ArrayBlockingQueue<Order> newOrders, ArrayBlockingQueue<Order> done){
        this.newOrders=newOrders;
        this.done=done;
    }

    public void makeOrder(Order order){
        try {
            newOrders.put(order);
            System.out.println("Клиент сделал заказ: " + order.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Клиент получил готовый заказ"+ done.take().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}




class Waiter extends Thread{
    private ArrayBlockingQueue<Order> newOrders;
    private  ArrayBlockingQueue<Order> forCook;

    public Waiter(ArrayBlockingQueue<Order> newOrders, ArrayBlockingQueue<Order> forCook){
        this.newOrders=newOrders;
        this.forCook=forCook;
    }

    @Override
    public void run() {
        while (true){
            try{
            Order order=newOrders.take();
            System.out.println("Официант взял заказ: " + order.getName());
            forCook.put(order);
            System.out.println("Официант передал  заказ на кухню : " + order.getName());}
            catch (InterruptedException e){e.printStackTrace();}
        }
    }
}

class Cook extends Thread{

    private  ArrayBlockingQueue<Order> forCook;
    private ArrayBlockingQueue<Order> done;

    public Cook( ArrayBlockingQueue<Order> forCook,ArrayBlockingQueue<Order> done){

        this.forCook=forCook;
        this.done=done;
    }

    @Override
    public void run() {
        while (true){
            try{
                Order order=forCook.take();
                System.out.println("Повар взял заказ: " + order.getName());
                Thread.sleep(200);
                done.put(order);
                System.out.println("Повар приготовил заказ : " + order.getName());}
            catch (InterruptedException e){e.printStackTrace();}
        }
    }
}










class Order{
    String name;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
