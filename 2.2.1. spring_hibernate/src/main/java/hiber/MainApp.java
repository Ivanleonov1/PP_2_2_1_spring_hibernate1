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

      Car car = new Car("Mersedes", 6);
      Car car1 = new Car("Lada", 99);
      Car car2 = new Car("Moskvich", 412);
      Car car4 = new Car("BMV", 7);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car1));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car2));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.stringCar());
         System.out.println();
      }

      User user = userService.getUserCar("Lada", "99");
      System.out.println("Id = " + user.getId());
      System.out.println("First Name = " + user.getFirstName());
      System.out.println("Last Name = " + user.getLastName());
      System.out.println("Email = " + user.getEmail());
      System.out.println("Car = " + user.stringCar());

      context.close();
   }
}
