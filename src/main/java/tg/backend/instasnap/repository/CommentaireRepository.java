package tg.backend.instasnap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tg.backend.instasnap.models.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
