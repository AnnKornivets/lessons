package Kontrl.нarbor.cashBox2;

import java.util.LinkedList;


public class Cashier extends Thread {

    volatile private LinkedList<Customer> customerQueue = new LinkedList<>();

    public Cashier(String name) {
        super(name);
        this.setDaemon(true);
        start();
    }


    public LinkedList<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public synchronized void enqueueCustomer(Customer customer){
        customerQueue.addLast(customer);
        notifyAll();
    }
    public synchronized void dequeueCustomer(Customer customer){
        customerQueue.remove(customer);
        notifyAll();
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (customerQueue.size() == 0) {
                        wait();
                    }
                }
                Customer currentCustomer;
                synchronized ( currentCustomer = customerQueue.peek()) {
                    System.out.println(this + " обслуживает  " + currentCustomer);
                    Thread.sleep(445 * currentCustomer.getTask());
                    currentCustomer.setServed(true);
                    currentCustomer.notifyAll();
                }

                synchronized (this) {
                    customerQueue.poll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}