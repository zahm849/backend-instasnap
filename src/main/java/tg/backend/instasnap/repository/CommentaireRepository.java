package tg.backend.instasnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tg.backend.instasnap.models.Commentaire;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    @Query("select c from Commentaire c where c.user = :user")
    List<Commentaire> getCommentairesByUser();
}
