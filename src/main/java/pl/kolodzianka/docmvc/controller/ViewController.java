package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.UserService;


@Controller
public class ViewController {

    @Autowired
    private final UserService userService =new UserService();


    @GetMapping("/")
    public String homePage() {
        return "home";
    }


    @GetMapping("/adduser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
       return "adduser";
    }

    @GetMapping("/home")
    public String saveDoc(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "home";
    }

    @GetMapping("/listdoc")
    public String listDocs() {
        return "listdoc";
    }


}
