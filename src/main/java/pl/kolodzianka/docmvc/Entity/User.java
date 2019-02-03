package pl.kolodzianka.docmvc.Entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
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

    public User(String userName, String password, @NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Surname is mandatory") String surname, @Email(message = "Email should be valid") String email, Set<Role> role, Set<Document> documents, Set<Comment> comments) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
        this.documents = documents;
        this.comments = comments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
