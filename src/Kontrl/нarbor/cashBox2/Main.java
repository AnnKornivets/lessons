package Kontrl.нarbor.cashBox2;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Cashier> cashiers = new LinkedList<>();
        List<Customer> customers = new LinkedList<Customer>();

        for (int i = 0; i < 3; i++) {
            cashiers.add(new Cashier("Касса "+ i));
        }

        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("Клиента " + i, cashiers, 1 +  (int) (9 * Math.random())));
        }

        for (Customer customer : customers){
            customer.join();
        }

        System.out.println("Все клиенты обслужены");

    }
}