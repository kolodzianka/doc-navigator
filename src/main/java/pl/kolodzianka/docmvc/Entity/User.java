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
//    @OneToMany(mappedBy = "user")
//    @Column
//    private Set<Roles> roles;
    @Column
    private String roles;
    @OneToMany(mappedBy = "author")
    private Set<Document> documents;
    @OneToMany(mappedBy = "author")
    private Set<Comment> comments;

    public User() {
    }

    public User(String password, @NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "Surname is mandatory") String surname, @Email(message = "Email should be valid") String email, String roles, Set<Document> documents, Set<Comment> comments) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.documents = documents;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", documents=" + documents +
                ", comments=" + comments +
                '}';
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

//    public Set<Roles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Roles> roles) {
//        this.roles = roles;
//    }

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
