package pl.kolodzianka.docmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kolodzianka.docmvc.Entity.Document;

@Repository
public interface DocumentRepository extends CrudRepository <Document, Long> {
}
