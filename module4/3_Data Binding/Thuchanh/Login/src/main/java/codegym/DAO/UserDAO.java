package codegym.DAO;

import codegym.models.Login;
import codegym.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        users.add(u1);

        User u2 = new User();
        u2.setAge(21);
        u2.setName("Mai Xuan Duy");
        u2.setAccount("duy");
        u2.setEmail("maiduybigbang@gmail.com");
        u2.setPassword("123456");
        users.add(u2);

    }

    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
