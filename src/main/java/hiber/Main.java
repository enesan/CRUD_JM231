package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("Alex", "Smith"));
        userService.addUser(new User("Steve", "Jobs"));
        userService.addUser(new User("Lui", "Fernandes"));
        userService.addUser(new User("Catalina", "Brown"));
    }
}
