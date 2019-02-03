package pl.kolodzianka.docmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.UserService;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private final UserService userService =new UserService();

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/adduser")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }



    @RequestMapping ("/home")
    public String checkUser(@ModelAttribute("user") User user){
        Optional<User> optionalUser = userService.findBuUserName(user.getUserName());
        if (optionalUser.isPresent()){
            return "home";
        }
        else {
//            redirectAttrs.addFlashAttribute("message", "UserName does't exist!");
            return "redirect:/login";
        }
    }
}
