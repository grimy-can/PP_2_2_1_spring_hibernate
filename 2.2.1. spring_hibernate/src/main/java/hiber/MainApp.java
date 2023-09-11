package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User9", "Lastname9", "user9@mail.ru",
              new Car("FORMULA", 1)));
      userService.add(new User("User10", "Lastname10", "user10@mail.ru",
              new Car("FORMULA", 1)));
      userService.add(new User("User11", "Lastname11", "user11@mail.ru",
              new Car("FORMULA", 1)));
      userService.add(new User("User12", "Lastname12", "user12@mail.ru",
              new Car("FORMULA", 1)));

      List<User> users = userService.getUserByCarModelAndSeries("FORMULA", 1);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar().toString());
      }

      context.close();
   }
}
