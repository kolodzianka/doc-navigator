package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.service.DocumentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
public class DocumentController {


    @Autowired
    private final DocumentService documentService = new DocumentService();


    @GetMapping("/adddocument")
    public String createDoc(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "adddocument";
    }

    @GetMapping("/savedoc")
    public String saveDoc(@ModelAttribute("document") Document document) {
        documentService.create(document);
        return "listdoc";
    }

    @RequestMapping("/listdoc")
    public String documents (Model model){
        Set<Document> documentList;
        documentList = documentService.findAll();
        model.addAllAttributes(documentList);
        return "listdoc";
    }

    @GetMapping("/listdoc")
    public String save(@ModelAttribute Set<Document> document){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("documentList");
        document = documentService.findAll();
        modelAndView.addObject("documentList", document);
        return "listdoc";
    }

    @GetMapping("/listdoc")
    public String goToAddDoc(Model model){
        return "adddocument";
    }




}
