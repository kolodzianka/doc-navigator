package pl.kolodzianka.docmvc.controller;


import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.service.DocumentService;
import pl.kolodzianka.docmvc.service.UserService;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("/document")
public class DocumentController {

    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private  DocumentService documentService;

    @Autowired
    private UserService userService;

    private SessionFactory hibernateFactory;

    @Autowired
    public void SomeService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }


    @GetMapping("/adddocument")
    public String createDoc(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);
        return "adddocument";
    }

    @PostMapping("/adddocument")
    public String addDoc(@RequestParam("pdf") MultipartFile file, RedirectAttributes redirectAttributes,
                         @ModelAttribute Document document, Model model, BindingResult bindingResult) throws IOException {
        Date date = new Date();
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }


        //Blob blob = Hibernate.getLobCreator(hibernateFactory.getCurrentSession()).createBlob(file.getBytes());

        byte[] bytes = file.getBytes();

        document.setCreatedDate(date);
        document.setPdfFile(bytes);
        document.setName(file.getOriginalFilename());
        documentService.create(document);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");


        model.addAttribute("documentList", documentService.findAll());
        LOG.info("Add document " + document.getName());
        return "document/listdoc";
    }

    @PostMapping("/listdoc")
    public String addDoce (@ModelAttribute("document") Document document, Model model){
//        User author = new User();
//        author = userService.findByName();
//        document.setAuthor(author);
        documentService.create(document);
        model.addAttribute("documentList", documentService.findAll());
        LOG.info("Add document " + document.getName());
        return "document/listdoc";
    }

    @GetMapping("/listdoc")
    public String saveDoc(Model model) {
        model.addAttribute("documentList", documentService.findAll());
        return "listdoc";
    }






}
