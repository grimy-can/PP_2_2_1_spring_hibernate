package hiber.service;

import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    @Transactional(readOnly = true)
    List<User> getUserByCarModel(String model);

    @Transactional(readOnly = true)
    List<User> getUserByCarModelAndSeries(String model, int series);
}
