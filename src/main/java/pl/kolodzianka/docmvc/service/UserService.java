package pl.kolodzianka.docmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kolodzianka.docmvc.Entity.Role;
import pl.kolodzianka.docmvc.Entity.User;
import pl.kolodzianka.docmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);




    @Transactional
    public void create (User user){
        //user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);
        System.out.println(user);
        logger.info("User created.");
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
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
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

    @Transactional
    public User findByName(String name){
       return userRepository.findByName(name);
    }

    @Transactional
    public User findUserByUsername(String usernane){
        return userRepository.findUserByUsername(usernane);
    }




}
