package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // нужно ли закрыть этот контекст? Почему нет метода для его закрытия?
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Alex", "Smith");
        User user2 = new User("Steve", "Jobs");
        User user3 = new User("Lui", "Fernandes");
        User user4 = new User("Catalina", "Brown");

        // userService.addUser(user1);
        // userService.addUser(user2);
        // userService.addUser(user3);
        // userService.addUser(user4);

        // userService.deleteUser(1);
        //  List<User> list = userService.getSomeUsers();
        //  for (User user : list) {
        //      System.out.println(user.getId() + " " + user.getName() + " " + user.getSurname());
        //  }

        userService.updateUser(2, "Hello", "World");

    }
}
