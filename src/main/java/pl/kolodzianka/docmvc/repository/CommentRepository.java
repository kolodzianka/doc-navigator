package pl.kolodzianka.docmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kolodzianka.docmvc.Entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Long> {

}
