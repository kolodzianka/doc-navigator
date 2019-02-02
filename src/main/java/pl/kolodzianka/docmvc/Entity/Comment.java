package pl.kolodzianka.docmvc.Entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "docId")
    private Document document;


    @NotBlank
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User author;

    private Date createDate;

    public Comment() {
    }

    public Comment(@Max(value = 20, message = "Max 20 letters") Document title,
                   @NotBlank String commment, User author, Date createDate) {
        this.document = title;
        this.text = commment;
        this.author = author;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", title='" + document + '\'' +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", createDate=" + createDate +
                '}';
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Document getTitle() {
        return document;
    }

    public void setTitle(Document title) {
        this.document = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
