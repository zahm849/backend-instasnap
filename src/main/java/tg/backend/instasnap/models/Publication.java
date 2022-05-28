package tg.backend.instasnap.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Publication extends CommunClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String libelle;
    @NotBlank
    private String url;

    private Boolean etat;
    @NotBlank
    private Integer nombre_vue;
    @NotBlank
    private Date last_seen;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user")
    private User user;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Liker> listLikes = new HashSet<>();

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Commentaire> listCommentaires = new HashSet<>();

}
