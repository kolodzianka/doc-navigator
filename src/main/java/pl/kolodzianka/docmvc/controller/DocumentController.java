package pl.kolodzianka.docmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.service.DocumentService;


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
    public String saveDoc(@ModelAttribute("document") Document document, Model model) {
        documentService.create(document);
        model.addAttribute("documentList", documentService.findAll());
        return "listdoc";
    }





    @GetMapping("/listdoc")
    public String goToAddDoc(Model model){
        return "adddocument";
    }




}
