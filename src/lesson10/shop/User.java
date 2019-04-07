package lesson10.shop;

public class User {
    private String login;
    private String pwd;
   private double balance;
   private Cart cart;



   public void regCart(Cart cart){
       this.cart=cart;
   }

    public User(String login, String pwd, double balance) {
        this.login = login;
        this.pwd = pwd;
        this.balance = balance;
    }


    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (Double.compare(user.getBalance(), getBalance()) != 0) return false;
        if (getLogin() != null ? !getLogin().equals(user.getLogin()) : user.getLogin() != null) return false;
        return getPwd() != null ? getPwd().equals(user.getPwd()) : user.getPwd() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (getPwd() != null ? getPwd().hashCode() : 0);
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                ", cart=" + cart +
                '}';
    }
}
