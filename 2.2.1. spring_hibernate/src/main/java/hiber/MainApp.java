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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      Car car1 = new Car("nothing", 0);
      Car car2 = new Car("Jiguli", 6);
      Car car3 = new Car("Alfa Rameo", 1);

      userService.add(new User("Artur", "Urusov", "urusovartur110@gmail.com", car1));
      userService.add(new User("Jorno", "Jovanna", "Jovanna@gmail.com", car2));
      userService.add(new User("Dio", "Brando", "DIO@gmail.com", car3));

      User user = userService.getUserByCar("Alfa Rameo",1);

      System.out.println();
      System.out.println("Id = "+user.getId());
      System.out.println("First Name = "+user.getFirstName());
      System.out.println("Last Name = "+user.getLastName());
      System.out.println("Email = "+user.getEmail());
      System.out.println();

      context.close();
   }
}
