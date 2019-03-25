package pl.kolodzianka.docmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kolodzianka.docmvc.service.UserService;


@Controller
public class UserController {

    @Autowired
    private final UserService userService = new UserService();

    @GetMapping("/home")
    public String goToDocList(Model model){
        return "listdoc";
    }



}
