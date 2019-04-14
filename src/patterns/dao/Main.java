package patterns.dao;

public class Main {
    public static void main(String[] args) {
        User user=new User(24322,"qwer",45);
        UserDao userDao= new TXTFileUserDao();
        userDao.addUser(user);
    }
}
