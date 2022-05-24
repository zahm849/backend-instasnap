package tg.backend.instasnap.models;

import javax.persistence.*;
import java.awt.*;

@Entity
public class Commentaire extends ClasseCommune{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publication_id", referencedColumnName = "id")
    private Publication publication;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private TextArea contenu;

    public Commentaire(){
    }

    public Commentaire(TextArea contenu) {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextArea getContenu() {
        return contenu;
    }

    public void setContenu(TextArea contenu) {
        this.contenu = contenu;
    }

    public User getUser() {
        return user;
    }

    public Publication getPublication() {
        return publication;
    }

    @Override
    public String toString() {
        return "commentaire{" +
                "id=" + id +
                ", contenu=" + contenu +
                '}';
    }
}
