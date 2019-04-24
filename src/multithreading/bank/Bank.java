package multithreading.bank;

public class Bank {
    public void TransferMoney(Account src,Account dst,int money){
        Thread transaction=new Thread(new Transaction(src, dst, money));
        transaction.start();
    }
}
