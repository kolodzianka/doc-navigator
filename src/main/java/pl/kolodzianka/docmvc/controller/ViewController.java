package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.UserService;

import javax.validation.Valid;

@Controller
public class ViewController {

    @Autowired
    private final UserService userService =new UserService();


    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @RequestMapping("/home")
    public String startPage() {
        return "home";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.create(user);
        model.addAttribute("users", userService.findAll());
        return "index";
    }


}
