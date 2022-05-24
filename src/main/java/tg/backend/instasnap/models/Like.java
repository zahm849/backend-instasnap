package tg.backend.instasnap.models;

import javax.persistence.*;


@Entity
public class Like extends ClasseCommune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id", referencedColumnName = "id")
    private Publication publication;

    public Like(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Publication getPublication() {
        return publication;
    }

    @Override
    public String toString() {
        return "like{" +
                "id=" + id +
                '}';
    }
}
