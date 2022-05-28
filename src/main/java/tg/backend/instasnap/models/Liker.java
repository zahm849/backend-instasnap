package tg.backend.instasnap.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Liker extends CommunClass{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false, name = "publication")
    private Publication publication;



}
