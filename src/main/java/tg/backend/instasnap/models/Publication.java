package tg.backend.instasnap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publication extends ClasseCommune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "publication")
    private Set<Commentaire> commentaires=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "publication")
    private Set<Like> likes=new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private int url;
    private String libelle;
    private boolean etat;
    private int nombreVues;
    private int nombreLikes;
    private Date lastseen;
    private Date datePublication;

    public Publication(){
    }

    public Publication(int url, String libelle, boolean etat, int nombreVues, int nombreLikes, Date lastseen, Date datePublication) {
        this.url = url;
        this.libelle = libelle;
        this.etat = etat;
        this.nombreVues = nombreVues;
        this.nombreLikes = nombreLikes;
        this.lastseen = lastseen;
        this.datePublication = datePublication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public int getNombreVues() {
        return nombreVues;
    }

    public void setNombreVues(int nombreVues) {
        this.nombreVues = nombreVues;
    }

    public int getNombreLikes() {
        return nombreLikes;
    }

    public void setNombreLikes(int nombreLikes) {
        this.nombreLikes = nombreLikes;
    }

    public Date getLastseen() {
        return lastseen;
    }

    public void setLastseen(Date lastseen) {
        this.lastseen = lastseen;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public User getUser() {
        return user;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    @Override
    public String toString() {
        return "publication{" +
                "id=" + id +
                ", url=" + url +
                ", libelle='" + libelle + '\'' +
                ", etat=" + etat +
                ", nombreVues=" + nombreVues +
                ", nombreLikes=" + nombreLikes +
                ", lastseen=" + lastseen +
                ", datePublication=" + datePublication +
                '}';
    }
}
