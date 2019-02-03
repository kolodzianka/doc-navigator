package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.service.UserService;


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

    @GetMapping("/adduser")
    public String addUser() {
       return "adduser";
    }

    @GetMapping("/savedoc")
    public String saveDoc(Model model) {
        Document document = new Document();
        return "savedoc";
    }

    @GetMapping("/listdoc")
    public String listDocs() {
        return "listdoc";
    }


}
