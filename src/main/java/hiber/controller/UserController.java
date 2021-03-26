package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    // почему не ищет бин в другом пакете?(веб и хибер - разные)
    private UserService userService;

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("usersList", userService.getSomeUsers());
        return "list";
    }

    @GetMapping("/addUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
       // userService.addUser(new User(name, surname)); // ручной способ, ужно добавить реквестпарамы в сигнатуру
        userService.addUser(user);
        return "addUser";
    }


   @GetMapping("/{id}")
   public String takeUserForUpdateOrDelete(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
       User u = (User)model.getAttribute("user");
       System.out.println(u.getName());
        return "updateUser";
   }

   @PatchMapping("/{id}")
   public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user.getName(), user.getSurname());
        return "redirect:/list";
   }

    @DeleteMapping("/deleteUser/")
    public String deleteUser(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "deleteUser";
    }

}
