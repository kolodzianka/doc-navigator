package pl.kolodzianka.docmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kolodzianka.docmvc.Entity.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

    public User findUserByEmail(String email);

    public User findByName(String name);

    public User findUserByUsername(String usernane);
}
