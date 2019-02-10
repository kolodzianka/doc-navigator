package pl.kolodzianka.docmvc.Entity;

import javax.persistence.*;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    private String rola;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Roles() {
    }

    public Roles(String rola) {
        this.rola = rola;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", user=" + user +
                '}';
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
