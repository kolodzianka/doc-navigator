package pl.kolodzianka.docmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void create (User user){
        userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<User> findBuUserName (String userName){
        return Optional.ofNullable(userRepository.findUserByUserName(userName));
    }


    @Transactional
    public void deleteAll (){
        userRepository.deleteAll();
    }

    @Transactional
    public void delete (User user){
        userRepository.delete(user);
    }

    @Transactional
    public Long count (){
        return userRepository.count();
    }






}
