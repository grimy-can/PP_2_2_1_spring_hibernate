package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

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
