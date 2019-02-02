package pl.kolodzianka.docmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kolodzianka.docmvc.Entity.Comment;
import pl.kolodzianka.docmvc.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public void create (Comment comment){
        commentRepository.save(comment);
    }
    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Transactional
    public Optional<Comment> findById(Long id){
        return commentRepository.findById(id);
    }

    @Transactional
    public void deleteAll (){
        commentRepository.deleteAll();
    }

    @Transactional
    public void delete (Comment comment){
        commentRepository.delete(comment);
    }

    @Transactional
    public Long count (){
        return commentRepository.count();
    }
}
