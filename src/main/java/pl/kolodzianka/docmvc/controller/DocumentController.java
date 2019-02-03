package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.service.DocumentService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DocumentController {


    @Autowired
    private final DocumentService documentService = new DocumentService();


    @GetMapping("/home")
    public String createDoc(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "home";
    }

    @GetMapping("/savedoc")
    public String saveDoc(@ModelAttribute("document") Document document) {
        documentService.create(document);
        return "listdoc";
    }

    @RequestMapping("/listdoc")
    public String documents (Model model){
        List<Document> documentList = new ArrayList<>();
        model.addAttribute(documentList);
        return "listdoc";
    }


}
