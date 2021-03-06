package pl.kolodzianka.docmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.repository.DocumentRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Transactional
    public void create (Document document){
        document.setCreatedDate(new Date());
        documentRepository.save(document);
    }
    @Transactional
    public List<Document> findAll() {
        return (List<Document>) documentRepository.findAll();
    }

    @Transactional
    public Optional<Document> findById(Long id){
        return documentRepository.findById(id);
    }

    @Transactional
    public void deleteAll (){
        documentRepository.deleteAll();
    }

    @Transactional
    public void delete (Document document){
        documentRepository.delete(document);
    }

    @Transactional
    public Long count (){
        return documentRepository.count();
    }
}
