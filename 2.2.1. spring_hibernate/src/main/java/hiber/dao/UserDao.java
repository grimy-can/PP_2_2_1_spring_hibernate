package hiber.dao;

import hiber.model.User;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> getUsers();
   List<User> getUserByCarModel(String model);
   List<User> getUserByCarModelAndSeries(String model, int series);
}
