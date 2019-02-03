package pl.kolodzianka.docmvc.Entity;

import javassist.bytecode.ByteArray;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    private String title;

    @Past
    @CreatedDate
    private Date createdDate;

    @PastOrPresent
    @LastModifiedDate
    private Date modificationDate;

    @OneToMany(mappedBy = "document")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @CreatedBy
    private User user;

    @Lob
    private ByteArray pdfFile;

    public Document() {
    }

    public Document(String title, @Past Date createdDate, @PastOrPresent Date modificationDate,
                    Set<Comment> comments, User user, ByteArray pdfFile) {
        this.title = title;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
        this.comments = comments;
        this.user = user;
        this.pdfFile = pdfFile;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId=" + docId +
                ", name='" + title + '\'' +
                ", createdDate=" + createdDate +
                ", modificationDate=" + modificationDate +
                ", comments=" + comments +
                ", user=" + user +
                ", pdfFile=" + pdfFile +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDocId() {
        return docId;
    }

    public void setDocId(long docId) {
        this.docId = docId;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
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
