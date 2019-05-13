package Kontrl.нarbor.cashBox2;

import java.util.LinkedList;
import java.util.List;

public class Customer extends Thread {

    volatile List<Cashier> cashiers; //Результат операции записи значения в volatile переменную одним потоком, становится виден всем другим потокам, которые используют эту переменную для чтения из нее значения.
    int task;
    Cashier currentCashier;
    volatile boolean isServed;


    public Customer(String name, List<Cashier> cashiers, int task) {
        super(name);
        this.cashiers = cashiers;
        this.task = task;
        isServed = false;
        start();
    }

    public int getTask() {
        return task;
    }

    public Cashier getCurrentCashier() {
        return currentCashier;
    }

    public void setServed(boolean isServed) {
        this.isServed = isServed;
    }

    @Override
    public void run() {
        int shortestQueueId = findShortestQueue(0);
        currentCashier = cashiers.get(shortestQueueId);
        currentCashier.enqueueCustomer(this);

        while (!isServed){
            if (this != currentCashier.getCustomerQueue().peek()) {
                Cashier oldCashier = null;
                synchronized (this) {
                    Cashier bufferCashier = findFreeQueue();
                    if (bufferCashier != null) {
                        oldCashier = currentCashier;
                        currentCashier = bufferCashier;
                    }
                }
                if (oldCashier != null) {
                    oldCashier.dequeueCustomer(this);
                    currentCashier.enqueueCustomer(this);
                }
            }
        }
        System.out.println(getTask()+ " задачи  " + Thread.currentThread().getName() + " обслужены  " + currentCashier);
    }

    private int findShortestQueue(int shortestQueueId) {
        int shortestQueueLength = Integer.MAX_VALUE;
        for (int i = 0; i < cashiers.size(); i++) {
            int currentQueueLength = cashiers.get(i).getCustomerQueue().size();
            if (currentQueueLength == 0) {
                shortestQueueId = i;
                shortestQueueLength = 0;
                break;
            } else {
                if (currentQueueLength < shortestQueueLength) {
                    shortestQueueId = i;
                    shortestQueueLength = currentQueueLength;
                }
            }
        }
        return shortestQueueId;
    }
    private Cashier findFreeQueue () {
        Cashier freeCashier = currentCashier;
        for (int i = 0; i < cashiers.size(); i++) {
            int currentQueueLength = cashiers.get(i).getCustomerQueue().size();
            if (currentQueueLength == 0) {
                return freeCashier = cashiers.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}