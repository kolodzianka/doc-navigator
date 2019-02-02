package pl.kolodzianka.docmvc.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @Email(message = "Email should be valid")
    private String email;
    @OneToMany(mappedBy = "user")
    @Column
    private Set<Role> role;
    @OneToMany(mappedBy = "user")
    private Set<Document> documents;
    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;

    public User() {
    }

    public User(String userName, @NotBlank(message = "Name is mandatory") String name,
                @NotBlank(message = "Surname is mandatory") String surname,
                @Email(message = "Email should be valid") String email, Set<Role> role, Set<Document> documents, Set<Comment> comment) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.documents = documents;
        this.comments = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
