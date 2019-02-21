package pl.kolodzianka.docmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.UserService;


@Controller
public class UserController {

    @Autowired
    private final UserService userService = new UserService();

    @GetMapping("/home")
    public String goToDocList(Model model){
        return "listdoc";
    }

    @PostMapping("/home")
    public String logOut(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "Welcome "
                + context.getAuthentication().getName());

        return "home";
    }

}
