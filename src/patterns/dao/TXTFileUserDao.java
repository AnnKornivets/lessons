package patterns.dao;

import java.util.List;

public class TXTFileUserDao implements  UserDao {

    @Override
    public void addUser(User user) {
        System.out.println("ДОбавили пользователя " + user);
    }

    @Override
    public User getUserId(int id) {
        return null;
    }

    @Override
    public List<User> getALlUsers() {
        return null;
    }

    @Override
    public void updateUsers(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
