package lambda;

import java.util.concurrent.ConcurrentSkipListMap;

public class LambdaStrategy {

    public static void main(String[] args) {
        Order order=new Order(500);
        order.payOrder("Card");

    }

}

class StrategyRegister<T>{
    public ConcurrentSkipListMap<String,T>map=new ConcurrentSkipListMap<>();
    public  void add(String actionName,T action ){
      //  map.putIfAbsent(actionName,action); // если они там
        map.put(actionName,action);


    }

    public T get(String actionName){
        return  this.map.get(actionName);
    }

    public void remove(String actionName){
        this.map.remove(actionName);

    }
}

class Order{

    private StrategyRegister<Runnable> payActions= new StrategyRegister<>();

    private int sum;

    public Order(int sum) {
        this.sum = sum;
        payActions.add("Card",()-> System.out.println("Оплата Card"+ sum));
        payActions.add("payPal",()-> System.out.println("Оплата  payPal "+ sum));

    }

    public   void payOrder(String payName){

        payActions.get(payName).run();

    }
}

enum PayActions{

    //всевозможные стратегии
    //конструктор
    //метод добавления в коллекцию payActions

}
