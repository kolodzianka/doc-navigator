package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.service.DocumentService;
import pl.kolodzianka.docmvc.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/document")
public class DocumentController {


    @Autowired
    private final DocumentService documentService = new DocumentService();

    @Autowired
    private final UserService userService = new UserService();


    @GetMapping("/adddocument")
    public String createDoc(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "adddocument";
    }

    @PostMapping("/listdoc")
    public String addDoc (@ModelAttribute("document") Document document, Model model, Principal principal){
        User author = new User();
        author = userService.findByName(principal.getName());
        document.setAuthor(author);
        documentService.create(document);
        model.addAttribute("documentList", documentService.findAll());
        System.out.println(document);
        return "listdoc";
    }

    @GetMapping("/listdoc")
    public String saveDoc(Model model) {
        model.addAttribute("documentList", documentService.findAll());
        return "listdoc";
    }






}
