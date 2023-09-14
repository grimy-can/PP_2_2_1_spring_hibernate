import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserTest {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private final UserService userService =  context.getBean(UserService.class);

    private final String testName = "Доминик";
    private final String testLastName = "Торетто";
    private final String testEmail = "fastandfurious@yandex.ru";
    private final String carModel = "Kalina";
    private final int carSeries = 1117;


    @Test
    public void saveUser() {
        try {


            User user = new User(null, testName, testLastName, testEmail, new Car(null, carModel, carSeries));
            userService.add(user);

            List<User> users = userService.getUserByCarModelAndSeries(carModel, 1117);
            User testUser = users.get(0);

            if (!testName.equals(testUser.getFirstName())
                || !testLastName.equals(testUser.getLastName())
                || !testEmail.equals(testUser.getEmail())
                || !carModel.equals(testUser.getCar().getModel())
                || carSeries != testUser.getCar().getSeries()
            ) {
                Assert.fail("User или Car были некорректно добавлены в базу данных");
            }

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }
}