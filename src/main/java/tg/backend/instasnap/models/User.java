package tg.backend.instasnap.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends ClasseCommune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Publication> publications=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Like> likes=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Commentaire> commentaires=new HashSet<>();


    private String nom;
    private String prenom;
    private String username;
    private String profil;
    private String email;
    private String password;

    public User(){
    }

    public User(String nom, String prenom, String username, String profil, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.profil = profil;
        this.email = email;
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", profil='" + profil + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
