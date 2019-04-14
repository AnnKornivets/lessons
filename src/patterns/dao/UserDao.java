package patterns.dao;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUserId(int id);
    List<User> getALlUsers();
    void updateUsers(User user);
    void  deleteUser(User user);
}
