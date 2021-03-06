package pl.kolodzianka.docmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kolodzianka.docmvc.Entity.Document;
import pl.kolodzianka.docmvc.Entity.User;

@Repository
public interface DocumentRepository extends CrudRepository <Document, Long> {


}
