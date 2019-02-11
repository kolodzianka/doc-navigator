package pl.kolodzianka.docmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.UserService;


@Controller
public class UserController {

    @Autowired
    private final UserService userService = new UserService();

    @GetMapping("/login")
    public String loginModel(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/adduser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.create(user);
        return "login";
    }

    @GetMapping("/home")
    public String goToDocList(Model model){
        return "listdoc";
    }

    @PostMapping("/home")
    public String logOut(Model model){
        model.addAttribute("user", new User());
        return "home";
    }

}
