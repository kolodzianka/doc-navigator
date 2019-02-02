package pl.kolodzianka.docmvc.Entity;

import javassist.bytecode.ByteArray;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.Set;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long docId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Past
    private Date createdDate;

    @PastOrPresent
    private Date modificationDate;

    @OneToMany(mappedBy = "document")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Lob
    private ByteArray pdfFile;

    public Document() {
    }



    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", modificationDate=" + modificationDate +
                ", comments=" + comments +
                ", user=" + user +
                ", pdfFile=" + pdfFile +
                '}';
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ByteArray getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(ByteArray pdfFile) {
        this.pdfFile = pdfFile;
    }
}
