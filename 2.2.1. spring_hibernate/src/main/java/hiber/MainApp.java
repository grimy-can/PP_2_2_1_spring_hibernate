package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User(null,"User1", "Lastname1", "user1@mail.ru",
              new Car(null,"FORMULA", 1)));
      userService.add(new User(null,"User2", "Lastname2", "user2@mail.ru",
              new Car(null,"FORMULA", 2)));
      userService.add(new User(null,"User3", "Lastname3", "user3@mail.ru",
              new Car(null,"FORMULA", 3)));
      userService.add(new User(null,"User4", "Lastname4", "user4@mail.ru",
              new Car(null,"FORMULA", 4)));


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
