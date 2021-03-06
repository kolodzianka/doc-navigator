package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.security.SecurityService;
import pl.kolodzianka.docmvc.service.UserService;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class LoginController {

    private final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private UserService userService;


    @Autowired
    private SecurityService securityService;


    @GetMapping("/login")
    public String loginModel(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, Principal principal) {
        model.addAttribute("user", new User());

        LOG.log(Level.INFO,"Log success");
        return "home";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
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
        securityService.login(user.getUsername(),user.getPassword());
        return "login";
    }
}
