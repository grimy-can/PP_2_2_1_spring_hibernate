package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getUsers() {
      return userDao.getUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getUserByCarModel(String model) {
      return userDao.getUserByCarModel(model);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getUserByCarModelAndSeries(String model, int series) {
      return userDao.getUserByCarModelAndSeries(model, series);
   }

}
